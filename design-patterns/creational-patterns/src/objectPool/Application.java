package objectPool;

public class Application {
	public static void main(String[] args) {
		ReusablePool pool = ReusablePool.getInstance();
		Reusable reusable1;
		Reusable reusable2;
		Reusable reusable3;
		
		try {
			reusable1 = pool.acquireReusable();
			reusable2 = pool.acquireReusable();
//			pool.releaseReusable(reusable2);

			reusable3 = pool.acquireReusable();
		} catch (NoAvailableIntstanceException e) {
			e.printStackTrace();
		}
	}
}
