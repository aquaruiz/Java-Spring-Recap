package bar;

import java.util.ArrayDeque;
import java.util.Queue;

import constants.Names;

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
			freeSoupSellers.offer(new SoupSeller(Names.getNextName()));
		}
	}

	public static synchronized SoupSellersPool getInstance() {
		if (instance == null) {
			instance = new SoupSellersPool(2);
		}

		return instance;
	}

	public SoupSeller getFirstFreeSoupSeller() {
		if (freeSoupSellers.isEmpty()) {
			// it could throws an exception but better to offer more members
			hireSoupSellers(5);
		}

		SoupSeller soupSeller = freeSoupSellers.poll();
		busySoupSellers.add(soupSeller);

		return soupSeller;
	}
}
