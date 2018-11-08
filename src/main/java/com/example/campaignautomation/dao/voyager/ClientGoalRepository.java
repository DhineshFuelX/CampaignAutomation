package com.example.campaignautomation.dao.voyager;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.campaignautomation.model.voyager.ClientGoal;

@Repository
public interface ClientGoalRepository extends CrudRepository<ClientGoal, Long>{
	
	@Query(value="SELECT e FROM ClientGoal e where e.bid=:bid order by id desc,created desc")
	List<ClientGoal> findBidsGoals(@Param("bid") long bid);
	
}
