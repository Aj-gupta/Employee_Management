package beans;
import java.sql.Date;

public class Employee_Leave {
	private int token, empId, totalDays;
	private Date startDate, endDate;
	private String reason,status;
	
	public void setToken(int token) {
		this.token = token;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getToken() {
		return token;
	}
	public int getEmpId() {
		return empId;
	}
	public int getTotalDays() {
		return totalDays;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public String getReason() {
		return reason;
	}
	public String getStatus() {
		return status;
	}
}
