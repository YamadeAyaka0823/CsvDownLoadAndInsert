package com.example.domain;

import java.util.Date;

public class Arashi {
	
	/** ID */
	private Integer id;
	/** 名前 */
	private String name;
	/** 日付 */
	private Date day;
	/** メールアドレス */
	private String email;
	/** 企業ID */
	private Integer companyId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	@Override
	public String toString() {
		return "Arashi [id=" + id + ", name=" + name + ", day=" + day + ", email=" + email + ", companyId=" + companyId
				+ "]";
	}
	
	
	

}
