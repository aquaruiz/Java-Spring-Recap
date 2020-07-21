package prototype;

public class Application {
	public static void main(String[] args) {
		Employees myEmployees = new Employees();
		myEmployees.addEmployee(new Employee("Penka"));
		myEmployees.addEmployee(new Employee("Reni"));
		myEmployees.addEmployee(new Employee("David"));
		myEmployees.addEmployee(new Employee("Ivan"));
		
		Employees nextEmployees = myEmployees.shallowClone();
		Employees moreEmployees = myEmployees.deepClone();
	}
}
