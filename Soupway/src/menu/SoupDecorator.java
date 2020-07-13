package menu;

import java.util.ArrayList;
import java.util.List;

public abstract class SoupDecorator implements Soupable {
	protected Soupable soup;
	protected List<String> ingredients; 
	
	public SoupDecorator(Soupable soup) {
		super();
		this.soup = soup;
		this.ingredients = new ArrayList<>();
	}
	
	@Override
	public String getIngredients() {
		return String.join(", ", this.ingredients);
	}
	
	public abstract double getPrice();
	
	public void addMore(String ingredient) {
		this.ingredients.add(ingredient);
	}
}
