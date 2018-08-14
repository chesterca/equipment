package com.learn.api.tHandheld_Device_asmx;

/**
 * Created by doubi.liu on 2017/11/21.
 *
 * @ClassName:
 * @Function:
 */

public class AccountInfoData {
    private String USERID;//用户名
    private String ROLECAPTION;//职位
    private String DEPTNAME;//部门
    private String FACID;//factoryID
    private String USERNAME;//用户名
    private String PWD;//密码
    private String USERSTATUS;//状态

    public AccountInfoData() {
    }

    public AccountInfoData(String USERID, String ROLECAPTION, String DEPTNAME, String FACID, String USERNAME, String PWD, String USERSTATUS) {
        this.USERID = USERID;
        this.ROLECAPTION = ROLECAPTION;
        this.DEPTNAME = DEPTNAME;
        this.FACID = FACID;
        this.USERNAME = USERNAME;
        this.PWD = PWD;
        this.USERSTATUS = USERSTATUS;
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getROLECAPTION() {
        return ROLECAPTION;
    }

    public void setROLECAPTION(String ROLECAPTION) {
        this.ROLECAPTION = ROLECAPTION;
    }

    public String getDEPTNAME() {
        return DEPTNAME;
    }

    public void setDEPTNAME(String DEPTNAME) {
        this.DEPTNAME = DEPTNAME;
    }

    public String getFACID() {
        return FACID;
    }

    public void setFACID(String FACID) {
        this.FACID = FACID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPWD() {
        return PWD;
    }

    public void setPWD(String PWD) {
        this.PWD = PWD;
    }

    public String getUSERSTATUS() {
        return USERSTATUS;
    }

    public void setUSERSTATUS(String USERSTATUS) {
        this.USERSTATUS = USERSTATUS;
    }
}
