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
@WebServlet("/get-classes")
public class ListClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListClasses() {
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
		
		List<Classes> classOB = session.createQuery("from Classes").list();
		
		if(classOB!=null) {
			
			out.print("<h1> Classes List :- </h1>");
			out.print("<style> table,td,th { border:2px solid yellow; padding:10px;}</style>");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Class Id </th>");
			out.print("<th> Class Name </th>");
			out.print("</tr>");
			
			for(Classes cOB : classOB) {
				out.print("<tr>");
				out.print("<td>"+cOB.getClass_id()+"</td>");
				out.print("<td>"+cOB.getClass_name()+"</td>");
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
