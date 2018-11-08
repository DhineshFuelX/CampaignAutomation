package com.example.campaignautomation.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.campaignautomation.dao.voyager.StrategiesPerformanceRepository;
import com.example.campaignautomation.mapper.StrategiesPerformanceMapper;
import com.example.campaignautomation.model.voyager.StrategiesPerformance;

@Service
public class StrategiesPerformanceService {
	@Autowired
	StrategiesPerformanceRepository strategiesPerformanceRepo;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
//	public List<StrategiesPerformance> findBidsGoals(long Bid) {
//        return (List) strategiesPerformanceRepo.findBidPerformance(Bid);
//    }
	
	public List<StrategiesPerformance> findBidsGoals(long Bid, Date start_date, Date end_date) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
	      parameters.addValue("bid", Bid);
	      parameters.addValue("start_date", start_date);
	      parameters.addValue("end_date", end_date);
		return jdbcTemplate.query("SELECT reportDate AS date, sum(imp) as impressions, sum(clk) as clicks, sum(wclk) as wclicks, \n" + 
				"      sum(eclk) as eclicks, sum(cost) as spend, sum(vtc) as vtc, sum(ctc) as ctc, sum(tc) as tc, \n" + 
				"      sum(vtc_ov) as vtc_ov, sum(ctc_ov) as ctc_ov, sum(tc_ov) as tc_ov \n" + 
				"      FROM strategiesReportProd\n" + 
				"        WHERE bid = (:bid)\n" + 
				"        AND reportDate\n" + 
				"        BETWEEN (:start_date) AND (:end_date)\n" + 
				"        GROUP BY reportDate\n" + 
				"        ORDER BY reportDate\n" + 
				"        ASC", new Object[] {Bid, start_date, end_date} , new StrategiesPerformanceMapper());
    }
}
