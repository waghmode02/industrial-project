package com.company.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PolicyType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String policyTypeName;
	
	public PolicyType() {
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPolicyTypeName() {
		return policyTypeName;
	}
	public void setPolicyTypeName(String policyTypeName) {
		this.policyTypeName = policyTypeName;
	}
}
