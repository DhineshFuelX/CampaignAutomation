package com.example.campaignautomation.service;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	@Qualifier("voyagerJdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
//	public JdbcTemplate setJdbcTemplate(@Qualifier("voyagerDatasource") DataSource dsPostgres) {
//		return new JdbcTemplate(dsPostgres);
//	}
//	
//	public JdbcTemplate getJdbcTemplate() {
//		return jdbcTemplate;
//	}
	
//	public List<StrategiesPerformance> findBidsGoals(long Bid) {
//        return (List) strategiesPerformanceRepo.findBidPerformance(Bid);
//    }
	
	public List<StrategiesPerformance> findBidsPerformance(long Bid, Date start_date, Date end_date) {
//		MapSqlParameterSource parameters = new MapSqlParameterSource();
//	      parameters.addValue("bid", Bid);
//	      parameters.addValue("start_date", start_date);
//	      parameters.addValue("end_date", end_date);
		System.out.println(Bid+" | "+ start_date +" | "+end_date);
		return jdbcTemplate.query("SELECT bid, reportDate AS date, sum(imp) as impressions, sum(clk) as clicks, sum(wclk) as wclicks, \n" + 
				"       sum(eclk) as eclicks, sum(cost) as spend, sum(vtc) as vtc, sum(ctc) as ctc, sum(tc) as tc, \n" + 
				"       sum(vtc_ov) as vtc_ov, sum(ctc_ov) as ctc_ov, sum(tc_ov) as tc_ov \n" + 
				"      FROM strategiesReportProd \n" + 
				"        WHERE bid = ? \n" +
				"        AND reportDate \n" + 
				"        BETWEEN ? AND ? \n" + 
				"        GROUP BY reportDate \n" + 
				"        ORDER BY reportDate \n" + 
				"        ASC", new Object[] {Bid, start_date, end_date}, new StrategiesPerformanceMapper());
//		return jdbcTemplate.query("SELECT reportDate AS date, sum(imp) as impressions, sum(clk) as clicks, sum(wclk) as wclicks, \n" + 
//				"      sum(eclk) as eclicks, sum(cost) as spend, sum(vtc) as vtc, sum(ctc) as ctc, sum(tc) as tc, \n" + 
//				"      sum(vtc_ov) as vtc_ov, sum(ctc_ov) as ctc_ov, sum(tc_ov) as tc_ov \n" + 
//				"      FROM strategiesReportProd \n" + 
//				"        WHERE bid = ? \n" + 
//				"        AND reportDate \n" + 
//				"        BETWEEN ? AND ? \n" + 
//				"        GROUP BY reportDate \n" + 
//				"        ORDER BY reportDate \n" + 
//				"        ASC", new Object[] {Bid, start_date.toString(), end_date.toString()} , new StrategiesPerformanceMapper());
    }
}
