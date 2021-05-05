package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Login;
import dao.EmployeeDAO;
/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String type = request.getParameter("type");

		try {
			Login result = EmployeeDAO.checkLoginDetails(email, password);
			if(result != null) {
				request.setAttribute("user", result);
				request.setAttribute("error", null);
				
				if(type.equals("admin")) {
					if((result.getType()).equals("admin")){
						RequestDispatcher rd = request.getRequestDispatcher("adminDashboard.jsp");
						rd.forward(request, response);
					}
					else {
						RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						request.setAttribute("error", "You are not admin");
						rd.forward(request, response);
					}
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("employeeDashboard.jsp");
					rd.forward(request, response);
				}				
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				request.setAttribute("error", "Invalid Email and password");
				rd.forward(request, response);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("error", e.toString());
			rd.forward(request, response);
		}
	}
}
