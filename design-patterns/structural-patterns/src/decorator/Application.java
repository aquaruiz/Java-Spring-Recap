package decorator;

public class Application {

  public static void main( String[] args ) {
	  Sandwich mySandwich = new VegetarianSandwich();
	  Sandwich mySandwichWithSauce = new SauceSandwich(mySandwich);
	  Sandwich mySandwichWithDoubleSauce = new SauceSandwich(new SauceSandwich(mySandwich));

	  int totalPrice = mySandwichWithSauce.getPrice();
	  String doubleIngredients = mySandwichWithDoubleSauce.getIngredients();
  
  }	  
}
