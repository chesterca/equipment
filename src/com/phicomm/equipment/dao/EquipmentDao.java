package com.phicomm.equipment.dao;

import java.util.List;

import com.phicomm.equipment.pojo.AllEquipmentInfo;
import com.phicomm.equipment.pojo.EquiementHistoryParameter;
import com.phicomm.equipment.pojo.EquimentParaments;
import com.phicomm.equipment.pojo.Equipment_history;
import com.phicomm.equipment.pojo.Equipment_info;
import com.phicomm.equipment.pojo.FindEquipmentHistoryInfo;
import com.phicomm.equipment.pojo.FindEquipmentInfo;
import com.phicomm.equipment.pojo.SelectInfo;

/**
* @author ������
* @version ����ʱ�䣺2017��11��14�� ����3:30:07
* ��˵��
*/
public interface EquipmentDao {
	
  public int findEquipmentInfoCount(String id);
  
  public Equipment_info findEquipmentInfoById(String id);
  
  public List<Equipment_info> findEquipmentAll(SelectInfo selectInfo);
  
  public List<Equipment_history> findEquipmentHistory(EquiementHistoryParameter historyParameter);
  
  public void addEquipmentInfo(FindEquipmentInfo equipmentInfo);
  public void addEquipmentHistory(FindEquipmentHistoryInfo historyInfo);
  
  public void updateEquipmentInfo(FindEquipmentInfo equipmentInfo);
  
  public List<String> findline(String line);
  public int findlinecount(String line);
  public void addline(String line);
  
  
  public List<String> findFloor(String floorid);
  public int finFloorcount(String floorid);
  public void addFloor(String floorid);

	
}
