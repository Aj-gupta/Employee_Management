package beans;

public class Pay_Rate {
	private int jobId;
	private double perHour, perYear;
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public void setPerHour(double perHour) {
		this.perHour = perHour;
	}
	public void setPerYear(double perYear) {
		this.perYear = perYear;
	}
	
	public int getJobId() {
		return jobId;
	}
	public double getPerHour() {
		return perHour;		
	}
	public double getPerYear() {
		return perYear;
	}
	
}
