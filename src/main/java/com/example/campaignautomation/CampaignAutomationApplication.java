package com.example.campaignautomation;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.campaignautomation.dao.voyager.StrategiesPerformanceRepository;
import com.example.campaignautomation.model.voyager.ClientGoal;
import com.example.campaignautomation.model.voyager.StrategiesPerformance;
import com.example.campaignautomation.service.CampaignService;
import com.example.campaignautomation.service.ClientGoalService;
import com.example.campaignautomation.service.EnterpriseService;
import com.example.campaignautomation.service.StrategiesPerformanceService;

@SpringBootApplication

//@EnableJpaRepositories("com.example.campaignautomation.dao")
//@EntityScan("com.example.campaignautomation.model")
public class CampaignAutomationApplication implements CommandLineRunner{
	
	//private static final Logger log = LoggerFactory.getLogger(CampaignAutomationApplication.class);
	
//	@Autowired
//	DataSource datasource;
//	
//	@Bean
//	@Primary
//	@ConfigurationProperties(prefix="fuelAsset.datasource")
//	public DataSource fuelAssetDataSource() {
//	    return DataSourceBuilder.create().build();
//	}
//
//	@Bean
//	@ConfigurationProperties(prefix="voyager.datasource")
//	public DataSource voyagerDataSource() {
//	    return DataSourceBuilder.create().build();
//	}
 
    @Autowired
    EnterpriseService enterpriseService;
    
    @Autowired
    CampaignService campaignService;
    
    @Autowired
    ClientGoalService clientGoalService;
    
    @Autowired
    StrategiesPerformanceService strategiesPerformanceService;
    
//    @Autowired
//    JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(CampaignAutomationApplication.class, args);
	}
	
    @Override
    public void run(String... args) throws Exception {
    
//        System.out.println("Our DataSource is = " + dataSource);
        
        //find all active bid's  (NOW its Active/inactive)
        Iterable<com.example.campaignautomation.model.fuelAsset.Enterprise> accountlist = enterpriseService.findAllBids();
        for(com.example.campaignautomation.model.fuelAsset.Enterprise systemmodel:accountlist){

    		System.out.println("Enterprise: " + systemmodel.toString());
    		
    		//Client Goal
    		ClientGoal cg = clientGoalService.findBidsGoals(systemmodel.getId());
    		System.out.println("ClientGoal: " + cg);
            
    		//Client Progress
    		Iterable<com.example.campaignautomation.model.voyager.StrategiesPerformance> stratPerfList = strategiesPerformanceService.findBidsGoals(systemmodel.getId());
    		System.out.println("Strategies Performance");
    		for(com.example.campaignautomation.model.voyager.StrategiesPerformance sperf:stratPerfList){
    			System.out.println(sperf.toString());
    		}
    		
    		///find all cid' which are active for this bid
//            Iterable<com.example.campaignautomation.model.fuelAsset.Campaign> campaignlist = campaignService.findByBid(systemmodel.getId());
//            for(com.example.campaignautomation.model.fuelAsset.Campaign camp:campaignlist){
//            	System.out.println("		Campaign: " + camp.toString());
//            }

        }

 
    }
}
