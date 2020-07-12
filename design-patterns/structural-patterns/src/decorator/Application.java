package decorator;

public class Application {

  public static void main( String[] args ) {
	  Sandwich mySandwich = new VegetarianSandwich();
	  SauceSandwich mySandwichWithSauce = new SauceSandwich(mySandwich);
	  
	  SauceSandwich mySandwichWithDoubleSauce = new SauceSandwich(new SauceSandwich(mySandwich));
	  mySandwichWithDoubleSauce.makeWith("mustard");
	  
	  int totalPrice = mySandwichWithSauce.getPrice();
	  
	  String doubleIngredients = mySandwichWithDoubleSauce.getIngredients();
  }	  
}
