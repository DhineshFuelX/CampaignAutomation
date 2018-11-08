package com.example.campaignautomation.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.jdbc.core.RowMapper;

import com.example.campaignautomation.model.voyager.StrategiesPerformance;

public class StrategiesPerformanceMapper implements RowMapper<StrategiesPerformance>{

	@Override
	public StrategiesPerformance mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("in Mapper now...............");
		StrategiesPerformance sp = new StrategiesPerformance();
		sp.setDate(rs.getDate("date"));
	    sp.setImpressions(rs.getLong("impressions"));
	    sp.setClicks(rs.getLong("clicks"));
	    sp.setEclicks(rs.getLong("eclicks"));
	    sp.setWclicks(rs.getLong("wclicks"));
	    sp.setSpend(rs.getDouble("spend"));
	    sp.setVtc(rs.getLong("vtc"));
	    sp.setVtc_ov(rs.getDouble("vtc_ov"));
	    sp.setCtc(rs.getLong("ctc"));
	    sp.setCtc_ov(rs.getDouble("ctc_ov"));
	    sp.setTc(rs.getLong("tc"));
	    sp.setTc_ov(rs.getDouble("tc_ov"));
		return sp;
	}

}
