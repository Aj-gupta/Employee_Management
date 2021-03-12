package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Employee;
import beans.Employee.Gender;
import dao.AdminDAO;
import java.sql.Date;

/**
 * Servlet implementation class AddEmployee
 */
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		// TODO Auto-generated method stub
//		doGet(request, response);
			Integer empid = Integer.parseInt(request.getParameter("empId"));
			
			Integer jobid = request.getParameter("jobId").equals("")?null:Integer.parseInt(request.getParameter("jobId"));
			Integer depid = request.getParameter("depId").equals("")?null:Integer.parseInt(request.getParameter("depId"));
			String contact = request.getParameter("contactNo");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			Gender gen = Gender.valueOf(request.getParameter("gender"));
			Date dob = request.getParameter("dob").equals("")?null:Date.valueOf(request.getParameter("dob"));
			
			Employee emp = new Employee();
			emp.setId(empid);
			emp.setAddress(address);
			emp.setContactNo(contact);
			emp.setJobId(jobid);
			emp.setDepId(depid);
			emp.setName(name);
			emp.setGender(gen);
			emp.setDob(dob);
			request.setAttribute("emp", emp);
			try {
				Boolean result = AdminDAO.addEmployee(emp);
				if(result==false) {
					request.setAttribute("error", "Error while adding employee");
					RequestDispatcher rd = request.getRequestDispatcher("addEmployee.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("success", "Employee Added Successfully");
					RequestDispatcher rd = request.getRequestDispatcher("addEmployee.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				request.setAttribute("error",e.toString() );
				RequestDispatcher rd = request.getRequestDispatcher("addEmployee.jsp");
				rd.forward(request, response);
				
			}
	}
}
