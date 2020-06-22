package exam1.problem03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {
	private String name;
	private List<Part> parts;
	
	public Shop(String name) {
		this.name = name;
		this.parts = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Part> getParts() {
		return Collections.unmodifiableList(this.parts);
	}

	public void addPart(Part part) {
		this.parts.add(part);
	}
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Welcome to ")
			.append(this.name)
			.append(System.lineSeparator())
			.append("===========================")
			.append(System.lineSeparator());
		
		if (this.parts.size() == 0) {
			sBuilder
			.append(System.lineSeparator())
			.append("No parts in shop");
			
		} else {
			sBuilder
			.append(System.lineSeparator())
			.append("We have following on stock:-----");

			for (Part part : this.parts) {
				sBuilder
				.append(System.lineSeparator())
					.append(System.lineSeparator())
					.append(part.toString());
			}
		}
		
		return sBuilder.toString();
	}
}
