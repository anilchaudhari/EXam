package com.online.exam.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="Questions")
public class Questions {
	@Id 
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "Q_id")
	private Long q_id;
	@NotNull
	@Column(name = "q_name")
	private String q_name;
	@NotNull
	@Column(name = "op1")
	private String op1;
	@NotNull
	@Column(name = "op2")
	private String op2;
	@NotNull
	@Column(name = "op3")
	private String op3;
	@NotNull
	@Column(name = "op4")
	private String op4;
	@NotNull
	@Column(name = "postedby")
	private String postedby;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	private QCategory qCategory;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="questions")
	private Set<Answer> answers;
	
	public Long getQ_id() {
		return q_id;
	}
	public void setQ_id(Long q_id) {
		this.q_id = q_id;
	}
	
	public String getQ_name() {
		return q_name;
	}
	public void setQ_name(String q_name) {
		this.q_name = q_name;
	}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getOp4() {
		return op4;
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}
	public String getPostedby() {
		return postedby;
	}
	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}
	public QCategory getqCategory() {
		return qCategory;
	}
	public void setqCategory(QCategory qCategory) {
		this.qCategory = qCategory;
	}
	public Set<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
}
