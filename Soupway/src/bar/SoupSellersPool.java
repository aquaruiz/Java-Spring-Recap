package bar;

import java.util.ArrayDeque;
import java.util.Queue;

import constants.Names;
import exceptions.NoFreeSoupSellersException;

public class SoupSellersPool {
	private Queue<SoupSeller> freeSoupSellers;
	private Queue<SoupSeller> busySoupSellers;
	private static SoupSellersPool instance;

	private SoupSellersPool(int size) {
		this.hireSoupSellers(size);
	}

	private void hireSoupSellers(int size) {
		freeSoupSellers = new ArrayDeque<>(size);
		busySoupSellers = new ArrayDeque<>();

		for (int i = 0; i < size; i++) {
			freeSoupSellers.offer(new SoupSeller(Names.names.get(i)));
		}
	}

	public static synchronized SoupSellersPool getInstance() {
		if (instance == null) {
			instance = new SoupSellersPool(2);
		}

		return instance;
	}

	public SoupSeller getFirstFreeSoupSeller() throws NoFreeSoupSellersException {
		if (!freeSoupSellers.isEmpty()) {
			SoupSeller soupSeller = freeSoupSellers.poll();
			busySoupSellers.add(soupSeller);
			
			return soupSeller;
		} else {
			throw new NoFreeSoupSellersException("No free soupsellers at this moment. Please wait");
		}
	}

	public void releaseSoupSeller(SoupSeller soupSeller) {
		if (busySoupSellers.contains(soupSeller)) {
			freeSoupSellers.offer(soupSeller);
			busySoupSellers.poll();
		}
	}
}
