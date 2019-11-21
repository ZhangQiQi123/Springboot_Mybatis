package com.zqq.util;


import java.util.Date;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/11/19 14:11
 * @Description: com.zqq.test
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
public class UserInfo {
    private int userId;
    private String userName;
    private int age;
    private String sex;
    private Date createDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public UserInfo(int userId, String userName, int age, String sex, Date createDate) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.sex = sex;
        this.createDate = createDate;
    }

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
