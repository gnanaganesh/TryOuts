package com.ihorse.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.ihorse.Dto.Calendardto;
import com.ihorse.Pojo.Calendarbean;

public interface Calendarservice {

	public Calendardto Proce(String month, String year, Date std) throws SQLException;
	
	public void addDate(Calendarbean cb);
	
	public void delDates(List<Calendarbean> cbList);
}
