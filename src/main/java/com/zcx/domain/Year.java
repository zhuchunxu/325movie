package com.zcx.domain;

import java.io.Serializable;
/**
 * 
 * @ClassName: Year 
 * @Description: ���������
 * @author: 
 * @date: 2020��3��23�� ����2:00:16
 */

public class Year implements Serializable{
	private int id;
	private String year;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
