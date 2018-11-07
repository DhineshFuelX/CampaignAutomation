package com.example.campaignautomation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.campaignautomation.service.CampaignService;
import com.example.campaignautomation.service.EnterpriseService;

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
    
//    @Autowired
//    JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(CampaignAutomationApplication.class, args);
	}
	
    @Override
    public void run(String... args) throws Exception {
    
//        System.out.println("Our DataSource is = " + dataSource);
        
        //find all active bid's  (NOW its Active/inactive)
        Iterable<com.example.campaignautomation.model.fuelAsset.Enterprise> accountlist = enterpriseService.getAllenterprise();
        for(com.example.campaignautomation.model.fuelAsset.Enterprise systemmodel:accountlist){
            System.out.println("Enterprise: " + systemmodel.toString());
            ///find all cid' which are active for this bid
            Iterable<com.example.campaignautomation.model.fuelAsset.Campaign> campaignlist = campaignService.findByBid(systemmodel.getId());
            for(com.example.campaignautomation.model.fuelAsset.Campaign camp:campaignlist){
            	System.out.println("		Campaign: " + camp.toString());
            }
        }

 
    }
}
