package com.example.campaignautomation.dao.fuelAsset;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.campaignautomation.model.fuelAsset.Enterprise;
 
@Repository
public interface EnterpriseRepository extends CrudRepository<Enterprise, Long>{

}
