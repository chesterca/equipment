package com.phicomm.equipment.pojo;
/**
* @author 曹锡贵
* @version 创建时间：2017年12月1日 下午4:22:42
* 类说明
*/
public class AllEquipmentInfo {
	
	private Equipment_info equipmentinfo;
    private Equipment_history equipmenthistory;
	public Equipment_info getEquipmentinfo() {
		return equipmentinfo;
	}
	public void setEquipmentinfo(Equipment_info equipmentinfo) {
		this.equipmentinfo = equipmentinfo;
	}
	public Equipment_history getEquipmenthistory() {
		return equipmenthistory;
	}
	public void setEquipmenthistory(Equipment_history equipmenthistory) {
		this.equipmenthistory = equipmenthistory;
	}
	public AllEquipmentInfo() {
		super();
	}
	public AllEquipmentInfo(Equipment_info equipmentinfo, Equipment_history equipmenthistory) {
		super();
		this.equipmentinfo = equipmentinfo;
		this.equipmenthistory = equipmenthistory;
	}
    
    
}
