package com.LearnersAcademy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	
	SessionFactory sf=null;
	
	public static SessionFactory buildSessionFactory()
	{
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Teacher.class).addAnnotatedClass(Classes.class).addAnnotatedClass(Subjects.class).buildSessionFactory();
		return sf;
	}
}