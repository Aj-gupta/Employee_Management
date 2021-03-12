package beans;
import java.sql.Date;
public class Project {
	private Integer id,depId;
	private String name,description,status;
	private Date dueDate, assignDate,submissionDate;
	public void setId(Integer id) {this.id = id;}
	public void setDepId(Integer depId) {this.depId = depId;}
	public void setName(String name) {this.name = name;}
	public void setDescription(String description) {this.description = description;}
	public void setDueDate(Date dueDate) {this.dueDate = dueDate;}
	public void setAssignDate(Date assignDate) {this.assignDate = assignDate;}
	public void setSubmissionDate(Date submissionDate) {this.submissionDate = submissionDate;}
	public void setStatus(String status) {this.status = status;}
	
	public Integer getId() {return id;}
	public String getName() {return name;}
	public String getDescription(){return description;}
	public Integer getDepId() {return depId;}
	public Date getAssignDate() {return assignDate;}
	public Date getDueDate() {return dueDate;}
	public Date getSubmissionDate() {return submissionDate;}
	public String getStatus() {return status;}
}
