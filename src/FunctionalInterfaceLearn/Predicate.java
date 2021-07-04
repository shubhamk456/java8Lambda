package FunctionalInterfaceLearn;

// a lambda expression is an instance of a functional interface
// a functional interface is an interface with only one method
@FunctionalInterface
public interface Predicate<T> {

	boolean test(T t);

	public default Predicate<T> and(Predicate<T> p3) {

		return t -> test(t) && p3.test(t);
	}

	public static Predicate<String> isEqualTo(String string) {
		// TODO Auto-generated method stub
		return t -> t.equals(string);
	}

}
