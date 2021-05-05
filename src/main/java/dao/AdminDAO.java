package dao;
import beans.Employee.Gender;
import beans.Job;
import beans.Project;
import beans.Employee_Leave;
import beans.Pay_Rate;
import beans.Bonus;
import beans.Deductions;
import beans.Payments;
import beans.Payroll;

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
	
	public static List<Employee_Leave> getEmployeeLeaves() throws SQLException{
		String statement = "select * from employee_leave";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement);
		ResultSet rs = stmt.executeQuery();
		if(rs != null) {
			List<Employee_Leave> leaves = new ArrayList<>();
			while(rs.next()) {
				Employee_Leave leave = new Employee_Leave();
				leave.setToken(rs.getInt(1));
				leave.setEmpId(rs.getInt(2));
				leave.setStartDate(rs.getDate(3));
				leave.setEndDate(rs.getDate(4));
				leave.setTotalDays(rs.getInt(5));
				leave.setReason(rs.getString(5));
				leave.setStatus(rs.getString(7));
				leaves.add(leave);
			}
			return leaves;
		}
	    else{
			return null;
		}
	}
	
	public static List<Pay_Rate> getPayRate() throws SQLException{
		String statement = "select * from pay_rate";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement);
		ResultSet rs = stmt.executeQuery();
		if(rs != null) {
			List<Pay_Rate> rates = new ArrayList<>();
			while(rs.next()) {
				Pay_Rate rate = new Pay_Rate();
				rate.setJobId(rs.getInt(1));			
				rate.setPerYear(rs.getDouble(2));
				rate.setPerHour(rs.getDouble(3));
				rates.add(rate);
			}
			return rates;
		}
	    else{
			return null;
		}
	}
	public static List<Bonus> getBonus() throws SQLException{
		String statement = "select * from bonus";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement);
		ResultSet rs = stmt.executeQuery();
		if(rs != null) {
			List<Bonus> bonus = new ArrayList<>();
			while(rs.next()) {
				Bonus bons = new Bonus();
				bons.setId(rs.getInt(1));
				bons.setEmpId(rs.getInt(2));
				bons.setStart(rs.getDate(3));
				bons.setEnd(rs.getDate(4));
				bons.setAmount(rs.getDouble(5));
				bons.setType(rs.getString(6));
				bonus.add(bons);
			}
			return bonus;
		}
	    else{
			return null;
		}
	}
	
	public static List<Deductions> getDeductions() throws SQLException{
		String statement = "select * from deductions";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement);
		ResultSet rs = stmt.executeQuery();
		if(rs != null) {
			List<Deductions> deductions = new ArrayList<>();
			while(rs.next()) {
				Deductions deduction = new Deductions();
				deduction.setId(rs.getInt(1));
				deduction.setType(rs.getString(2));
				deduction.setStart(rs.getDate(3));
				deduction.setEnd(rs.getDate(4));
				deduction.setAmount(rs.getDouble(5));
				deduction.setEmpId(rs.getInt(6));
				deductions.add(deduction);
			}
			return deductions;
		}
	    else{
			return null;
		}
	}
	public static List<Payroll> getPayroll() throws SQLException{
		String statement = "select * from payroll";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement);
		ResultSet rs = stmt.executeQuery();
		if(rs != null) {
			List<Payroll> payroll = new ArrayList<>();
			while(rs.next()) {
				Payroll pay = new Payroll();
				pay.setId(rs.getInt(1));
				pay.setEmpId(rs.getInt(2));
				pay.setStart(rs.getDate(3));
				pay.setEnd(rs.getDate(4));
				pay.setGrossPay(rs.getDouble(5));
				pay.setNetPay(rs.getDouble(6));
				pay.setDeductions(rs.getDouble(7));
				pay.setBonus(rs.getDouble(8));
				pay.setHoursWorked(rs.getInt(9));
			}
			return payroll;
		}
	    else{
			return null;
		}
	}
	
	public static List<Payments> getPayments() throws SQLException{
		String statement = "select * from payments";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement);
		ResultSet rs = stmt.executeQuery();
		if(rs != null) {
			List<Payments> payments = new ArrayList<>();
			while(rs.next()) {
				Payments payment = new Payments();
				payment.setId(rs.getInt(1));
				payment.setEmpId(rs.getInt(2));
				payment.setStart(rs.getDate(3));
				payment.setEnd(rs.getDate(4));
				payment.setAmount(rs.getDouble(5));
				payment.setPaymentDate(rs.getDate(6));
				payments.add(payment);
			}
			return payments;
		}
	    else{
			return null;
		}
	}
	
	public static boolean addJobPayRate(Pay_Rate pay) throws SQLException {
		String statement = "insert into pay_rate values(?,?,?)";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
		
		stmt.setInt(1, pay.getJobId());
		stmt.setDouble(2, pay.getPerYear());
		stmt.setDouble(3, pay.getPerHour());
		int rs = stmt.executeUpdate();
		if(rs!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean addEmployeeLeave(Employee_Leave lev) throws SQLException {
		String statement = "insert into employee_leave values(?,?,?,?,?,?,?)";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, lev.getToken());
		stmt.setInt(2, lev.getEmpId());
		stmt.setDate(3, lev.getStartDate());
		stmt.setDate(4, lev.getEndDate());
		stmt.setInt(5, lev.getTotalDays());
		stmt.setString(6, lev.getReason());
		stmt.setString(7, lev.getStatus()==null?"Pending":lev.getStatus());
		int rs = stmt.executeUpdate();
		if(rs!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean addDeduction(Deductions ded) throws SQLException {
		String statement = "insert into deductions values(?,?,?,?,?,?)";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, ded.getId());
		stmt.setString(2, ded.getType());
		stmt.setDate(3, ded.getStart());
		stmt.setDate(4, ded.getEnd());
		stmt.setDouble(5, ded.getAmount());
		stmt.setInt(6, ded.getEmpId());
		int rs = stmt.executeUpdate();
		if(rs!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean addPayroll(Payroll pay) throws SQLException {
		String statement = "insert into employee_leave values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, pay.getId());
		stmt.setInt(2, pay.getEmpId());
		stmt.setDate(3, pay.getStart());
		stmt.setDate(4, pay.getEnd());
		stmt.setDouble(5, pay.getGrossPay());
		stmt.setDouble(6, pay.getNetPay());
		stmt.setDouble(7, pay.getDeductions());
		stmt.setDouble(8, pay.getBonus());
		stmt.setInt(9, pay.getHoursWorked());
		int rs = stmt.executeUpdate();
		if(rs!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean addPayments(Payments pays) throws SQLException {
		String statement = "insert into employee_leave values(?,?,?,?,?,?)";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, pays.getId());
		stmt.setInt(2, pays.getEmpId());
		stmt.setDate(3, pays.getStart());
		stmt.setDate(4, pays.getEnd());
		stmt.setDouble(5, pays.getAmount());
		stmt.setDate(6, pays.getPaymentDate());
		int rs = stmt.executeUpdate();
		if(rs!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean addBonus(Bonus bon) throws SQLException {
		String statement = "insert into bonus values(?,?,?,?,?,?)";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, bon.getId());
		stmt.setInt(2, bon.getEmpId());
		stmt.setDate(3, bon.getStart());
		stmt.setDate(4, bon.getEnd());
		stmt.setDouble(5, bon.getAmount());
		stmt.setString(6, bon.getType());
		int rs = stmt.executeUpdate();
		if(rs!=0) {
			return true;
		}
		else {
			return false;
		}
	}
}
