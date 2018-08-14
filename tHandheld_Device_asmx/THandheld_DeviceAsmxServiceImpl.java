package com.learn.api.tHandheld_Device_asmx;

import com.google.gson.Gson;
import com.learn.utils.PropertyConfigUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by doubi.liu on 2017/11/2.
 *
 * @ Name:
 * @ Description:
 * @ Version:
 */
public class THandheld_DeviceAsmxServiceImpl implements THandheld_Device_AsmxService {

    @Override
    public String GetUserInfo(String name, String pwd) {
        Map<String,Object> paremter=new HashMap<>();
        paremter.put("USERID",name);
        paremter.put("PWD",pwd);
        String json = new Gson().toJson(paremter);
        //paremter.clear();
        //paremter.put("Json", json);
        //paremter.put("Fields", "USERID,ROLECAPTION,DEPTNAME,FACID,USERNAME,USERSTATUS");
        PropertyConfigUtils toolutils=new PropertyConfigUtils();
        URL url=PropertyConfigUtils.class.getResource("wsdl.properties");
        String wsurl=toolutils.getvalue(url.getPath(), "GetUserInfoAddress");
        URL wsdlLocation = null;
        try {
            wsdlLocation = new URL(wsurl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        com.learn.api.tHandheld_Device_asmx.THandheldDevice tHandheldDevice = new THandheldDevice
                (wsdlLocation);
        String result=tHandheldDevice.getTHandheldDeviceSoap().getUserInfo(json,"USERID," +
                "ROLECAPTION,DEPTNAME,FACID,USERNAME,USERSTATUS");
        return result;
    }
}
