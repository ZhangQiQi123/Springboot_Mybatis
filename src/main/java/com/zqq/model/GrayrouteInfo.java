package com.zqq.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Test结果
 * @Auther: Zhang Qi
 * @Date: 2019/11/27 11:40
 * @Description: com.zqq.model
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
public class GrayrouteInfo {
    private int id;
    private String serialNo;
    private String proDefId;
    private String proDefVersion;
    private String variable;
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

    public String getProDefId() {
        return proDefId;
    }

    public void setProDefId(String proDefId) {
        this.proDefId = proDefId;
    }

    public String getProDefVersion() {
        return proDefVersion;
    }

    public void setProDefVersion(String proDefVersion) {
        this.proDefVersion = proDefVersion;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public GrayrouteInfo(int id, String serialNo, String proDefId, String proDefVersion, String variable, Date updateTime) {
        this.id = id;
        this.serialNo = serialNo;
        this.proDefId = proDefId;
        this.proDefVersion = proDefVersion;
        this.variable = variable;
        this.updateTime = updateTime;
    }

    public GrayrouteInfo() {
    }

    @Override
    public String toString() {
        return "GrayrouteInfo{" +
                "id=" + id +
                ", serialNo='" + serialNo + '\'' +
                ", proDefId='" + proDefId + '\'' +
                ", proDefVersion='" + proDefVersion + '\'' +
                ", variable='" + variable + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
