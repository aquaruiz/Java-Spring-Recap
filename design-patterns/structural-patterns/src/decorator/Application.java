package decorator;

public class Application {

  public static void main( String[] args ) {
	  Sandwich mySandwich = new VegetarianSandwich();
	  SauceSandwich mySandwichWithSauce = new SauceSandwich(mySandwich, Sauce.KETCHUP);
	  
	  SauceSandwich mySandwichWithDoubleSauce = new SauceSandwich(
			  new SauceSandwich(new SauceSandwich(mySandwich, Sauce.KETCHUP), Sauce.MUSTARD), Sauce.MUSTARD);
	  
	  int totalPrice = mySandwichWithSauce.getPrice();
	  
	  String doubleIngredients = mySandwichWithDoubleSauce.getIngredients();
	  System.out.println(doubleIngredients);
  }	  
}
