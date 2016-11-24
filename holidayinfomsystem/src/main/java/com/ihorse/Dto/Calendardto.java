package com.ihorse.Dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ihorse.Pojo.Calendarbean;

public class Calendardto {
	private Calendarbean cBean;
	private List<Calendarbean> listCbean;
	private String name;
	private Date sd;
	private Date ed;
	private String des;
	private int saveData;
	private List<String> startDate;
	private List<String> endDate;
	private List<String> selectedDates;
	private Map<String,Calendarbean> selectedDateMap;

	public Map<String, Calendarbean> getSelectedDateMap() {
		return selectedDateMap;
	}

	public void setSelectedDateMap(Map<String, Calendarbean> selectedDateMap) {
		this.selectedDateMap = selectedDateMap;
	}

	public List<String> getSelectedDates() {
		return selectedDates;
	}

	public void setSelectedDates(List<String> selectedDates) {
		this.selectedDates = selectedDates;
	}

	public List<String> getStartDate() {
		return startDate;
	}

	public void setStartDate(List<String> startDate) {
		this.startDate = startDate;
	}

	public List<String> getEndDate() {
		return endDate;
	}

	public void setEndDate(List<String> endDate) {
		this.endDate = endDate;
	}

	public int getSaveData() {
		return saveData;
	}

	public void setSaveData(int saveData) {
		this.saveData = saveData;
	}

	public Calendarbean getcBean() {
		return cBean;
	}

	public void setcBean(Calendarbean cBean) {
		this.cBean = cBean;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getSd() {
		return sd;
	}

	public void setSd(Date sd) {
		this.sd = sd;
	}

	public Date getEd() {
		return ed;
	}

	public void setEd(Date ed) {
		this.ed = ed;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public List<Calendarbean> getListCbean() {
		return listCbean;
	}

	public void setListCbean(List<Calendarbean> listCbean) {
		this.listCbean = listCbean;
	}

	public String toString() {
		return name + " " + sd + " " + ed + " " + des;
	}
}
