package exam1.problem03;

import java.util.Objects;

import sun.tools.tree.ThisExpression;

public class Car {
	private String brand;
	private String model;
	private int productionYear;
	
	public Car(String brand, String model, int productionYear) {
		this.brand = brand;
		this.model = model;
		this.productionYear = productionYear;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(this == obj) {
			return true;
		}
		
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		final Car other = (Car) obj;
		
		if (!Objects.equals(this.brand, other.brand)) {
			return false;
		} else if (!Objects.equals(this.model, other.model)) {
			return false;
		} else if(this.productionYear != other.productionYear) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 3;
		int result = 1;
		
		result = prime * result + ((this.brand == null) ? 0 : this.brand.hashCode());
		result = prime * result + ((this.model == null) ? 0 : this.model.hashCode());
		result = prime * result + this.getProductionYear();
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s, %d", this.brand, this.model, this.productionYear);
	}
	
}
