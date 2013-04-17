package us.opulo.p.dao;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Dimensioned date, data access object. Objects of this class are persisted in the 'InfectionDate' database table. 
 * 
 * @author Jason Campos, Shaun Guth
 */
@Entity
@Table(name = "InfectionDate")
public class InfectionDate extends HEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Date date;
	
	private Integer day;
	private Integer month;
	private Integer year;
	
	private String dayOfWeek;
	private String nameOfMonth;
	
	@Transient
	private static final String[] DAY_OF_WEEK = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	
	@Transient
	private static final String[] MONTH = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
	
	public InfectionDate (Date date) {
		setDate(date);
	}
	
	public Date getDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTime();
	}
	
	private void setDate(Date date) {
		this.date = date;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		this.setDay(calendar.get(Calendar.DAY_OF_MONTH));
		this.setDayOfWeek(DAY_OF_WEEK[calendar.get(Calendar.DAY_OF_WEEK)]);
		this.setMonth(calendar.get(Calendar.MONTH) + 1); // Calendar.January = 0
		this.setYear(calendar.get(Calendar.YEAR));		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getDay() {
		return day;
	}
	
	private void setDay(Integer day) {
		this.day = day;
	}
	
	public Integer getMonth() {
		return month;
	}
	
	private void setMonth(Integer month) {
		this.month = month;
		setNameOfMonth(MONTH[month - 1]);
	}
	
	public Integer getYear() {
		return year;
	}
	
	private void setYear(Integer year) {
		this.year = year;
	}
	
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	
	private void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	public String getNameOfMonth() {
		return nameOfMonth;
	}
	
	private void setNameOfMonth(String nameOfMonth) {
		this.nameOfMonth = nameOfMonth;
	}
	
	@Override
	public String toString() {
		return dayOfWeek + ", " + nameOfMonth + " " + day + ", " + year;
	}
}
