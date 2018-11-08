package com.example.campaignautomation.model.voyager;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientCpaRoi")
public class ClientGoal {
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
  
	private long bid;
    private long cid;
    private int objective;
    private double goal_value;
    private String goal;
    private Date created;
    
    public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public int getObjective() {
		return objective;
	}
	public void setObjective(int objective) {
		this.objective = objective;
	}
	public double getGoal_value() {
		return goal_value;
	}
	public void setGoal_value(double goal_value) {
		this.goal_value = goal_value;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	
    public String toString(){
        return id+" | " + bid+ " | "+ cid +" | " + objective+ " | "+ goal_value +" | " + goal + " | " + created;
    }
}
