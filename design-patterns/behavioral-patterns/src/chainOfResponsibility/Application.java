package chainOfResponsibility;

public class Application {
	public static void main(String[] args) {
		Director bryan = new Director();
		VP crystal = new VP();
		CEO jeff = new CEO();
		
		bryan.setSuccessor(crystal);
		crystal.setSuccessor(jeff);
		
		Request request = new Request(RequestType.CONFERENCE, 536);
		bryan.handleRequest(request);
		
		request = new Request(RequestType.PURCHASE, 999);
		crystal.handleRequest(request);
		
		request = new Request(RequestType.PURCHASE, 1956);
		bryan.handleRequest(request);
	}
}
