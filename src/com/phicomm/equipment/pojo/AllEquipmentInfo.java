package com.phicomm.equipment.pojo;
/**
* @author ������
* @version ����ʱ�䣺2017��12��1�� ����4:22:42
* ��˵��
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
