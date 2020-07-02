
public class Employee {
	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public boolean salaryIncrement(double d) {
		this.salary += d * this.salary;
		return true;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	
	@Override
	public String toString() {
		return String.format("Employee # %d - %s, salary: $%.2f", 
				this.id, this.name, this.salary);
	}
}
