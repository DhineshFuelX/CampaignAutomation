package com.example.campaignautomation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Campaign")
public class Campaign {
	private String name;
    private int status;
    private long bid;
    
    public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
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
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
     
    public String toString(){
        return id+" | " + name+ " | "+ status;
    }
}
