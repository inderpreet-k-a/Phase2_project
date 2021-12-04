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
@WebServlet("/add-student")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-student.html").include(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Student student = populateValues(request);
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		org.hibernate.Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(student);
		
		tx.commit();
		
		PrintWriter out = response.getWriter();
		out.append("Student saved successfully");
				
	
	}

	private Student populateValues(HttpServletRequest request) {
		String student_name = request.getParameter("student_name");
		String student_address = request.getParameter("student_address");
		
		Student student = new Student();
		student.setStudent_name(student_name);
		student.setStudent_address(student_address);
		
		return student;
	}

}