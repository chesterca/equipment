package com.phicomm.equipment.view;
/**
* @author ������
* @version ����ʱ�䣺2017��11��28�� ����7:01:19
* ��˵��
*/
public class CtoSInfoData {
	private String action;//����
    private String msg;//����

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
