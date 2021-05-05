package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Payroll;
import dao.AdminDAO;

/**
 * Servlet implementation class AddPayroll
 */
public class AddPayroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPayroll() {
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
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		Date startDate = Date.valueOf(request.getParameter("startDate"));
		Date endDate = Date.valueOf(request.getParameter("endDate"));
		Double grossPay = Double.valueOf(request.getParameter("grossPay"));
		Double netPay = Double.valueOf(request.getParameter("netPay"));
		Double deductions = Double.valueOf(request.getParameter("deductions"));
		Double bonus = Double.valueOf(request.getParameter("bonus"));
		Integer hoursWorked = Integer.parseInt(request.getParameter("hoursWorked"));
		
		Payroll pay = new Payroll();
		pay.setId(id);
		pay.setEmpId(empId);
		pay.setStart(startDate);
		pay.setEnd(endDate);
		pay.setGrossPay(grossPay);
		pay.setNetPay(netPay);
		pay.setDeductions(deductions);
		pay.setBonus(bonus);
		pay.setHoursWorked(hoursWorked);
		try {
			Boolean result = AdminDAO.addPayroll(pay);
			if(result==false) {
				request.setAttribute("error", "Error while adding Payroll");
			}
			else {
				request.setAttribute("success", "Payroll Added Successfully");
			}
			RequestDispatcher rd = request.getRequestDispatcher("addPayroll.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error",e.toString());
			RequestDispatcher rd = request.getRequestDispatcher("addPayroll.jsp");
			rd.forward(request, response);
			
		}
	}

}
