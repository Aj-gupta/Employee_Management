package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Department;
import dao.AdminDAO;

/**
 * Servlet implementation class AddDepartment
 */
public class AddDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDepartment() {
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
		Integer depid =Integer.parseInt(request.getParameter("depId"));
		
		String name = request.getParameter("name");
		String fullName = request.getParameter("fullName");
		Department dep = new Department();
		dep.setId(depid);
		dep.setName(name);
		dep.setFullName(fullName);
		request.setAttribute("dep", dep);
		try {
			Boolean result = AdminDAO.addDepartment(dep);
			if(result==false) {
				request.setAttribute("error", "Error while adding department");	
			}
			else {
				request.setAttribute("success", "Department Added Successfully");
			}
			RequestDispatcher rd = request.getRequestDispatcher("addDepartment.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error",e.toString() );
			RequestDispatcher rd = request.getRequestDispatcher("addEmployee.jsp");
			rd.forward(request, response);
			
		}
	}

}
