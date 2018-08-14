
package com.phicomm.equipment.controller;

import java.util.List;
import java.util.concurrent.SynchronousQueue;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.learn.api.tHandheld_Device_asmx.AccountInfoData;
import com.learn.api.tHandheld_Device_asmx.THandheld_DeviceAsmxServiceImpl;
import com.learn.api.tHandheld_Device_asmx.THandheld_Device_AsmxService;
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
 * @author 曹锡贵
 * @version
 */

@Controller
public class EquipmentController {

	//注销用户
	@RequestMapping("/loginoff")
	public String loginoff(HttpSession session){
		session.setAttribute("username", "");
		return "redirect:/loginFrom.do";
	}
	
	
	// 显示查询界面
	@RequestMapping("/selectequipment")
	public String showquipment() {
		return "selectequipment";
	}

	// 显示详细查询界面
	@RequestMapping("/selectequipmentHistory")
	public String showquipmentHistory() {
		return "selectequipmentHistory";
	}

	@Autowired
	private EquipmentService equipmentService;

	//登录界面
	@RequestMapping(value="/loginFrom")
	public String loginFrom(){
		return "login";
	}
	
	@RequestMapping(value="/function")
	public String function(){
		return "top";
	}
	//登录到主界面
	@RequestMapping(value="/login")
	public @ResponseBody StoCInfoData login(@RequestBody CtoSInfoData data,HttpSession session) {
		String msg = data.getMsg();
		String username=msg.split(",")[0];
		String password=msg.split(",")[1];
		System.out.println("用户名："+username);
		
		
		/*session.setAttribute("username", username);
		StoCInfoData result1=new StoCInfoData();
        result1.setAction("login");
        result1.setResult_signal("ok");
        result1.setResult("ok");
        return result1;
		*/
		
		
		   try{
		    THandheld_Device_AsmxService checkservice = new THandheld_DeviceAsmxServiceImpl();
	        String res = checkservice.GetUserInfo(msg.split(",")[0], msg.split(",")[1]);
	        System.out.println(res);
	        Gson gson = new Gson();
	        JSONObject jsonObject = null;
	        List<AccountInfoData> accountInfoList=null;
	        try {
	            jsonObject = new JSONObject(res);
	            String exerciseStr = null;//获取key为"Table"的值。
	            exerciseStr = jsonObject.getString("Table");
	            accountInfoList = new Gson().fromJson(exerciseStr, new
	                    TypeToken<List<AccountInfoData>>() {
	            }.getType());

	        } catch (JSONException e) {
	            e.printStackTrace();
	            accountInfoList=null;
	        }
	        if(accountInfoList==null||accountInfoList.size()==0){
	            StoCInfoData result=new StoCInfoData();
	            result.setAction("login");
	            result.setResult_signal("Err");
	            result.setResult("账户或密码错误");
	            return result;
	        }else{
	            session.setAttribute("username", accountInfoList.get(0).getUSERNAME());
	            StoCInfoData result=new StoCInfoData();
	            result.setAction("login");
	            result.setResult_signal("ok");
	            result.setResult("ok");
	            return result;
	        }
		   }catch (Exception e) {
			    StoCInfoData result=new StoCInfoData();
	            result.setAction("login");
	            result.setResult_signal("Err");
	            result.setResult("用户不存在或者账户或密码错误");
	            return result;
		}
	}

	// ��ѯ��ϸ��Ϣ
	@RequestMapping("/findEquipmentHistory")
	public @ResponseBody StoCInfoData findEquipmentHistory(@RequestBody CtoSInfoData data) {
		String datainfo = data.getMsg();
		System.out.println(datainfo);
		Gson gson = new Gson();
		EquiementHistoryParameter historyParameter=gson.fromJson(datainfo, EquiementHistoryParameter.class);
		List<Equipment_history> equipmentHistory = equipmentService.findEquipmentHistory( historyParameter);
		String resultdata = new Gson().toJson(equipmentHistory);
		StoCInfoData res = new StoCInfoData();
		res.setAction("findEquipmentAll");
		res.setResult_signal("ok");
		res.setResult(resultdata);
		return res;
	}

	// ��ѯ������Ϣ
	@RequestMapping("/findEquipmentAll")
	public @ResponseBody StoCInfoData findEquipmentAll(@RequestBody CtoSInfoData data) {
		String datainfo = data.getMsg();
		Gson gson = new Gson();
		EquimentParaments equimentParaments= gson.fromJson(datainfo, EquimentParaments.class);
		List<Equipment_info> findEquipmentAll = equipmentService.findEquipmentAll(equimentParaments);
		String resultdata = new Gson().toJson(findEquipmentAll);
		StoCInfoData res = new StoCInfoData();
		res.setAction("findEquipmentAll");
		res.setResult_signal("ok");
		res.setResult(resultdata);
		return res;
	}

	// ¼����Ϣ
	@RequestMapping("/addEquipmentInfo")
	public @ResponseBody StoCInfoData addEquipmentInfo(@RequestBody CtoSInfoData data,HttpSession session) {
		String username=(String) session.getAttribute("username");
		StoCInfoData res = equipmentService.addEquipment(data,username);
		return res;
	}

	// ������Ϣ
	@RequestMapping("/updateEquipmentInfo")
	public @ResponseBody StoCInfoData updateEquipmentInfo(@RequestBody CtoSInfoData data,HttpSession session) {
		String username=(String) session.getAttribute("username");
		StoCInfoData res = equipmentService.updateEquipment(data,username);
		return res;
	}

	/**
	 * 
	 * 线体管理
	 */
	@RequestMapping("/findline")
	public @ResponseBody StoCInfoData findline(@RequestBody CtoSInfoData data){
		String line=data.getMsg();
		List<String> list=equipmentService.findline(line);
		String resultdata = new Gson().toJson(list);
		StoCInfoData res = new StoCInfoData();
		res.setAction("findline");
		res.setResult_signal("ok");
		res.setResult(resultdata);
		return res;
	}
	@RequestMapping("/addline")
	public @ResponseBody StoCInfoData addline(@RequestBody CtoSInfoData data){
		String line=data.getMsg();
		if(line==""||line==null){
			StoCInfoData res = new StoCInfoData();
			res.setAction("addline");
			res.setResult_signal("Err");
			res.setResult("线体不能为空");
			return res;
		}
		
		StoCInfoData res=equipmentService.addline(line);
		return res;
	}
	
	/**
	 * 楼层管理
	 */
	@RequestMapping("/findFloor")
	public @ResponseBody StoCInfoData findFloor(@RequestBody CtoSInfoData data){
		String floorid=data.getMsg();
		List<String> list=equipmentService.findFloor(floorid);
		String resultdata = new Gson().toJson(list);
		StoCInfoData res = new StoCInfoData();
		res.setAction("findFloor");
		res.setResult_signal("ok");
		res.setResult(resultdata);
		return res;
	}
	@RequestMapping("/addFloor")
	public @ResponseBody StoCInfoData addFloor(@RequestBody CtoSInfoData data){
		String floorid=data.getMsg();
		if(floorid==""||floorid==null){
			StoCInfoData res = new StoCInfoData();
			res.setAction("addFloor");
			res.setResult_signal("Err");
			res.setResult("楼层不能为空");
			return res;
		}
		
		StoCInfoData res=equipmentService.addFloor(floorid);
		return res;
	}
	
}
