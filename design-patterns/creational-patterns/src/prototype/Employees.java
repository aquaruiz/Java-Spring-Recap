package prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Prototype<Employees>{

	private List<Employee> empList;
	
	public Employees(){
		empList = new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee employee) {
		this.empList.add(employee);
	}
	
	public List<Employee> getAllEmpoyees() {
		return empList;
	}

	@Override
	public Employees clone() {
		Employees newEmployees = new Employees();
		
		for(Employee s : this.getAllEmpoyees()){
			newEmployees.addEmployee(s);
		}
		
		return newEmployees;
	}
}
