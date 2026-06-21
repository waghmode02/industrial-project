	package com.company.project.entity.user;
	
	import java.time.LocalDate;
	import java.util.Date;
	
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	
	@Entity
	@Table(name = "user_profile")
	public class Users {
		
		@Id
		private Integer userId;
		
	    private LocalDate dateOfBirth;
	    private String gender;
	    private String phone;
	    
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public LocalDate  getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(LocalDate  dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		@Override
		public String toString() {
			return "Users [userId=" + userId + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", phone=" + phone
					+ "]";
		}
	
	    
	}
