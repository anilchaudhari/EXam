package com.online.exam.model;
import java.io.Serializable;
import java.util.Date;
//import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinTable;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
@Entity
@DynamicUpdate
@SelectBeforeUpdate
@Table(name="users")
public class Users implements Serializable{
	private static final long serialVersionUID = 8737710001L;
	@Id 
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "id")
    private Long id;
	
	@NotNull
	@Column(name = "users_id",unique=true)
	private String userID;
	@NotNull
	@Column(name = "passowrd")
	private String password;
	@NotNull
	@Column(name = "first_name")
	private String fName;
	@Column(name = "middle_name")
	private String mName;
	@Column(name = "last_name")
	private String lName;
	@Temporal(TemporalType.DATE)
	@Column(name="DOB")
	private Date DOB;
	@NotNull
	@Column(name = "email",unique=true)
	private String email;
	@Column(name = "address")
	private String address;
	@NotNull
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "expert_in")
	private String specialization;
	
	@GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "Timestamp")
    private String creationTime;
	@Transient
	private String role;
	// empty constructor
    public Users() 
    {
        super();
    }
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
