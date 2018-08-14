package com.phicomm.equipment.pojo;
/**
* @author 曹锡贵
* @version 创建时间：2017年12月10日 下午4:38:34
* 类说明
*/
public class EquiementHistoryParameter {
	private String id;
	private String begintime;
	private String endtime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public EquiementHistoryParameter(String id, String begintime, String endtime) {
		super();
		this.id = id;
		this.begintime = begintime;
		this.endtime = endtime;
	}
	public EquiementHistoryParameter() {
		super();
	}
	

}
