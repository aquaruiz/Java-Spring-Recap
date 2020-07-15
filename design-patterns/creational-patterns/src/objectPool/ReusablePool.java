package objectPool;

import java.util.ArrayList;
import java.util.List;

public class ReusablePool {
	private List<Reusable> availableReusables;
	private List<Reusable> lockedReusables;
	private static ReusablePool instance;

	private ReusablePool(int size) {
		this.populateReusables(size);
	}

	private void populateReusables(int size) {
		availableReusables = new ArrayList<>(size);
		lockedReusables = new ArrayList<>();
		
		for(int i = 0; i < size; i++) {
			availableReusables.add(new Reusable());
		}		
	}

	public static synchronized ReusablePool getInstance(){
		if (instance == null) {
			instance = new ReusablePool(2);
		}
		
		return instance; 
	}

	public Reusable acquireReusable() throws NoAvailableIntstanceException{
		if (availableReusables.size() > 0){
			Reusable reusable = availableReusables.get(availableReusables.size()-1);
			availableReusables.remove(reusable);
			lockedReusables.add(reusable);
			return reusable;			
		} else {
			throw new NoAvailableIntstanceException();
		}
	}

	public void releaseReusable(Reusable reusable) {
		if (lockedReusables.contains(reusable)) {
			availableReusables.add(reusable);
			lockedReusables.remove(reusable);
		}
	}
}
