package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Employee_Leave;
import dao.AdminDAO;

/**
 * Servlet implementation class AddEmployeeLeave
 */
public class AddEmployeeLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeLeave() {
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
		Integer token = Integer.parseInt(request.getParameter("token"));
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		Integer totalDays = Integer.parseInt(request.getParameter("totalDays"));
		Date startDate= Date.valueOf(request.getParameter("startDate"));
		Date endDate= Date.valueOf(request.getParameter("endDate"));
		String reason = request.getParameter("reason");
		Employee_Leave leave = new Employee_Leave();
		leave.setToken(token);
		leave.setEmpId(empId);
		leave.setTotalDays(totalDays);
		leave.setStartDate(startDate);
		leave.setEndDate(endDate);
		leave.setReason(reason);
		try {
			Boolean result = AdminDAO.addEmployeeLeave(leave);
			if(result==false) {
				request.setAttribute("error", "Error while adding leave");
			}
			else {
				request.setAttribute("success", "Leave Added Successfully");
			}
			RequestDispatcher rd = request.getRequestDispatcher("addEmployeeLeave.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error",e.toString());
			RequestDispatcher rd = request.getRequestDispatcher("addEmployeeLeave.jsp");
			rd.forward(request, response);
			
		}
	}

}
