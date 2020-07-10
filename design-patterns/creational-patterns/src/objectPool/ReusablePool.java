package objectPool;

import java.util.ArrayList;
import java.util.List;

public class ReusablePool {
	private List<Reusable> reusables;
	private static ReusablePool instance;

	private ReusablePool(int size){
		reusables = new ArrayList<Reusable>(size);
		
		for(int i=0;i<size;i++)
			reusables.add(new Reusable());
	}

	public static ReusablePool getInstance(){
		if (instance == null)
			instance = new ReusablePool(2);
		return instance; 
	}

	public Reusable acquireReusable() throws NotFreeInstanceException{
		if (reusables.size() > 0){
			Reusable r = reusables.get(reusables.size()-1);
			reusables.remove(r);
			
			return r;			
		} else {
			throw(new NotFreeInstanceException());
		}
	}

	public void releaseReusable(Reusable r) {
		reusables.add(r);
	}
}
