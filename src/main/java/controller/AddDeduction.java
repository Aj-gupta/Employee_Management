package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Deductions;
import dao.AdminDAO;

/**
 * Servlet implementation class AddDeduction
 */
public class AddDeduction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDeduction() {
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
//		 TODO Auto-generated method stub
//		doGet(request, response);
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		Date startDate = Date.valueOf(request.getParameter("startDate"));
		Date endDate = Date.valueOf(request.getParameter("endDate"));
		Double amount = Double.valueOf(request.getParameter("amount"));
		String type = request.getParameter("type");
		
		Deductions ded = new Deductions();
		ded.setId(id);
		ded.setEmpId(empId);
		ded.setStart(startDate);
		ded.setEnd(endDate);
		ded.setAmount(amount);
		ded.setType(type);
		try {
			Boolean result = AdminDAO.addDeduction(ded);
			if(result==false) {
				request.setAttribute("error", "Error while adding Deduction");
			}
			else {
				request.setAttribute("success", "Deduction Added Successfully");
			}
			RequestDispatcher rd = request.getRequestDispatcher("addDeduction.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error",e.toString());
			RequestDispatcher rd = request.getRequestDispatcher("addDeduction.jsp");
			rd.forward(request, response);
			
		}
	}

}
