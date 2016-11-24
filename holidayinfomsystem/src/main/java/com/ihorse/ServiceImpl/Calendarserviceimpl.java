package com.ihorse.ServiceImpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihorse.DaoImpl.Calendardaoimpl;
import com.ihorse.Dto.Calendardto;
import com.ihorse.Pojo.Calendarbean;
import com.ihorse.Service.Calendarservice;

public class Calendarserviceimpl implements Calendarservice {
	@Autowired
	Calendardaoimpl cdao;

	@Override
	public Calendardto Proce(String month, String year, Date std) throws SQLException {

		/*List<Calendarbean> s = cdao.userDetails(month, year, std);

		Calendardto m = new Calendardto();
		List<String> listA = new ArrayList<>();
		List<String> listB = new ArrayList<>();
		for (Calendarbean element : s) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = dateFormat.format(element.getSd());
			String endDate = dateFormat.format(element.getEd());
			listA.add(strDate);
			listB.add(endDate);

		}
		m.setStartDate(listA);
		m.setEndDate(listB);
		System.out.println("bb" + m.getStartDate());*/

		return cdao.userDetails(month, year, std);
	}
	
	public void addDate(Calendarbean cb) {
		cdao.addDate(cb);
	}

	public void delDates(List<Calendarbean> cbList) {
		cdao.delDates(cbList);
	}
}
