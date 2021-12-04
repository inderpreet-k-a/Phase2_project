package com.LearnersAcademy;

import javax.persistence.*;

@Entity
@Table
public class Teacher {

	@Id
	@GeneratedValue
	@Column
	private int teacher_id;
	
	@Column
	private String teacher_name;
	
	@Column
	private String teacher_address;
	
	
	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_address() {
		return teacher_address;
	}

	public void setTeacher_address(String teacher_address) {
		this.teacher_address = teacher_address;
	}

	}