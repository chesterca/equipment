package com.phicomm.equipment.pojo;

import java.util.Date;

/**
* @author 曹锡贵
* @version 创建时间：2017年11月15日 上午9:06:39
* 类说明
*/
public class Equipment_info {
	private String id;
	private String name;
	private String status;
	private String line;
	private String floorid;
	private String time;
	private String userid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getFloorid() {
		return floorid;
	}
	public void setFloorid(String floorid) {
		this.floorid = floorid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Equipment_info() {
		super();
	}
	public Equipment_info(String id, String name, String status, String line, String floorid, String time,
			String userid) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.line = line;
		this.floorid = floorid;
		this.time = time;
		this.userid = userid;
	}
	

}
