package com.example.campaignautomation.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "Enterprises")
public class Enterprise {
	
	private String company_name;
    private int status;
    
    
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //make sure generation dones'nt have any issues
    @Column(name="id")
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return company_name;
    }
    public void setName(String name) {
        this.company_name = name;
    }
     
    public String toString(){
        return id+" | " + company_name+ " | "+ status;
    }
}
