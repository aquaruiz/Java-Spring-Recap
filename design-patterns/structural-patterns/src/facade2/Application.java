package facade2;

public class Application {

	public static void main(String[] args) {
		TeapotFacade facade = new Teapot();
		facade.serveTee();
	}
}
