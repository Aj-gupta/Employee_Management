package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Works_On;
import dao.AdminDAO;

/**
 * Servlet implementation class AssignProject
 */
public class AssignProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		Integer prid = Integer.parseInt(request.getParameter("prId"));
		
		Integer empid = Integer.parseInt(request.getParameter("empId"));
		
		String role = request.getParameter("role");
		Works_On works = new Works_On();
		works.setEmpId(empid);
		works.setPrId(prid);
		works.setRole(role);
		request.setAttribute("works", works);
		try {
			Boolean result = AdminDAO.assignProject(works);
			if(result==false) {
				request.setAttribute("error", "Error while Assigning project");
			}
			else {
				request.setAttribute("success", "Project Assigned Successfully");
			}
			RequestDispatcher rd = request.getRequestDispatcher("assignProject.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error",e.toString());
			RequestDispatcher rd = request.getRequestDispatcher("assignProject.jsp");
			rd.forward(request, response);			
		}
	}

}
