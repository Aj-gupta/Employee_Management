package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

import beans.Project;
import dao.AdminDAO;

/**
 * Servlet implementation class AddProject
 */
public class AddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProject() {
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
		Integer prid = Integer.parseInt(request.getParameter("prId"));
		
		Integer depid = Integer.parseInt(request.getParameter("depId"));
		
		String description = request.getParameter("description");
		String name = request.getParameter("name");
		Date duedate = Date.valueOf(request.getParameter("dueDate"));
		Date assigndate = Date.valueOf(request.getParameter("assignDate"));
		Date subDate = request.getParameter("subDate").equals("")?null:Date.valueOf(request.getParameter("subDate"));
		String status = request.getParameter("status");
		Project project = new Project();
		project.setId(prid);
		project.setDepId(depid);
		project.setDescription(description);
		project.setName(name);
		project.setAssignDate(assigndate);
		project.setDueDate(duedate);
		project.setStatus(status);
		project.setSubmissionDate(subDate);
		request.setAttribute("project", project);
		try {
			Boolean result = AdminDAO.addProject(project);
			if(result==false) {
				request.setAttribute("error", "Error while adding project");
			}
			else {
				request.setAttribute("success", "Project Added Successfully");
			}
			RequestDispatcher rd = request.getRequestDispatcher("addProject.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error",e.toString());
			RequestDispatcher rd = request.getRequestDispatcher("addProject.jsp");
			rd.forward(request, response);
			
		}
	}
}

