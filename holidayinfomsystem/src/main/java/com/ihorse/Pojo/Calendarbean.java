package com.ihorse.Pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Calendarbean {
	private String name;
	private Date sd;
	private Date ed;
	private String des;
	private String month;
	private String year;
	private Date oldStartDate;
	private Date oldEndDate;

	public Date getOldStartDate() {
		return oldStartDate;
	}

	public void setOldStartDate(Date oldStartDate) {
		this.oldStartDate = oldStartDate;
	}

	public Date getOldEndDate() {
		return oldEndDate;
	}

	public void setOldEndDate(Date oldEndDate) {
		this.oldEndDate = oldEndDate;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Calendarbean(String name, Date sd, Date ed, String des) {
		super();
		this.name = name;
		this.sd = sd;
		this.ed = ed;
		this.des = des;
	}

	public Calendarbean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public String toString() {
		return name + " " + sd + " " + ed + " " + des;
	}

}
