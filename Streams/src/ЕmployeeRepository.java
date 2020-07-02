import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ЕmployeeRepository {
	Map<Integer, Employee> employees;
	
	public ЕmployeeRepository(){
		this.employees = new HashMap<>();
	}
	
	public void addEmployee(Employee employee) {
		this.employees.putIfAbsent(employee.getId(), employee);
	}
	
	public void addEmployees(Collection<Employee> employees) {
		for (Employee employee : employees) {
			this.employees.putIfAbsent(employee.getId(), employee);	
		}
	}
	
	public Employee findById(int id) {
		return this.employees.getOrDefault(id, null);
	}
	
	public List<Employee> getEmployees() {
		return Collections
				.unmodifiableList(
						this
							.employees.values()
							.stream()
							.collect(Collectors.toList()));
	}
}
