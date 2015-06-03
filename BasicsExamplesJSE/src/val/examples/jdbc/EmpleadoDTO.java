package val.examples.jdbc;


import java.util.Date;

public class EmpleadoDTO {
	
	private int employee_Id;
	private String first_Name;
	private String last_Name;
	private String email;
	private String phone_Number;
	private Date hire_Date;
	private String job_Id;
	private float salary;
	private String commission_Pct;
	private String manager_Id;
	private int department_Id;
	
	
	
	public EmpleadoDTO(int employee_Id, String first_Name, String last_Name,
			String email, String phone_Number, Date hire_Date, String job_Id,
			float salary, String commission_Pct, String manager_Id,
			int department_Id) {
		this.employee_Id = employee_Id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.email = email;
		this.phone_Number = phone_Number;
		this.hire_Date = hire_Date;
		this.job_Id = job_Id;
		this.salary = salary;
		this.commission_Pct = commission_Pct;
		this.manager_Id = manager_Id;
		this.department_Id = department_Id;
	}
	public int getEmployee_Id() {
		return employee_Id;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone_Number() {
		return phone_Number;
	}
	public Date getHire_Date() {
		return hire_Date;
	}
	public String getJob_Id() {
		return job_Id;
	}
	public float getSalary() {
		return salary;
	}
	public String getCommission_Pct() {
		return commission_Pct;
	}
	public String getManager_Id() {
		return manager_Id;
	}
	public int getDepartment_Id() {
		return department_Id;
	}	
	
	@Override
	public String toString() {
		return first_Name + "\t \t " + salary;
	}
}
