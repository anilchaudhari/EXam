package com.online.exam.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="u_query")
public class UQuery {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "id")
	private Long id;
	@Column(name="p_description")
	private String pDescription;
	@Column(name="p_subject")
	private String pSubject;
	@Column(name="to_user")
	private String toUser;
	@NotNull
	@Column( columnDefinition = "enum( 'RESOLVED', 'INPROCESS')" )
    @Enumerated(EnumType.STRING)
	private QueryStatus queryStatus;
	@Column(name="resolution")
	private String resolution;
	@GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "Timestamp")
	private String date;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="users_id")
	private Users users;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public String getpSubject() {
		return pSubject;
	}
	public void setpSubject(String pSubject) {
		this.pSubject = pSubject;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	
	public QueryStatus getQueryStatus() {
		return queryStatus;
	}
	public void setQueryStatus(QueryStatus queryStatus) {
		this.queryStatus = queryStatus;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	
}
