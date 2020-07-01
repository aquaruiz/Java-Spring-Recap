package optionals;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		class User {
			String id;
			String name;
			
			public User(String id, String name) {
				this.id = id;
				this.name = name;
			}
			
			public String getName() {
				return name;
			}
			
			public String getId() {
				return id;
			}
			
			@Override
			public String toString() {
				return this.id + " | " + this.name;
			}
		}
		
		Optional<User> user1_optional = Optional.empty();
		User user2 = new User("329r4fk4j0", "John Smith");
		Optional<User> user2_optional = Optional.of(user2);
		// could throws exception if user2 is null
		
		Optional<User> user3_optional = Optional.ofNullable(user2);
		// if user2 is null returns empty optional
		
		if (user1_optional.isPresent()) {
			System.out.println(user1_optional.get());
		} else {
			System.out.println(user1_optional.isPresent());
		}
		
		user2_optional.ifPresent(System.out::println); // passing a lambda (consumer)

		System.out.println(user3_optional.orElse(new User("0000", "anon")));
		System.out.println(user1_optional.orElse(new User("0000", "anon")));
		
		//check an user field
		
		user2_optional
			.filter(user -> user.getName().equalsIgnoreCase("John Smith"))
			.ifPresent((u) -> { // takes a predicate as argument
				System.out.println("You're busted John Smith");
			});
		
		// same but with mapping first
		// if no user in optional or user with no name, 
		// then null and it does not present :)
		// if mapping func returns other optional use flatMap instead
		user2_optional
			.map(User::getName)
			.filter(name -> name.equalsIgnoreCase("John Smith"))
			.ifPresent((u) -> { // takes a predicate as argument
				System.out.println("You're busted John Smith");
			});
	}

}
