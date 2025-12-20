@Service
public class AssetDisposalServiceImpl implements AssetDisposalService {

    private final AssetDisposalRepository disposalRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public AssetDisposalServiceImpl(AssetDisposalRepository disposalRepository,
                                    AssetRepository assetRepository,
                                    UserRepository userRepository) {
        this.disposalRepository = disposalRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AssetDisposal requestDisposal(Long assetId, AssetDisposal disposal) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        if (disposal.getDisposalValue() < 0) {
            throw new IllegalArgumentException("Disposal value cannot be negative");
        }

        disposal.setAsset(asset);
        disposal.setCreatedAt(LocalDateTime.now());

        return disposalRepository.save(disposal);
    }

    @Override
    public AssetDisposal approveDisposal(Long disposalId, Long adminId) {

        AssetDisposal disposal = disposalRepository.findById(disposalId)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal not found"));

        User admin = userRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // role check handled by security / role setup
        disposal.setApprovedBy(admin);

        Asset asset = disposal.getAsset();
        asset.setStatus("DISPOSED");

        assetRepository.save(asset);
        return disposalRepository.save(disposal);
    }
}
