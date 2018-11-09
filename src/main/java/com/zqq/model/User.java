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
	@Column(name="price")
    @NumberFormat(pattern="####.######")
    private double price;

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
	

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public User(Integer userId, String userName, String password, String phone, Date createTime,double price) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.createTime = createTime;
		this.price=price;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phone=" + phone
				+ ", createTime=" + createTime + ", price=" + price + "]";
	}
    
    
}