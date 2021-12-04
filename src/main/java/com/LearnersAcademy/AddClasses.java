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
@WebServlet("/add-classes")
public class AddClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClasses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-classes.html").include(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Classes classOB = populateValues(request);
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		org.hibernate.Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(classOB);
		
		tx.commit();
		
		PrintWriter out = response.getWriter();
		out.append("Class information saved successfully");
				
	
	}

	private Classes populateValues(HttpServletRequest request) {
		String class_name = request.getParameter("class_name");
	
		Classes classOB = new Classes();
		classOB.setClass_name(class_name);
				
		return classOB;
	}
}
