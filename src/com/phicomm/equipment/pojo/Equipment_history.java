package com.phicomm.equipment.pojo;
/**
* @author 曹锡贵
* @version 创建时间：2017年11月15日 下午4:25:33
* 类说明
*/
public class Equipment_history {
	
	private String id;
	private String name;
	private String line;
	private String floorid;
	private String remarks;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public Equipment_history() {
		super();
	}
	public Equipment_history(String id, String name, String line, String floorid, String remarks, String time,
			String userid) {
		super();
		this.id = id;
		this.name = name;
		this.line = line;
		this.floorid = floorid;
		this.remarks = remarks;
		this.time = time;
		this.userid = userid;
	}
	
	

}
