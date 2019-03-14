package com.zqq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 权限类型
 * @author 17612
 *
 */
@Entity
public class ResourceType {
	@Id
	@Column(name="resource_type_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int resourceTypeId;
	@Column(name="resource_type_name")
	private String resourceTypeName;
	public int getResourceTypeId() {
		return resourceTypeId;
	}
	public void setResourceTypeId(int resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}
	public String getResourceTypeName() {
		return resourceTypeName;
	}
	public void setResourceTypeName(String resourceTypeName) {
		this.resourceTypeName = resourceTypeName;
	}
	public ResourceType(int resourceTypeId, String resourceTypeName) {
		super();
		this.resourceTypeId = resourceTypeId;
		this.resourceTypeName = resourceTypeName;
	}
	public ResourceType() {
		super();
	}
}
