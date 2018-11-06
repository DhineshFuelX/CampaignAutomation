package com.example.campaignautomation;

import java.util.*;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.campaignautomation.dao.CampaignRepository;
import com.example.campaignautomation.dao.EnterpriseRepository;

@SpringBootApplication

@EnableJpaRepositories("com.example.campaignautomation.dao")
@EntityScan("com.example.campaignautomation.model")
public class CampaignAutomationApplication implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(CampaignAutomationApplication.class);
	
	@Autowired
    DataSource dataSource;
 
    @Autowired
    EnterpriseRepository enterpriseRepository;
    
    @Autowired
    CampaignRepository campaignRepository;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(CampaignAutomationApplication.class, args);
	}
	
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Our DataSource is = " + dataSource);
        
        //find all active bid's  (NOW its Active/inactive)
        Iterable<com.example.campaignautomation.model.Enterprise> accountlist = enterpriseRepository.findAll();
        for(com.example.campaignautomation.model.Enterprise systemmodel:accountlist){
            System.out.println("Enterprise: " + systemmodel.toString());
            ///find all cid' which are active for this bid
            Iterable<com.example.campaignautomation.model.Campaign> campaignlist = campaignRepository.findByBid(systemmodel.getId());
            for(com.example.campaignautomation.model.Campaign camp:campaignlist){
            	System.out.println("		Campaign: " + camp.toString());
            }
        }

 
    }
}
