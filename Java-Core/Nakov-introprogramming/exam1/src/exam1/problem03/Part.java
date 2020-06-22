package exam1.problem03;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Part {
	private String code;
	private String name;
	private Category category;
	private double buyPrice;
	private double sellPrice;
	private Set<Car> suitableCars;
	private Manufacturer manufacturer;
	
	public Part(String code, String name, Category category, double buyPrice, double sellPrice,
			Manufacturer manufacturer) {
		this.code = code;
		this.name = name;
		this.category = category;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.manufacturer = manufacturer;
		
		this.suitableCars = new HashSet<>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Set<Car> getSuitableCars() {
		return Collections.unmodifiableSet(this.suitableCars);
	}

	public void addSuitableCar(Car suitableCar) {
		this.suitableCars.add(suitableCar);
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Override
	public String toString() {
		String result = String.format("-->%s (%s) - category %s,\nmanufactured by %s\nbuy: %.2f$, sell: %.2f$\ncan be used in:", 
				this.name, this.code, this.category, this.manufacturer.toString(), this.buyPrice, this.sellPrice);
		
		for (Car car : suitableCars) {
			result += "\n	" + car.toString();
		}
		return result;
	}
}
