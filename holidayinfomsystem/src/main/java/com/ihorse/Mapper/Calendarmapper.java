package com.ihorse.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ihorse.Pojo.Calendarbean;

public class Calendarmapper implements RowMapper<Calendarbean> {

	@Override
	public Calendarbean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		Calendarbean om = new Calendarbean();
		om.setName(rs.getString(1));
		om.setSd(rs.getDate(2));
		om.setEd(rs.getDate(3));
		om.setDes(rs.getString(4)); 
		return om;
	}

}
