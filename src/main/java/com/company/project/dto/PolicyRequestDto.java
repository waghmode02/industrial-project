package com.company.project.dto;

public class PolicyRequestDto {
	private Long policyTypeId;
	private String policyName;
	private Double coverageAmount;
	private Integer durationInYears;
	
	public Long getPolicyTypeId() {
		return policyTypeId;
	}
	public void setPolicyTypeId(Long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public Double getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(Double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	public Integer getDurationInYears() {
		return durationInYears;
	}
	public void setDurationInYears(Integer durationInYears) {
		this.durationInYears = durationInYears;
	}
}
