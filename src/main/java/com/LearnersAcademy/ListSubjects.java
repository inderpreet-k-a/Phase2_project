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
@WebServlet("/get-subjects")
public class ListSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSubjects() {
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
		
		List<Subjects> subject = session.createQuery("from Subjects").list();
		
		if(subject!=null) {
			
			out.print("<h1> Subjects List :- </h1>");
			out.print("<style> table,td,th { border:2px solid yellow; padding:10px;}</style>");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Subject Id </th>");
			out.print("<th> Subject Name </th>");
			out.print("<th> Subject Department</th>");
			out.print("</tr>");
			
			for(Subjects sub : subject) {
				out.print("<tr>");
				out.print("<td>"+sub.getSubject_id()+"</td>");
				out.print("<td>"+sub.getSubject_name()+"</td>");
				out.print("<td>"+sub.getDepartment_name()+"</td>");
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
