package holidayinfomsystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ihorse.Dao.Calendardao;
import com.ihorse.Dto.Calendardto;
import com.ihorse.Pojo.Calendarbean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AppTest {

	public AppTest() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	Calendardao dao;

	/*@Test
	public void testUserDetails() {

		List<Calendarbean> list = null;
		try {
			list = dao.userDetails("11", "2016", null);
			for (Calendarbean calendarbean : list) {
				System.out.println(calendarbean.getDes());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	@Test
	public void testAdd() {

		//dao.addDate(new Calendarbean("test2",new Date("2016/11/01"),new Date("2016/11/10"),"test2"));
		//dao.addDate(new Calendarbean("test5",new Date("2016/12/01"),new Date("2016/12/10"),"test5"));
		dao.addDate(new Calendarbean("test6",new Date("2016/12/15"),new Date("2016/12/17"),"test6"));
		/*dao.addDate(new Calendarbean("test4",new Date("2016/11/28"),new Date("2016/11/28"),"test2"));*/
	}
	
	//@Test
	public void delDates() {

		List<Calendarbean> list = new ArrayList<>();
		
		dao.addDate(new Calendarbean("test6",new Date("2016/12/15"),new Date("2016/11/17"),"test6"));
		
		dao.delDates(list);
	}
	
	//@Test
	public void testFetchDates() {

		try {
			Calendardto dto = dao.userDetails("11","2016",null);
			System.out.println(dto.getSelectedDates());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
