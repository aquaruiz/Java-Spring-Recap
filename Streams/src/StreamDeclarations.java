import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class StreamDeclarations {
	public static void main(String[] args) {
		Employee[] arrayOfEmps = {
		    new Employee(1, "Jeff Bezos", 100000.0), 
		    new Employee(2, "Bill Gates", 200000.0), 
		    new Employee(3, "Mark Zuckerberg", 300000.0)
		};

		Stream<Employee> arrayStream = Stream.of(arrayOfEmps);
		Stream<Employee> listStream = Arrays.asList(arrayOfEmps).stream();
		
		// using streamBuilder
		Builder<Employee> streamBuilder = Stream.builder();
		streamBuilder.accept(new Employee(1, "Jeff Bezos", 100000.0));
		streamBuilder.accept(new Employee(2, "Bill Gates", 200000.0));
		streamBuilder.accept(new Employee(3, "Mark Zuckerberg", 300000.0));
		
		Stream<Employee> builtStream = streamBuilder.build();
		Stream.of(arrayOfEmps).forEach(e -> e.salaryIncrement(10.0));
		
		System.out.println(arrayOfEmps[0].getSalary());
		
		Integer[] empIds = { 1, 3 };
	    
		ЕmployeeRepository employeeRepository = new ЕmployeeRepository();
		employeeRepository.addEmployees(Arrays.asList(arrayOfEmps));
		 
		List<Employee> employees = Stream.of(empIds)
			 .map(employeeRepository::findById)
			 .collect(Collectors.toList());
		
		employees.stream().map(Employee::getId).forEach(System.out::println);
		
		Integer[] empIds2 = { 1, 3, 5 };

		employees = Stream.of(empIds2)
		      .map(employeeRepository::findById)
		      .filter(e -> e != null)
		      .filter(e -> e.getSalary() > 200000)
		      .collect(Collectors.toList());
		 
		employees.stream().map(Employee::getId).forEach(System.out::println);

	    System.out.println(
	    		 Stream.of(empIds)
		    	      .map(employeeRepository::findById)
		    	      .filter(e -> e != null)
		    	      .filter(e -> e.getSalary() > 100000)
		    	      .findFirst()
		    	      .orElse(null)
	    		);
	    
	    Employee[] employeesArray = employeeRepository
							    		.getEmployees()
							    		.stream()
							    		.toArray(Employee[]::new);
	    
	    List<List<String>> namesNested = Arrays.asList( 
	    	      Arrays.asList("Jeff", "Bezos"), 
	    	      Arrays.asList("Bill", "Gates"), 
	    	      Arrays.asList("Mark", "Zuckerberg"));

	    List<String> namesFlatStream = namesNested.stream()
		      .flatMap(Collection::stream)
		      .collect(Collectors.toList());
	    
	    System.out.println(String.join(", ", namesFlatStream));
	}
}
