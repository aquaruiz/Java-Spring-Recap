package exam1.problem03;

public class Main {

	public static void main(String[] args) {
		Manufacturer bmw = new Manufacturer("BWM",
	            "Germany", "Bavaria", "665544", "876666");
        Manufacturer lada = new Manufacturer("Lada",
	            "Russia", "Moscow", "653443", "893321");

        Car bmw316i = new Car("BMW", "316i", 1994);
        Car ladaSamara = new Car("Lada", "Samara", 1987);
        Car mazdaMX5 = new Car("Mazda", "MX5", 1999);
        Car mercedesC500 = new Car("Mercedes", "C500", 2008);
        Car trabant = new Car("Trabant", "super", 1966);
        Car opelAstra = new Car("Opel", "Astra", 1997);

        Part cheapPart = new Part("T332", "Tires 165/50/13", Category.TIRES, 302.36,
	            345.58, lada);
        cheapPart.addSuitableCar(ladaSamara);
        cheapPart.addSuitableCar(trabant);

        Part expensivePart = new Part("Oil431", "BMW Engine Oil", Category.ENGINE,
            633.17, 670.0, bmw);

        expensivePart.addSuitableCar(bmw316i);
        expensivePart.addSuitableCar(mazdaMX5);
        expensivePart.addSuitableCar(mercedesC500);
        expensivePart.addSuitableCar(opelAstra);
	       

        Shop newShop = new Shop("A shop");
        newShop.addPart(cheapPart);
        newShop.addPart(expensivePart);

        System.out.println(newShop);
	}

}
