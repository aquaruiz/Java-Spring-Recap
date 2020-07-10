package prototype;

public class Application {
	public static void main(String[] args) {
		Employees myEmployees = new Employees();
		myEmployees.loadData();
		
		Employees nextEmployees = myEmployees.clone();
	}
}
