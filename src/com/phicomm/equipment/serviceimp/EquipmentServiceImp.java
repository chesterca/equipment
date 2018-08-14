package com.phicomm.equipment.serviceimp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.phicomm.equipment.dao.EquipmentDao;
import com.phicomm.equipment.pojo.SelectInfo;
import com.phicomm.equipment.pojo.AddInfo;
import com.phicomm.equipment.pojo.EquiementHistoryParameter;
import com.phicomm.equipment.pojo.EquimentParaments;
import com.phicomm.equipment.pojo.Equipment_history;
import com.phicomm.equipment.pojo.Equipment_info;
import com.phicomm.equipment.pojo.FindEquipmentHistoryInfo;
import com.phicomm.equipment.pojo.FindEquipmentInfo;
import com.phicomm.equipment.service.EquipmentService;
import com.phicomm.equipment.view.CtoSInfoData;
import com.phicomm.equipment.view.StoCInfoData;

/**
 * @author ������
 * @version ����ʱ�䣺2017��11��14�� ����3:36:01 ��˵��
 */

@Service
public class EquipmentServiceImp implements EquipmentService {
	@Autowired
	private EquipmentDao equipmentDao;

	Date d = new Date();
	SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date = sm.format(d);
	
	@Override
	public Equipment_info findEquipmentInfoById(String id) {
		Equipment_info equipment = equipmentDao.findEquipmentInfoById(id);
		return equipment;
	}

	@Override
	public List<Equipment_history> findEquipmentHistory(EquiementHistoryParameter historyParameter) {
		List<Equipment_history> historyResult = equipmentDao.findEquipmentHistory(historyParameter);
		return historyResult;
	}

	@Override
	public List<Equipment_info> findEquipmentAll(EquimentParaments equimentParaments) {
		SelectInfo selectInfo =new SelectInfo();
		selectInfo.setEquimentParaments(equimentParaments);
		List<Equipment_info> list = equipmentDao.findEquipmentAll(selectInfo);
		return list;
	}

	@Override
	public StoCInfoData addEquipment(CtoSInfoData data,String username) {
		String datainfo = data.getMsg();
		Gson gson = new Gson();
		AddInfo addInfo = gson.fromJson(datainfo, AddInfo.class);

		FindEquipmentInfo equipmentInfo = new FindEquipmentInfo();
		FindEquipmentHistoryInfo historyInfo = new FindEquipmentHistoryInfo();

		Equipment_info equipment = new Equipment_info();
		equipment.setId(addInfo.getId());
		equipment.setName(addInfo.getName());
		equipment.setStatus(addInfo.getStatus());
		equipment.setLine(addInfo.getLine());
		equipment.setFloorid(addInfo.getFloorid());
		equipment.setTime(date);
		equipment.setUserid(username);

		Equipment_history equipmenthistory = new Equipment_history();
		equipmenthistory.setId(addInfo.getId());
		equipmenthistory.setName(addInfo.getName());
		equipmenthistory.setLine(addInfo.getLine());
		equipmenthistory.setFloorid(addInfo.getFloorid());
		equipmenthistory.setRemarks(addInfo.getRemarks());
		equipmenthistory.setTime(date);
		equipmenthistory.setUserid(username);

		equipmentInfo.setEquipment(equipment);
		historyInfo.setEquipmenthistory(equipmenthistory);
		int count = equipmentDao.findEquipmentInfoCount(addInfo.getId());
		if (count == 0) {
			equipmentDao.addEquipmentInfo(equipmentInfo);
			equipmentDao.addEquipmentHistory(historyInfo);

			StoCInfoData res = new StoCInfoData();
			res.setAction("addEquipmentInfo");
			res.setResult_signal("ok");
			res.setResult("新增成功");
			return res;
		} else {
			StoCInfoData res = new StoCInfoData();
			res.setAction("addEquipmentInfo");
			res.setResult_signal("Err");
			res.setResult("该信息已存在，新增失败");
			return res;
		}
	}

	@Override
	public StoCInfoData updateEquipment(CtoSInfoData data,String username) {
		String datainfo = data.getMsg();
		Gson gson = new Gson();
		AddInfo addInfo = gson.fromJson(datainfo, AddInfo.class);

		FindEquipmentInfo equipmentInfo = new FindEquipmentInfo();
		FindEquipmentHistoryInfo historyInfo = new FindEquipmentHistoryInfo();

		Equipment_info equipment = new Equipment_info();
		equipment.setId(addInfo.getId());
		equipment.setName(addInfo.getName());
		equipment.setStatus(addInfo.getStatus());
		equipment.setLine(addInfo.getLine());
		equipment.setFloorid(addInfo.getFloorid());
		equipment.setTime(date);
		equipment.setUserid(username);

		Equipment_history equipmenthistory = new Equipment_history();
		equipmenthistory.setId(addInfo.getId());
		equipmenthistory.setName(addInfo.getName());
		equipmenthistory.setLine(addInfo.getLine());
		equipmenthistory.setFloorid(addInfo.getFloorid());
		equipmenthistory.setRemarks(addInfo.getRemarks());
		equipmenthistory.setTime(date);
		equipmenthistory.setUserid(username);

		equipmentInfo.setEquipment(equipment);
		historyInfo.setEquipmenthistory(equipmenthistory);
		int count = equipmentDao.findEquipmentInfoCount(addInfo.getId());
		if (count > 0) {
			equipmentDao.updateEquipmentInfo(equipmentInfo);
			equipmentDao.addEquipmentHistory(historyInfo);

			StoCInfoData res = new StoCInfoData();
			res.setAction("updateEquipment");
			res.setResult_signal("ok");
			res.setResult("移线成功");
			return res;
		}else{
			StoCInfoData res = new StoCInfoData();
			res.setAction("updateEquipment");
			res.setResult_signal("Err");
			res.setResult("移线失败");
			return res;
		}

	}

	/**
	 * 线体管理
	 */
	@Override
	public List<String> findline(String line) {
		List<String> list=equipmentDao.findline(line);
		return list;
	}

	@Override
	public StoCInfoData addline(String line) {
		int count=equipmentDao.findlinecount(line);
		if(count==0){
			equipmentDao.addline(line);
			StoCInfoData res = new StoCInfoData();
			res.setAction("addline");
			res.setResult_signal("ok");
			res.setResult("线体录入成功");
			return res;
			
		}else{
			StoCInfoData res = new StoCInfoData();
			res.setAction("addline");
			res.setResult_signal("Err");
			res.setResult("线体已经在，线体录入失败");
			return res;
		}
		
	}

	
	/**
	 * 楼层管理
	 */
	@Override
	public List<String> findFloor(String floorid) {
		List<String> list=equipmentDao.findFloor(floorid);
		return list;
	}

	@Override
	public StoCInfoData addFloor(String floorid) {
		int count=equipmentDao.finFloorcount(floorid);
		if(count==0){
			equipmentDao.addFloor(floorid);
			StoCInfoData res = new StoCInfoData();
			res.setAction("addFloor");
			res.setResult_signal("ok");
			res.setResult("楼层录入成功");
			return res;
		}else{
			StoCInfoData res = new StoCInfoData();
			res.setAction("addFloor");
			res.setResult_signal("Err");
			res.setResult("楼层已存在，楼层录入失败");
			return res;
		}
	
	}

}
