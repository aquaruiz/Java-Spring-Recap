package menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class SoupDecorator implements Soup {
	protected Soup soup;
	protected List<String> mainIngredients; 
	protected List<String> extraIngredients; 
	
	protected SoupDecorator(Soup soup) {
		this.soup = soup;
		this.mainIngredients = new ArrayList<>(soup.getIngredients());
		
		this.extraIngredients = new ArrayList<>();
	}
	
	public String getPrintableIngredients() {
		List<String> ingredients = new ArrayList<>();
		ingredients.addAll(mainIngredients);
		ingredients.addAll(extraIngredients);
		return String.join(", ", ingredients);
	}

	@Override
	public List<String> getIngredients() {
		List<String> ingredients = new ArrayList<>();
		ingredients.addAll(mainIngredients);
		ingredients.addAll(extraIngredients);
		
		return Collections.unmodifiableList(ingredients);
	}

	public abstract double getPrice();
}
