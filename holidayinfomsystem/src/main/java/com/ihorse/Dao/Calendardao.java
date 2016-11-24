package com.ihorse.Dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.ihorse.Dto.Calendardto;
import com.ihorse.Pojo.Calendarbean;

public interface Calendardao {
	public int save(Calendarbean e) throws SQLException;

	public Calendardto userDetails(String month, String year, Date std) throws SQLException;

	public void addDate(Calendarbean cb);

	public void delDates(List<Calendarbean> cbList);
}
