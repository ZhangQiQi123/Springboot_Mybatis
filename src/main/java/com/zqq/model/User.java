package com.zqq.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
<<<<<<< HEAD
/**
 * 用户表
 * @author 17612
 *
 */
=======
>>>>>>> 08dee62ec31037cde87a825a152904bd88559788
@Entity
public class User {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
	@Column(name="user_name")
    private String userName;
	@Column(name="password")
    private String password;
	@Column(name="phone")
    private String phone;
	@Column(name="create_time")
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+5:30")
    private Date createTime;
<<<<<<< HEAD
	@Column(name="update_time")
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+5:30")
    private Date updateTime;
	@Column(name="price")
    @NumberFormat(pattern="######.####")
    private double price;
	@Column(name="role_id")
	private Role role;
=======
	@Column(name="price")
    @NumberFormat(pattern="####.######")
    private double price;
>>>>>>> 08dee62ec31037cde87a825a152904bd88559788

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
<<<<<<< HEAD
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
=======
>>>>>>> 08dee62ec31037cde87a825a152904bd88559788

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

<<<<<<< HEAD
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User(Integer userId, String userName, String password, String phone, Date createTime,Date updateTime, double price,Role role) {
=======
	public User(Integer userId, String userName, String password, String phone, Date createTime,double price) {
>>>>>>> 08dee62ec31037cde87a825a152904bd88559788
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.createTime = createTime;
<<<<<<< HEAD
		this.updateTime=updateTime;
		this.price=price;
		this.role=role;
=======
		this.price=price;
>>>>>>> 08dee62ec31037cde87a825a152904bd88559788
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phone=" + phone
<<<<<<< HEAD
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + " price=" + price + ", role=" + role + "]";
=======
				+ ", createTime=" + createTime + ", price=" + price + "]";
>>>>>>> 08dee62ec31037cde87a825a152904bd88559788
	}
    
    
}