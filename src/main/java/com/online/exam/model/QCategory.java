package com.online.exam.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Q_Category")
public class QCategory {
	@Id 
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "c_id")
	private Long cid;
	@Column(name="c_name")
	private String cname;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="qCategory")
	private Set<Questions> questions;
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}
	
}
