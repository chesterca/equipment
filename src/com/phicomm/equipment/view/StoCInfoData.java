package com.phicomm.equipment.view;
/**
* @author ������
* @version ����ʱ�䣺2017��11��28�� ����7:02:17
* ��˵��
*/
public class StoCInfoData {
	public String action;//����
    public String result_signal;//�����ʶ
    public String result;//���

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
