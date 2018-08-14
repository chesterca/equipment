package com.phicomm.equipment.view;
/**
* @author 曹锡贵
* @version 创建时间：2017年11月28日 下午7:01:19
* 类说明
*/
public class CtoSInfoData {
	private String action;//请求
    private String msg;//内容

    public CtoSInfoData() {
    }

    public CtoSInfoData(String action, String msg) {
        this.action = action;
        this.msg = msg;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
