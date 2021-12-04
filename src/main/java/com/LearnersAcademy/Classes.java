package com.LearnersAcademy;

import javax.persistence.*;

@Entity
@Table
public class Classes {

	@Id
	@GeneratedValue
	@Column
	private int class_id;
	
	@Column
	private String class_name;
		
	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	
}
