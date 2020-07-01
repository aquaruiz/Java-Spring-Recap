package exam3.problem03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teacher {
	private String firstName;
	private String lastName;
	private List<Group> groups;
	
	public Teacher(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.groups = new ArrayList<>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Group> getGroups() {
		return Collections.unmodifiableList(this.groups);
	}

	public void addGroup(Group group) {
		this.groups.add(group);
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(String.format("%s %s", firstName, lastName))
			.append(System.lineSeparator())
			.append("Teaches in groups: ")
			.append(System.lineSeparator());
		if (this.groups.size() == 0) {
			stringBuilder.append("\tNo groups yet.")
				.append(System.lineSeparator());
		} else {
			for (Group group : groups) {
				stringBuilder.append("\t" + group.toString())
					.append(System.lineSeparator());
			}
		}
		
		return stringBuilder.toString();
	}
}
