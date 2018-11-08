package com.example.campaignautomation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.example.campaignautomation.dao.voyager.ClientGoalRepository;
import com.example.campaignautomation.model.voyager.ClientGoal;

@Service
public class ClientGoalService {
	
	@Autowired
	ClientGoalRepository clientGoalRepo;
	
	public ClientGoal findBidsGoals(long Bid) {
        return clientGoalRepo.findBidsGoals(Bid).get(0);
    }

}
