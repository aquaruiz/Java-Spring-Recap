package singleton;

public class Application {
	public static void main(String[] args) {
		BankSingleton firstBankSingleton = BankSingleton.getInstance();
		BankSingleton secondBankSingleton = BankSingleton.getInstance();
		
		System.out.println(firstBankSingleton == secondBankSingleton);
	}
	
}
