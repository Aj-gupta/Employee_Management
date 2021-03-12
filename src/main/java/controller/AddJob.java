package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Job;
import dao.AdminDAO;

/**
 * Servlet implementation class AddJob
 */
public class AddJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJob() {
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
		String jobtitle = request.getParameter("jobTitle");
		String jobdesc = request.getParameter("jobDesc");
		Integer totaljobs = Integer.parseInt(request.getParameter("totalJobs"));
		Integer vacacies = Integer.parseInt(request.getParameter("vacancies"));
		Integer depid = Integer.parseInt(request.getParameter("depId"));
		
		Job job = new Job();
		job.setId(jobid);
		job.setDepId(depid);
		job.setDescription(jobdesc);
		job.setTitle(jobtitle);;
		job.setTotalJobs(totaljobs);
		job.setVacancies(vacacies);
		request.setAttribute("job", job);
		try {
			Boolean result = AdminDAO.addJob(job);
			if(result==false) {
				request.setAttribute("error", "Error while adding Job");
			}
			else {
				request.setAttribute("success", "Job Added Successfully");
			}
			RequestDispatcher rd = request.getRequestDispatcher("addJob.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error",e.toString());
			RequestDispatcher rd = request.getRequestDispatcher("addJob.jsp");
			rd.forward(request, response);
			
		}
	}

}
