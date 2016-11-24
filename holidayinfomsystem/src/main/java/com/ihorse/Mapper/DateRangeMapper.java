package com.ihorse.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ihorse.Pojo.Calendarbean;

public class DateRangeMapper implements RowMapper<Calendarbean> {

	@Override
	public Calendarbean mapRow(ResultSet rs, int rowNum) throws SQLException {
		Calendarbean om = new Calendarbean();
		om.setSd(rs.getDate(1));
		om.setEd(rs.getDate(2));
		return om;
	}

}
