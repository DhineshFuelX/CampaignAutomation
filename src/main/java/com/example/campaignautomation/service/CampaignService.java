package com.example.campaignautomation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campaignautomation.dao.fuelAsset.CampaignRepository;
import com.example.campaignautomation.model.fuelAsset.Campaign;

@Service
public class CampaignService {
	
	
	@Autowired
    CampaignRepository campaignRepo;

//    public List<Campaign> getAllcampaign() {
//        return (List)campaignRepo.findAll();
//    }

    public List<Campaign> findByBid(long Bid) {
        return campaignRepo.findByBid(Bid);
    }
}
