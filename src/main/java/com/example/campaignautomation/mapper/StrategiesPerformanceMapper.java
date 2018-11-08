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
		DecimalFormat df3 = new DecimalFormat("#.000");
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
	    
	    if(sp.getSpend()!=0)
	    {
	    	if(sp.getEclicks()!=0) {
	    		sp.setCpec(Double.parseDouble(df.format(sp.getSpend()/sp.getEclicks())));
	    	} else {
	    		sp.setCpec(0);
	    	}
	    	if(sp.getWclicks()!=0) {
	    		sp.setCpwc(Double.parseDouble(df.format(sp.getSpend()/sp.getWclicks())));
	    	} else {
	    		sp.setCpwc(0);
	    	}
			if(sp.getClicks()!=0) {
				sp.setCpc(Double.parseDouble(df.format(sp.getSpend()/sp.getClicks())));
			} else {
				sp.setCpc(0);
			}
	    }
	    else
	    {
	    	sp.setCpec(0);
	    	sp.setCpwc(0);
	    	sp.setCpc(0);
	    }
	    
	    if(sp.getImpressions()!=0)
	    {
	    	if(sp.getEclicks()!=0) {
	    		sp.setEctr(Double.parseDouble(df.format((sp.getEclicks()/sp.getImpressions()) * 100)));
	    	} else {
	    		sp.setEctr(0);
	    	}
	    	if(sp.getWclicks()!=0) {
	    		sp.setWctr(Double.parseDouble(df.format((sp.getWclicks()/sp.getImpressions()) * 100)));
	    	} else {
	    		sp.setWctr(0);
	    	}
			if(sp.getClicks()!=0) {
				sp.setCtr(Double.parseDouble(df.format((sp.getClicks()/sp.getImpressions()) * 100)));
			} else {
				sp.setCtr(0);
			}
			if(sp.getSpend()!=0) {
				sp.setCpm(Double.parseDouble(df.format(sp.getSpend()/(sp.getImpressions()/1000))));
			} else {
				sp.setCpm(0);
			}
	    }
	    else
	    {
	    	sp.setEctr(0);
	    	sp.setWctr(0);
	    	sp.setCtr(0);
	    	sp.setCpm(0);
	    }
	    
	    if(sp.getTc_ov() > 0)
	    {
	    	if(sp.getWclicks() > 0) {
	    		sp.setRpv(Double.parseDouble(df.format(sp.getTc_ov()/sp.getWclicks())));
	    	}else {
	    		sp.setRpv(0);
	    	}
	    	
	    	if(sp.getSpend() > 0) {
	    		sp.setRoi(Double.parseDouble(df.format(sp.getTc_ov()/sp.getWclicks())));
	    	}else {
	    		sp.setRoi(0);
	    	}
	    	
	    }
	    else
	    {
	    	sp.setRpv(0);
	    }
	    
	    if(sp.getTc() > 0 && sp.getWclicks() > 0)
	    {
	    	sp.setCr(Double.parseDouble(df3.format((sp.getTc()/sp.getWclicks()) * 100)));
	    } else {
	    	sp.setCr(0);
	    }
		return sp;
	}

}
