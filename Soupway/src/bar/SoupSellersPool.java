package bar;

import java.util.ArrayList;
import java.util.List;

import constants.Names;
import exceptions.NoFreeSoupSellersException;

public class SoupSellersPool {
	private List<SoupSeller> freeSoupSellers;
	private List<SoupSeller> busySoupSellers;
	private static SoupSellersPool instance;

	private SoupSellersPool(int size) {
		this.hireSoupSellers(size);
	}

	private void hireSoupSellers(int size) {
		freeSoupSellers = new ArrayList<>(size);
		busySoupSellers = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			freeSoupSellers.add(new SoupSeller(Names.names.get(i)));
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
			SoupSeller soupSeller = freeSoupSellers.get(freeSoupSellers.size() - 1);
			freeSoupSellers.remove(soupSeller);
			busySoupSellers.add(soupSeller);
			
			return soupSeller;
		} else {
			throw new NoFreeSoupSellersException("No free soupsellers at this moment. Please wait");
		}
	}

	public void releaseSoupSeller(SoupSeller soupSeller) {
		if (busySoupSellers.contains(soupSeller)) {
			freeSoupSellers.add(soupSeller);
			busySoupSellers.remove(soupSeller);
		}
	}
}
