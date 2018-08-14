package com.phicomm.equipment.pojo;
/**
* @author 曹锡贵
* @version 创建时间：2017年12月10日 下午3:11:34
* 类说明
*/
public class EquimentParaments {
	private String id;
    private String name;
    private String floorid;
    private String  line;
    private String  begintime;
    private String  endtime;
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
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public EquimentParaments(String id, String name, String floorid, String line, String begintime, String endtime) {
		super();
		this.id = id;
		this.name = name;
		this.floorid = floorid;
		this.line = line;
		this.begintime = begintime;
		this.endtime = endtime;
	}
	public EquimentParaments() {
		super();
	}
    
}
