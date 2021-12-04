package com.LearnersAcademy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.*;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/add-teacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-teacher.html").include(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Teacher teacher = populateValues(request);
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		org.hibernate.Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(teacher);
		
		tx.commit();
		
		PrintWriter out = response.getWriter();
		out.append("Teacher saved successfully");
				
	
	}

	private Teacher populateValues(HttpServletRequest request) {
		String teacher_name = request.getParameter("teacher_name");
		String teacher_address = request.getParameter("teacher_address");
		
		Teacher teacher = new Teacher();
		teacher.setTeacher_name(teacher_name);
		teacher.setTeacher_address(teacher_address);
		
		return teacher;
	}

}