package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.AssetDisposal;

public interface AssetDisposalService{
     AssetDisposal requestDisposal(Long assetId,AssetDisposal disposal);
     AssetDisposal approveDisposal(Long disposalId,Long adminId);
}