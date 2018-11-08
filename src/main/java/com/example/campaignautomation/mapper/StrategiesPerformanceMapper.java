package com.example.campaignautomation.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.*;

import org.springframework.jdbc.core.RowMapper;

import com.example.campaignautomation.model.voyager.StrategiesPerformance;

public class StrategiesPerformanceMapper implements RowMapper<StrategiesPerformance>{

	@Override
	public StrategiesPerformance mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#.00");
		StrategiesPerformance sp = new StrategiesPerformance();
		sp.setBid(rs.getLong("bid"));
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
	    
	    if((sp.getSpend()!=0) && (sp.getTc()!=0))
	    {
	    	sp.setCpa(Double.parseDouble(df.format(sp.getSpend()/sp.getTc())));
	    }
	    else
	    {
	    	sp.setCpa(0);
	    }
	    
	    
	    
		return sp;
	}

}
