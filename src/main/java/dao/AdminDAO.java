package dao;
import beans.Employee.Gender;
import beans.Job;
import beans.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Department;
import beans.Employee;
import beans.Works_On;


public class AdminDAO extends EmployeeDAO{
	
	public static List<Employee> getAllEmployees() throws SQLException{
		String statement = "select employee.id, employee.name, employee.gender, employee.address, employee.contact_no, employee.job_id, employee.dep_id, employee.dob from employee inner join login on employee.id=login.id";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement);
		ResultSet rs = stmt.executeQuery();
			if(rs != null) {
				List<Employee> users = new ArrayList<>();
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setId(rs.getInt(1));
					emp.setName(rs.getString(2));
					emp.setGender(Gender.valueOf(rs.getString(3)));
					emp.setAddress(rs.getString(4));
					emp.setContactNo(rs.getString(5));
					emp.setJobId(rs.getInt(6));
					emp.setDepId(rs.getInt(7));
					emp.setDob(rs.getDate(8));
					users.add(emp);
				}
				return users;
			}
		    else{
				return null;
			}
	}
	
	public static boolean addEmployee(Employee emp) throws SQLException {
		String statement = "insert into employee values(?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, emp.getId());
		stmt.setString(2,emp.getName());
		stmt.setString(3, emp.getGender().toString());
		stmt.setString(4, emp.getAddress());
		stmt.setInt(5, emp.getJobId());
		stmt.setInt(6, emp.getDepId());
		stmt.setString(7,emp.getContactNo());
		stmt.setDate(8, emp.getDob());
		int rs = stmt.executeUpdate();
		if(rs!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static List<Department> getDepartments() throws SQLException{
		String statement = "select * from department";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement);
		ResultSet rs = stmt.executeQuery();
		if(rs != null) {
			List<Department> depars = new ArrayList<>();
			while(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt(1));
				dep.setName(rs.getString(2));
				dep.setFullName(rs.getString(3));
				depars.add(dep);
			}
			return depars;
		}
	    else{
			return null;
		}
	}
	
	public static List<Job> getJobs() throws SQLException{
		String statement = "select * from jobs";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement);
		ResultSet rs = stmt.executeQuery();
		if(rs != null) {
			List<Job> jobs = new ArrayList<>();
			while(rs.next()) {
				Job job = new Job();
				job.setId(rs.getInt(1));
				job.setTitle(rs.getString(2));
				job.setDescription(rs.getString(3));
				job.setTotalJobs(rs.getInt(4));
				job.setVacancies(rs.getInt(5));
				job.setDepId(rs.getInt(6));
				jobs.add(job);
			}
			return jobs;
		}
	    else{
			return null;
		}
	}
	public static List<Project> getProjects() throws SQLException{
		String statement = "select * from project";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement);
		ResultSet rs = stmt.executeQuery();
		if(rs != null) {
			List<Project> projects = new ArrayList<>();
			while(rs.next()) {
				Project project = new Project();
				project.setId(rs.getInt(1));
				project.setName(rs.getString(2));
				project.setDescription(rs.getString(3));
				project.setDepId(rs.getInt(4));
				project.setDueDate(rs.getDate(5));
				project.setAssignDate(rs.getDate(6));
				project.setStatus(rs.getString(7));
				project.setSubmissionDate(rs.getDate(8));
				projects.add(project);
			}
			return projects;
		}
	    else{
			return null;
		}
	}
	
	public static List<Works_On> getWorkingProjects() throws SQLException{
		String statement = "select * from works_on";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement);
		ResultSet rs = stmt.executeQuery();
		if(rs != null) {
			List<Works_On> works = new ArrayList<>();
			while(rs.next()) {
				Works_On work = new Works_On();
				work.setEmpId(rs.getInt(1));
				work.setPrId(rs.getInt(2));
				work.setRole(rs.getString(3));
				works.add(work);
			}
			return works;
		}
	    else{
			return null;
		}
	}
	
	public static boolean addProject(Project project) throws SQLException {
		String statement = "insert into project values(?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, project.getId());
		stmt.setString(2,project.getName());
		stmt.setString(3, project.getDescription());
		stmt.setInt(4, project.getDepId());
		stmt.setDate(5, project.getDueDate());
		stmt.setDate(6, project.getAssignDate());
		stmt.setString(7,project.getStatus());
		stmt.setDate(8, project.getSubmissionDate());
		System.out.println(stmt);
		int rs = stmt.executeUpdate();
		if(rs!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean addDepartment(Department dep) throws SQLException {
		String statement = "insert into department values(?,?,?)";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, dep.getId());
		stmt.setString(2,dep.getName());
		stmt.setString(3, dep.getFullName());
		int rs = stmt.executeUpdate();
		if(rs!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean addJob(Job job) throws SQLException {
		String statement = "insert into jobs values(?,?,?,?,?,?)";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
		
		stmt.setInt(1, job.getId());
		stmt.setString(2,job.getTitle());
		stmt.setString(3, job.getDescription());
		stmt.setInt(4, job.getTotalJobs());
		stmt.setInt(5, job.getVacancies());
		stmt.setInt(6, job.getDepId());
		int rs = stmt.executeUpdate();
		if(rs!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean assignProject(Works_On works) throws SQLException {
		String statement = "insert into works_on values(?,?,?)";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
		
		stmt.setInt(1, works.getEmpId());
		stmt.setInt(2, works.getPrId());
		stmt.setString(3, works.getRole());
		int rs = stmt.executeUpdate();
		if(rs!=0) {
			return true;
		}
		else {
			return false;
		}
	}
}
