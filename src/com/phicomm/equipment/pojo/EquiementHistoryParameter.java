package com.phicomm.equipment.pojo;
/**
* @author ������
* @version ����ʱ�䣺2017��12��10�� ����4:38:34
* ��˵��
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
