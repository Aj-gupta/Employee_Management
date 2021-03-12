package beans;

public class Department {
	private Integer id;
	private String name,fullName;
	public void setId(Integer id) {this.id = id;}
	public void setName(String name) {this.name = name;}
	public void setFullName(String fullName) {this.fullName = fullName;}
	
	public Integer getId() {return id;}
	public String getName() {return name;}
	public String getFullName(){return fullName;}
}
