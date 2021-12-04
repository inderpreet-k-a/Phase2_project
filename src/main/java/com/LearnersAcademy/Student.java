package com.LearnersAcademy;

import javax.persistence.*;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue
	@Column
	private int student_id;
	
	@Column
	private String student_name;
	
	@Column
	private String student_address;
		
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
		
}