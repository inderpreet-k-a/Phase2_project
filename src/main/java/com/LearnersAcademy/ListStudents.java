package com.LearnersAcademy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class ListStudents
 */
@WebServlet("/get-student")
public class ListStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		
		List<Student> students = session.createQuery("from Student").list();
		
		if(students!=null) {
			
			out.print("<h1> Student List :- </h1>");
			out.print("<style> table,td,th { border:2px solid yellow; padding:10px;}</style>");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Student Id </th>");
			out.print("<th> Student Name </th>");
			out.print("<th> Student Address</th>");
			out.print("</tr>");
			
			for(Student student : students) {
				out.print("<tr>");
				out.print("<td>"+student.getStudent_id()+"</td>");
				out.print("<td>"+student.getStudent_name()+"</td>");
				out.print("<td>"+student.getStudent_address()+"</td>");
				out.print("</tr>");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
