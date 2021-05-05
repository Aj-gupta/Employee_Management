package beans;

import java.sql.Date;

public class Payroll {
	private int id , empId,hoursWorked;
	private Date start, end; 
	private Double grossPay, netPay, deductions, bonus;
	
	public int getId() {
		return id;
	}
	public int getEmpId() {
		return empId;
	}
	public int getHoursWorked() {
		return hoursWorked;
	}
	public Date getStart() {
		return start;
	}
	public Date getEnd() {
		return end;
	}
	
	public Double getGrossPay() {
		return grossPay;
	}
	public Double getDeductions() {
		return deductions;
	}
	public Double getNetPay() {
		return netPay;
	}
	public Double getBonus() {
		return bonus;
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
	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public void setGrossPay(Double grossPay) {
		this.grossPay = grossPay;
	}
	public void setDeductions(Double deductions) {
		this.deductions = deductions;
	}
	public void setNetPay(Double netPay) {
		this.netPay = netPay;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
}
