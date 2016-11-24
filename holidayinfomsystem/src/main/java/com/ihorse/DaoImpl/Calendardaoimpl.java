package com.ihorse.DaoImpl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ihorse.Dao.Calendardao;
import com.ihorse.Dto.Calendardto;
import com.ihorse.Mapper.Calendarmapper;
import com.ihorse.Pojo.Calendarbean;

public class Calendardaoimpl implements Calendardao {

	private DateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

	private DataSource ds;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int save(Calendarbean e) throws SQLException {

		String query = "insert into oss(name,std,etd,des)values(?,?,?,?)";
		Object[] param = new Object[] { e.getName(), sd.format(e.getSd()), sd.format(e.getEd()), e.getDes() };
		if (e.getOldEndDate() != null && e.getOldEndDate() != null) {
			query = "update oss set name =?, std=?, etd=?, des= ? where std=? and etd= ?";
			param = new Object[] { e.getName(), sd.format(e.getSd()), sd.format(e.getEd()), e.getDes(), sd.format(e.getOldStartDate()),
					sd.format(e.getOldEndDate()) };
		}
		return jdbcTemplate.update(query, param);
	}

	@Override
	public Calendardto userDetails(String month, String year, Date std) throws SQLException {

		Calendardto dto = new Calendardto();

		Map<String, Calendarbean> selectedDateMap = new HashMap<>();

		String sql = "select name,std,etd,des from oss where (month(std)=? and year(std)=?) or (month(etd)=? and year(etd)=?) order by std,etd asc";
		List<Calendarbean> dateRangeList = jdbcTemplate.query(sql, new Object[] { month, year, month, year },
				new Calendarmapper());

		dto.setListCbean(dateRangeList);

		sql = "select * from "
				+ "(select adddate('1970-01-01',t4.i*10000 + t3.i*1000 + t2.i*100 + t1.i*10 + t0.i) selected_date from "
				+ "(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0,  "
				+ "(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1,  "
				+ "(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2,  "
				+ "(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3,  "
				+ "(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4)  "
				+ " dateRange where selected_date between ? and ? ";

		List<String> selectedDates = new ArrayList<>();
		List<String> dateList = new ArrayList<>();
		for (Calendarbean calendarbean : dateRangeList) {
			dateList = jdbcTemplate.queryForList(sql, new Object[] { calendarbean.getSd(), calendarbean.getEd() },
					String.class);
			selectedDates.addAll(dateList);

			for (String string : dateList) {
				selectedDateMap.put(string, calendarbean);
			}

		}

		dto.setSelectedDateMap(selectedDateMap);
		dto.setSelectedDates(selectedDates);
		return dto;
	}

	public void addDate(Calendarbean cb) {
		String sql = "insert into oss values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { cb.getName(), cb.getSd(), cb.getEd(), cb.getDes() });
	}

	public void delDates(List<Calendarbean> cbList) {
		String sql = "delete from oss where std = ? and etd=?";

		for (Calendarbean cb : cbList) {
			jdbcTemplate.update(sql, new Object[] { sd.format(cb.getSd()), sd.format(cb.getEd()) });
		}

	}

}
