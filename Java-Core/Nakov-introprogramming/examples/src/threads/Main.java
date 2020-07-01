package threads;

public class Main {

	public static class MyThread extends Thread {

		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			System.out.println("my name is " + name);
			System.out.println("Thread running");
			System.out.println("Thread stopped");
		}
	}

	public static class MyRunnable implements Runnable {

		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			System.out.println("my name is " + name);
			System.out.println("Runnable running");
			System.out.println("Runnable stopped");
		}
	}

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.run();

		Thread myRunnable = new Thread(new MyRunnable());
		myRunnable.run();

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.println("my name is " + name);
				System.out.println("Anon Runnable running");
				System.out.println("Anon Runnable stopped");
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();

		Runnable lambdaRunnable = () -> {
			String name = Thread.currentThread().getName();
			System.out.println("my name is " + name);
			System.out.println("Lambda Runnable running");
			System.out.println("Lambda Runnable stopped");
		};

		Thread threadLambda = new Thread(lambdaRunnable, "not main");
		threadLambda.start();
	}

}
