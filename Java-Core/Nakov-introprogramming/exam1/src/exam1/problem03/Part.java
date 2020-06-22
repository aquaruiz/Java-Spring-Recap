package exam1.problem03;

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
	
	
	
}
