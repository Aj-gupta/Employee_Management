package beans;

public class Job {
	private Integer id,totalJobs, vacancies, depId;
	private String title, descrip;
	
	public void setId(Integer id) {this.id = id;}
	public void setTotalJobs(Integer totalJobs) {this.totalJobs = totalJobs;}
	public void setVacancies(Integer vacancies) {this.vacancies = vacancies;}
	public void setDepId(Integer depId) {this.depId = depId;}
	public void setTitle(String title) {this.title = title;}
	public void setDescription(String descrip) {this.descrip = descrip;}
	
	public Integer getId() {return id;}
	public Integer getTotalJobs(){return totalJobs;}
	public Integer getVacancies() {return vacancies;}
	public Integer getDepId() {return depId;}
	public String getTitle() {return title;}
	public String getDescription() {return descrip;}
}
