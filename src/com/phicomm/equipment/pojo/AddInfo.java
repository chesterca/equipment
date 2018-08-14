package com.phicomm.equipment.pojo;
/**
* @author 曹锡贵
* @version 创建时间：2017年12月5日 上午9:22:13
* 类说明
*/
public class AddInfo {
	private String id;
	private String name;
	private String floorid;
	private String line;
	private String status;
	private String remarks;
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
	public String getFloorid() {
		return floorid;
	}
	public void setFloorid(String floorid) {
		this.floorid = floorid;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public AddInfo(String id, String name, String floorid, String line, String status, String remarks) {
		super();
		this.id = id;
		this.name = name;
		this.floorid = floorid;
		this.line = line;
		this.status = status;
		this.remarks = remarks;
	}
	public AddInfo() {
		super();
	}
	


}
