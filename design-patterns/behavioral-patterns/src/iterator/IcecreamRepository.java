package iterator;

import java.util.Iterator;

public class IcecreamRepository implements Iterable<String> {

	private String [] icecreams;
	private int index;
	
	public IcecreamRepository() {
		icecreams = new String[10];
		index = 0;
	}
	
	public void addIcecream(String newIcecream) {
		if(index == icecreams.length) {
			String [] moreIcecreams = new String[icecreams.length + 5];
			System.arraycopy( icecreams, 0, moreIcecreams, 0, icecreams.length );
			icecreams = moreIcecreams;
			moreIcecreams = null;
		}
		
		icecreams[index++] = newIcecream;
	}

	@Override
	public Iterator<String> iterator() {
		Iterator<String> it = new Iterator<String>() {

			private int currentIndex = 0;
			
			@Override
			public boolean hasNext() {
				return currentIndex < icecreams.length && icecreams[currentIndex] != null;
			}

			@Override
			public String next() {
				return icecreams[currentIndex++];
			}

			@Override
			public void remove() {
				// TODO
				throw new UnsupportedOperationException();
			}
			
		};
		
		return it;
	}
}
