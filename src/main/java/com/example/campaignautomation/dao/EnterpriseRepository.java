package com.example.campaignautomation.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.campaignautomation.model.Enterprise;
 
@Repository
public interface EnterpriseRepository extends CrudRepository<Enterprise, Long>{

}
