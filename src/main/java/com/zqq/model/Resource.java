package com.zqq.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 权限表
 * @author 17612
 *
 */
@Entity
public class Resource {
	@Id
	@Column(name="resource_id")
	private String resourceId;
	@Column(name="resource_name")
	private String resourceName;
	@Column(name="resource_type_id")
	private int resourceTypeId;
	@Column(name="parmater_id")
	private String parmaterId;
	@Column(name="resource_url")
	private String resourceUrl;
	@Column(name="icons")
	private String icons;
	@Column(name="create_time")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	@Column(name="update_time")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	@Column(name="remark")
	private String remark;

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public int getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceTypeId(int resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}

	public String getParmaterId() {
		return parmaterId;
	}

	public void setParmaterId(String parmaterId) {
		this.parmaterId = parmaterId;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public String getIcons() {
		return icons;
	}

	public void setIcons(String icons) {
		this.icons = icons;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Resource(String resourceId, String resourceName, int resourceTypeId, String parmaterId, String resourceUrl,
			String icons, Date createTime, Date updateTime, String remark) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.resourceTypeId = resourceTypeId;
		this.parmaterId = parmaterId;
		this.resourceUrl = resourceUrl;
		this.icons = icons;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.remark = remark;
	}

	public Resource() {
		super();
	}
}
