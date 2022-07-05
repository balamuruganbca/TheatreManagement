package com.example.theatremanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;



@Entity  //specifies that java class is mapped to database table.
@Table(name="user")  //this annotation is used to specify that particular table is mapped to.
public class User 
{
	@Id //specifies that primary key of entity.
	@GeneratedValue(generator = "userseq", strategy = GenerationType.IDENTITY) //this provides a general strategies for primary keys.
	@SequenceGenerator(name="userseq",initialValue = 200)
	@Column(name = "user_id") //used for add column in specific table.
	private int userId;

	@Column(name = "user_name", length=100 , nullable = false)
	private String userName;
	
	@Column(name="password",length = 100, nullable = false)
	@Length(min=8,max = 16,message = "password should be 8 to 16 characters.")
	private String password;
	
	@Email(message = "email is not well formed")
	@Column(name="email", unique = true)
	private String email;
		
	@Column(unique = true)
	@Pattern(regexp ="^[0-9]{10}",message = "Phone number cannnot be less than 10 characters.")
	private String phone;

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

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	public User(int userId, String userName,
			@Length(min = 8, max = 16, message = "password should be 8 to 16 characters.") String password,
			@Email String email,
			@Length(min = 3, max = 13, message = "Phone number is cannnot be less than 10 characters.") String phone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + "]";
	}

	

	
	

	

}
