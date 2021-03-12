package beans;
import java.sql.Date;

public class Employee extends Login{
	public enum Gender {
	    M,
	    F
	}
	private Integer id,jobId=null,depId=null;
	private String name,address,contact_no;
	private Gender gender;
	private Date dob;
	
	public void setId(Integer id) {this.id = id;}
	public void setName(String name) {this.name = name;}
	public void setGender(Gender gender) {this.gender = gender;}
	public void setAddress(String address) {this.address = address;}
	public void setContactNo(String contact) {this.contact_no =contact;} 
	public void setJobId(Integer jobId) {this.jobId = jobId;}
	public void setDepId(Integer depId) {this.depId = depId;}
	public void setDob(Date dob) {this.dob = dob;}
	
	public Integer getId() {return id;}
	public String getName() {return name;}
	public Gender getGender() {return gender;}
	public String getAddress() { return address;}
	public String getContactNo() {return contact_no;}
	public Integer getJobId() {return jobId;}
	public Integer getDepId() {return depId;}
	public Date getDob() {return dob;}
	
}