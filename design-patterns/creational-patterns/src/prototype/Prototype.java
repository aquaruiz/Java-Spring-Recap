package prototype;

public interface Prototype <T> {
	T shallowClone();
	T deepClone();
}
