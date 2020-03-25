package com.zcx.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @ClassName: Movie 
 * @Description: 创建电影类
 * @author: 
 * @date: 2020年3月23日 下午1:59:51
 */
public class Movie implements Serializable {
	
	private int id;
	private String name;
	private String author;
	private int price;
	private Date created;
	private int time;
	private String type;
	private int year;
	private String address;
	private int zhuangtai;
	
	private Year y;
	
 	
	public Year getY() {
		return y;
	}
	public void setY(Year y) {
		this.y = y;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(int zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	
}
