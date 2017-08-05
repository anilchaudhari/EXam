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
@Table(name="results")
public class Result {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "id")
	@NotNull
	private Long id;
	@Column(name="obtained_marks")
	private Float obtainedMarks;
	@Column(name="total_marks")
	private Integer totalMarks;
	@Column(name="percentage")
	private Float percentage;
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
	public Float getObtainedMarks() {
		return obtainedMarks;
	}
	public void setObtainedMarks(Float obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}
	public Integer getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
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
