package com.phicomm.equipment.view;
/**
* @author 曹锡贵
* @version 创建时间：2017年11月28日 下午7:02:17
* 类说明
*/
public class StoCInfoData {
	public String action;//动作
    public String result_signal;//结果标识
    public String result;//结果

    public StoCInfoData() {
    }

    public StoCInfoData(String action, String result_signal, String result) {
        this.action = action;
        this.result_signal = result_signal;
        this.result = result;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResult_signal() {
        return result_signal;
    }

    public void setResult_signal(String result_signal) {
        this.result_signal = result_signal;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
