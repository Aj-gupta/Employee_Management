package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Payments;
import dao.AdminDAO;

/**
 * Servlet implementation class AddPayments
 */
public class AddPayments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPayments() {
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
		Double amount = Double.valueOf(request.getParameter("amount"));
		Date paymentDate = Date.valueOf(request.getParameter("paymentDate"));
		
		Payments payment = new Payments();
		payment.setId(id);
		payment.setEmpId(empId);
		payment.setStart(startDate);
		payment.setEnd(endDate);
		payment.setAmount(amount);
		payment.setPaymentDate(paymentDate);
		try {
			Boolean result = AdminDAO.addPayments(payment);
			if(result==false) {
				request.setAttribute("error", "Error while adding Payment");
			}
			else {
				request.setAttribute("success", "Payment Added Successfully");
			}
			RequestDispatcher rd = request.getRequestDispatcher("addPayments.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error",e.toString());
			RequestDispatcher rd = request.getRequestDispatcher("addPayments.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
