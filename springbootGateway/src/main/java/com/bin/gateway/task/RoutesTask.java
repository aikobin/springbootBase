package com.bin.gateway.task;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 *<ul>历史记录
 *		<li>pyp - 1.0 - 2017年8月15日</li>
 * </ul>
 */
@Component
public class RoutesTask {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Scheduled(cron="0 0 0/8 * * ?") 
	public void checkCompany() {
		
		List<Map<String,Object>> result=this.jdbcTemplate.queryForList("select id,routes from company ");
		for(int i=0;i<result.size();i++){
			if((boolean) result.get(i).get("routes")){
				ConstantConfig.ROUTES.put("company"+result.get(i).get("id"), "OA-company-"+result.get(i).get("id"));
			}else{
				ConstantConfig.ROUTES.put("company"+result.get(i).get("id"), "OA-company");
			}
		}
		//System.out.println("122");
	}
	
}
