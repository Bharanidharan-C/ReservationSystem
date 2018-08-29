package com.tcs.hack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Resource {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resource_id")
    @SequenceGenerator(sequenceName = "resource_id", allocationSize = 1,  name = "resource_id")
	@Column(name="resource_id",nullable=false)
	private int resourceId;
	
	@Column(name="resource_name")
	private String resourceName;
	public Resource(int resourceId) {
		super();
		this.resourceId = resourceId;
	}
	public Resource(int resourceId, String resourceName) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
	}
	
	public Resource() {
		super();
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
}
