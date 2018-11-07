package com.example.campaignautomation.dao.fuelAsset;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.campaignautomation.model.fuelAsset.Enterprise;
import com.example.campaignautomation.model.fuelAsset.Campaign;

@Repository
public interface CampaignRepository extends CrudRepository<Enterprise, Long>{
	
	@Query(value="SELECT e FROM Campaign e WHERE e.bid=:bid and status=1")
	List<Campaign> findByBid(@Param("bid") long bid);
}
