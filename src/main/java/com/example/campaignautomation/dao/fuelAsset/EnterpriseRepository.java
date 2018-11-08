package com.example.campaignautomation.dao.fuelAsset;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.campaignautomation.model.fuelAsset.Enterprise;
 
@Repository
public interface EnterpriseRepository extends CrudRepository<Enterprise, Long>{
	
//	@Query(value="SELECT status_name FROM account_status where id=(SELECT status_id FROM account_status_log where bid=:bid order by created desc limit 1)")
//	String findBidStatus(@Param("bid") long bid);

	@Query(value="SELECT e FROM Enterprise e where e.id in (1932, 2116)")
	List<Enterprise> findAllBids();
}
