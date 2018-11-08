package com.example.campaignautomation.dao.voyager;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.campaignautomation.model.voyager.StrategiesPerformance;;

@Repository
public interface StrategiesPerformanceRepository extends CrudRepository<StrategiesPerformance, Long>{

	@Query(value="SELECT reportDate, SUM(imp) as impressions \n" +
			"      FROM StrategiesPerformance\n" + 
			"        WHERE bid = :bid\n" + 
			"        GROUP BY reportDate\n" + 
			"        ORDER BY reportDate\n" + 
			"        ASC")
	List<StrategiesPerformance> findBidPerformance(@Param("bid") long bid);
	
	
//	@Query(value="SELECT e \n" + 
//			"      FROM StrategiesPerformance e\n" + 
//			"        WHERE e.bid = :bid\n" + 
//			"        ORDER BY reportDate\n" + 
//			"        ASC")
}
