package com.microservice.widget.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.widget.model.Widget;

@Repository
public class WidgetRepositoryJDBCImpl {
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	 @Transactional(readOnly=true)
	    public List<Widget> findAll() {
	        return jdbcTemplate.query("select * from widget", 
	                new UserRowMapper());
	    }
	 
	 @Transactional(readOnly=true)
	    public List<Widget> findWidget(int id) {
	        return jdbcTemplate.query("select * from widget where id="+id, 
	                new UserRowMapper());
	    }
	 
	 @Transactional
	    public Widget save(String name, String description) {
		 
		
		 final String sql = "insert into widget(name,description) values(?,?)";
		 
		   
	        KeyHolder holder = new GeneratedKeyHolder();
	        jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	                
	                ps.setString(1,name);
	                ps.setString(2, description);
	                return ps;
	            }
	        }, holder);
	 
	       int newWidgetId = holder.getKey().intValue();
	       Widget w=new Widget();
	       w.setId(newWidgetId);
	       w.setName(name);
	       w.setDescription(description);
	
	        return w;
	    }
	 
	 
}


class UserRowMapper implements RowMapper<Widget>
{
    @Override
    public Widget mapRow(ResultSet rs, int rowNum) throws SQLException {
        Widget user = new Widget();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setDescription(rs.getString("description"));
       
        return user;
    }
}