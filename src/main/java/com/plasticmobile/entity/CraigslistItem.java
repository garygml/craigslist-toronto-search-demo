package com.plasticmobile.entity;

import java.util.Date;

/**
 * @author Mingliang Ge
 * @version 0.0.1
 */

public class CraigslistItem {

	private String title;
	private Date date;
	
	public CraigslistItem(String title, Date date) {
		this.title = title;
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
