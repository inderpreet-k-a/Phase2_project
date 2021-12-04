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
@WebServlet("/add-subjects")
public class AddSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjects() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-subjects.html").include(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Subjects subject = populateValues(request);
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		org.hibernate.Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(subject);
		
		tx.commit();
		
		PrintWriter out = response.getWriter();
		out.append("Subject saved successfully");
				
	
	}

	private Subjects populateValues(HttpServletRequest request) {
		String subject_name = request.getParameter("subject_name");
		String department_name = request.getParameter("department_name");
		
		Subjects subject = new Subjects();
		subject.setSubject_name(subject_name);
		subject.setDepartment_name(department_name);
		
		return subject;
	}
}