package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Pay_Rate;
import dao.AdminDAO;

/**
 * Servlet implementation class AddJobPayRate
 */
public class AddJobPayRate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJobPayRate() {
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
		Integer jobid = Integer.parseInt(request.getParameter("jobId"));
		Double perYear = Double.parseDouble(request.getParameter("perYear"));
		Double perHour = Double.parseDouble(request.getParameter("perHour"));
		
		Pay_Rate pay = new Pay_Rate();
		pay.setJobId(jobid);
		pay.setPerYear(perYear);
		pay.setPerHour(perHour);
		
		try {
			Boolean result = AdminDAO.addJobPayRate(pay);
			if(result==false) {
				request.setAttribute("error", "Error while adding Pay Rate");
			}
			else {
				request.setAttribute("success", "Pay Rate Added Successfully");
			}
			RequestDispatcher rd = request.getRequestDispatcher("addJobPayRate.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error",e.toString());
			RequestDispatcher rd = request.getRequestDispatcher("addJobPayRate.jsp");
			rd.forward(request, response);
			
		}
	}

}
