package com.zqq.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 异常信息日志
 * @Auther: Zhang Qi
 * @Date: 2019/11/27 11:36
 * @Description: com.zqq.model
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
public class ErrorInfo {
    private int id;
    private String serialNo;
    private String proInstId;
    private String proDefId;
    private String actId;
    private String errorCode;
    private String errorMsg;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getProInstId() {
        return proInstId;
    }

    public void setProInstId(String proInstId) {
        this.proInstId = proInstId;
    }

    public String getProDefId() {
        return proDefId;
    }

    public void setProDefId(String proDefId) {
        this.proDefId = proDefId;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public ErrorInfo(int id, String serialNo, String proInstId, String proDefId, String actId, String errorCode, String errorMsg, Date updateTime) {
        this.id = id;
        this.serialNo = serialNo;
        this.proInstId = proInstId;
        this.proDefId = proDefId;
        this.actId = actId;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.updateTime = updateTime;
    }

    public ErrorInfo() {
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "id=" + id +
                ", serialNo='" + serialNo + '\'' +
                ", proInstId='" + proInstId + '\'' +
                ", proDefId='" + proDefId + '\'' +
                ", actId='" + actId + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
