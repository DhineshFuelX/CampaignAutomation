package com.example.campaignautomation.model.voyager;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "strategiesReportProd")
public class StrategiesPerformance {
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
    private Date date;
    private long bid;
    private long impressions;
    private long clicks;
    private long wclicks;
    private long eclicks;
    private double spend;
    private long vtc;
    private long ctc;
    private long tc;
    private double vtc_ov;
    private double ctc_ov;
    private double tc_ov;
    private double cpa;
    
    private double cpec;
    private double cpwc;
    private double cpc;
    
    private double ectr;
    private double wctr;
    private double ctr;
    
    private double rpv;
    private double roi;
    private double cr;
    private double cpm;
	
    
    
	public double getCpec() {
		return cpec;
	}
	public void setCpec(double cpec) {
		this.cpec = cpec;
	}
	public double getCpwc() {
		return cpwc;
	}
	public void setCpwc(double cpwc) {
		this.cpwc = cpwc;
	}
	public double getCpc() {
		return cpc;
	}
	public void setCpc(double cpc) {
		this.cpc = cpc;
	}
	public double getEctr() {
		return ectr;
	}
	public void setEctr(double ectr) {
		this.ectr = ectr;
	}
	public double getWctr() {
		return wctr;
	}
	public void setWctr(double wctr) {
		this.wctr = wctr;
	}
	public double getCtr() {
		return ctr;
	}
	public void setCtr(double ctr) {
		this.ctr = ctr;
	}
	public double getRpv() {
		return rpv;
	}
	public void setRpv(double rpv) {
		this.rpv = rpv;
	}
	public double getRoi() {
		return roi;
	}
	public void setRoi(double roi) {
		this.roi = roi;
	}
	public double getCr() {
		return cr;
	}
	public void setCr(double cr) {
		this.cr = cr;
	}
	public double getCpm() {
		return cpm;
	}
	public void setCpm(double cpm) {
		this.cpm = cpm;
	}
	public double getCpa() {
		return cpa;
	}
	public void setCpa(double cpa) {
		this.cpa = cpa;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
	
	public long getImpressions() {
		return impressions;
	}
	public void setImpressions(long impressions) {
		this.impressions = impressions;
	}
	public long getClicks() {
		return clicks;
	}
	public void setClicks(long clicks) {
		this.clicks = clicks;
	}
	public long getWclicks() {
		return wclicks;
	}
	public void setWclicks(long wclicks) {
		this.wclicks = wclicks;
	}
	public long getEclicks() {
		return eclicks;
	}
	public void setEclicks(long eclicks) {
		this.eclicks = eclicks;
	}
	public double getSpend() {
		return spend;
	}
	public void setSpend(double spend) {
		this.spend = spend;
	}
	public long getVtc() {
		return vtc;
	}
	public void setVtc(long vtc) {
		this.vtc = vtc;
	}
	public long getCtc() {
		return ctc;
	}
	public void setCtc(long ctc) {
		this.ctc = ctc;
	}
	public long getTc() {
		return tc;
	}
	public void setTc(long tc) {
		this.tc = tc;
	}
	public double getVtc_ov() {
		return vtc_ov;
	}
	public void setVtc_ov(double vtc_ov) {
		this.vtc_ov = vtc_ov;
	}
	public double getCtc_ov() {
		return ctc_ov;
	}
	public void setCtc_ov(double ctc_ov) {
		this.ctc_ov = ctc_ov;
	}
	public double getTc_ov() {
		return tc_ov;
	}
	public void setTc_ov(double tc_ov) {
		this.tc_ov = tc_ov;
	}
	
//	public String toString(){
//        return id+" | " + bid+ " | "+ cid +" | " + spd+ " | "+ cost +" | " + imp + " | " + clk + " | " + wclk + " | " + eclk + " | " + vtc + " | " + ctc + " | " + tc + " | " + vtc_ov + " | " + ctc_ov + " | " + tc_ov;
//    }
	public String toPerfString(){
        return bid + " | " +date+ " | " +cpa+" | " + cpm + " | " + roi + " | " + rpv + " | " + cr + " | " + ctr + " | " + wctr + " | " + ectr + " | " + cpec + " | " + cpwc + " | " + cpc;
    }
	
	public String toString(){
        return bid + " | " +date+ " | " +cpa+" | " + impressions + " | " + clicks + " | " + wclicks + " | " + eclicks + " | " + spend + " | " + vtc + " | " + ctc + " | " + tc + " | " + vtc_ov + " | " + ctc_ov + " | " + tc_ov;
    }
}
