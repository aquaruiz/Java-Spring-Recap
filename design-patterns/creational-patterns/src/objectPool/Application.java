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
			reusable3 = pool.acquireReusable();
		} catch (NotFreeInstanceException e) {
			e.printStackTrace();
		}
	}
}
