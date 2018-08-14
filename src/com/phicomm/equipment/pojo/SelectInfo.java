package com.phicomm.equipment.pojo;
/**
* @author 曹锡贵
* @version 创建时间：2017年12月10日 下午3:34:29
* 类说明
*/
public class SelectInfo {
   private EquimentParaments equimentParaments;

public EquimentParaments getEquimentParaments() {
	return equimentParaments;
}

public void setEquimentParaments(EquimentParaments equimentParaments) {
	this.equimentParaments = equimentParaments;
}

public SelectInfo(EquimentParaments equimentParaments) {
	super();
	this.equimentParaments = equimentParaments;
}

public SelectInfo() {
	super();
}
   
   
}
