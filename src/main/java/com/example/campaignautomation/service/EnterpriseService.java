package com.example.campaignautomation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campaignautomation.dao.fuelAsset.EnterpriseRepository;
import com.example.campaignautomation.model.fuelAsset.Enterprise;

@Service
public class EnterpriseService {
	@Autowired
	EnterpriseRepository enterpriseRepo;

    public List<Enterprise> getAllenterprise() {
        return (List) enterpriseRepo.findAll();
    }

//	public String findBidStatus(long id) {
//		// TODO Auto-generated method stub
//		return enterpriseRepo.findBidStatus(id);
//	}
	
	public List<Enterprise> findAllBids() {
		// TODO Auto-generated method stub
		return enterpriseRepo.findAllBids();
	}

}
