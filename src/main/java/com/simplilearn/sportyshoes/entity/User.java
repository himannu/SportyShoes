package com.simplilearn.sportyshoes.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class User {

		@Id
		@GeneratedValue
		private Integer id;
		
		@Column(name= "username",nullable = false, unique = true)		
		@NotEmpty(message = "User Name is mandatory!")
		private String username;

		@Column(name= "first_name",nullable = false)				
		@NotEmpty(message = "First Name is mandatory!")
		private String firstName;

		@Column(name= "last_name",nullable = false)				
		@NotEmpty(message = "Last Name is mandatory!")
		private String lastName;
		
		@Column(name= "email",nullable = false)				
		@NotEmpty(message = "Email is mandatory!")
		@Email(message = "Email is not valid address")
		private String emailId;

		@Column(name= "phone_number",nullable = false)				
		@NotEmpty(message = "Phone Number is mandatory !")
		@Pattern(regexp = "[1-9][0-9]{9}", message = "Phone Number must be exaclty 10 digits!")
		private String phoneNumber;
		
		@Column(name= "password",nullable = false)						
		@NotEmpty(message = "Password is mandatory!")
		private String password;
		
		@Column(name= "confirm_password",nullable = false)				
		@NotEmpty(message = "confirm password !")
		private String passwordConfirm;
		
		@Embedded
		private Address address;
		

		@Enumerated(EnumType.STRING)
		private UserRole role;

		public User() {
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPasswordConfirm() {
			return passwordConfirm;
		}

		public void setPasswordConfirm(String passwordConfirm) {
			this.passwordConfirm = passwordConfirm;
		}

		public UserRole getRole() {
			return role;
		}

		public void setRole(UserRole role) {
			this.role = role;
		}

		public User( String username,
				 String firstName,
				String lastName,
				String emailId,String phoneNumber,
				String password,
				String passwordConfirm, UserRole role) {
			super();
			this.username = username;
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailId = emailId;
			this.phoneNumber = phoneNumber;
			this.password = password;
			this.passwordConfirm = passwordConfirm;
			this.role = role;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((passwordConfirm == null) ? 0 : passwordConfirm.hashCode());
			result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
			result = prime * result + ((role == null) ? 0 : role.hashCode());
			result = prime * result + ((username == null) ? 0 : username.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (emailId == null) {
				if (other.emailId != null)
					return false;
			} else if (!emailId.equals(other.emailId))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (passwordConfirm == null) {
				if (other.passwordConfirm != null)
					return false;
			} else if (!passwordConfirm.equals(other.passwordConfirm))
				return false;
			if (phoneNumber == null) {
				if (other.phoneNumber != null)
					return false;
			} else if (!phoneNumber.equals(other.phoneNumber))
				return false;
			if (role != other.role)
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", password=" + password
					+ ", passwordConfirm=" + passwordConfirm + ", role=" + role + "]";
		}
		
		
		
}
