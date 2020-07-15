package facade2;

public class Application {

	public static void main(String[] args) {
		TeePotFacade facade = new Teepot();
		facade.serveTee();
	}
}
