package com.thetapasbar247.www.Reservas;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reserva implements Serializable{
	/**
	 * Basic entity to persist
	 */
	private static final long serialVersionUID = -1705521924505190628L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String fullname;
	private String email;
	private int phone;
	private Date date;
	private String time;
	private int people;
	private String aditional;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public String getAditional() {
		return aditional;
	}
	public void setAditional(String aditional) {
		this.aditional = aditional;
	}
	
}
