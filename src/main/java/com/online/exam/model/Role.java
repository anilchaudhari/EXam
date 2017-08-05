package com.online.exam.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users_roles")
public class Role {
	@Id 
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "idRole")
    private Long idRole;
	
	@NotNull
	@Column(name = "roleType")
	private String roleType;
	@NotNull
	@Column(name = "user_mail_id",unique=true)
	private String userId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="users_id")
	private Users users;
	
	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}
