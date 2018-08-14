package com.phicomm.equipment.service;

import java.util.List;

import com.phicomm.equipment.pojo.EquiementHistoryParameter;
import com.phicomm.equipment.pojo.EquimentParaments;
import com.phicomm.equipment.pojo.Equipment_history;
import com.phicomm.equipment.pojo.Equipment_info;
import com.phicomm.equipment.pojo.FindEquipmentHistoryInfo;
import com.phicomm.equipment.pojo.FindEquipmentInfo;
import com.phicomm.equipment.view.CtoSInfoData;
import com.phicomm.equipment.view.StoCInfoData;

/**
* @author ������
* @version ����ʱ�䣺2017��11��14�� ����3:35:22
* ��˵��
*/
public interface EquipmentService {
	public Equipment_info findEquipmentInfoById(String id);
	
	public List<Equipment_info> findEquipmentAll(EquimentParaments equimentParaments);
	
	public List<Equipment_history> findEquipmentHistory(EquiementHistoryParameter historyParameter);
	
	public StoCInfoData addEquipment(CtoSInfoData data,String username);
	public StoCInfoData updateEquipment(CtoSInfoData data,String username);
	
	//线体
	public List<String> findline(String line);
	public StoCInfoData addline(String line);
	
	public List<String> findFloor(String floorid);
	public StoCInfoData addFloor(String floorid);
	
}
