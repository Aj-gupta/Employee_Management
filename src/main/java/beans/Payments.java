package beans;

import java.sql.Date;

public class Payments {
	private int id , empId;
	private Date start, end, paymentDate; 
	private Double amount;
	public int getId() {
		return id;
	}
	public int getEmpId() {
		return empId;
	}
	
	public Date getStart() {
		return start;
	}
	public Date getEnd() {
		return end;
	}
	public Double getAmount() {
		return amount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
}
