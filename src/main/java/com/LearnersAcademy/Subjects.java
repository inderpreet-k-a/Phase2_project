package com.LearnersAcademy;

import javax.persistence.*;

@Entity
@Table
public class Subjects {

	@Id
	@GeneratedValue
	@Column
	private int subject_id;
	
	@Column
	private String subject_name;
	
	@Column
	private String department_name;

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
	
}