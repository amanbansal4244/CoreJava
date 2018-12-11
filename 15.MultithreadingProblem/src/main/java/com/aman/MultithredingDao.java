package com.aman;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;  
  
public class MultithredingDao {  
	private JdbcTemplate template;  

	public void setTemplate(JdbcTemplate template) {  
		this.template = template;  
	} 
	
	@SuppressWarnings("unchecked")
	public List<Multithreding> getMultiThreadingData(){  
		String sql= "select * from MultithreadingTable where status='pending'";
		return template.query(sql, new RowMapper(){  
			public Multithreding mapRow(ResultSet rs, int row) throws SQLException {  
				Multithreding e=new Multithreding();  
				e.setId(rs.getInt(1));  
				e.setFirstName(rs.getString(2));  
				e.setStatus(rs.getString(3));  
				return e;  
			}  
		});  
	}  
}  
