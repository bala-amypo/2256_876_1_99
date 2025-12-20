@Service
public class AssetLifecycleEventServiceImpl implements AssetLifecycleEventService {

    private final AssetLifecycleEventRepository eventRepository;
    private final AssetRepository assetRepository;

    public AssetLifecycleEventServiceImpl(AssetLifecycleEventRepository eventRepository,
                                          AssetRepository assetRepository) {
        this.eventRepository = eventRepository;
        this.assetRepository = assetRepository;
    }

    @Override
    public AssetLifecycleEvent logEvent(Long assetId, AssetLifecycleEvent event) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        if (event.getEventType() == null || event.getEventDescription().isBlank()) {
            throw new IllegalArgumentException("Event details required");
        }

        if (event.getEventDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Event date cannot be in future");
        }

        event.setAsset(asset);
        event.setLoggedAt(LocalDateTime.now());

        return eventRepository.save(event);
    }

    @Override
    public List<AssetLifecycleEvent> getEventsForAsset(Long assetId) {
        assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        return eventRepository.findByAssetIdOrderByEventDateDesc(assetId);
    }
}
