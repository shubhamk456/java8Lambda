package CollectionLearning;

import java.util.function.Function;

public interface Comparator<T> {

	public int compare(T t1, T t2);

//	public static Comparator<Person> comparing(Function<Person, Integer> f1) {
//		// TODO Auto-generated method stub
//		return (p1,p2) ->f1.apply(p1)-f1.apply(p2);
//	}

//	public static Comparator<Person> comparing(Function<Person, String> f1) {
//		// TODO Auto-generated method stub
//		return (p1,p2) ->f1.apply(p1).compareTo(f1.apply(p2));
//	}
//	

//	public static Comparator<Person> comparing(Function<Person, Comparable> f1) {
//		// TODO Auto-generated method stub
//		return (p1,p2) ->f1.apply(p1).compareTo(f1.apply(p2));
//	}

	public static <U> Comparator<U> comparing(Function<U, Comparable> f1) {
		// TODO Auto-generated method stub
		return (p1, p2) -> f1.apply(p1).compareTo(f1.apply(p2));
	}

	public default Comparator<T> thenComparing(Comparator<T> cmp) {

		return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
	}

	public default Comparator<T> thenComparing(Function<T, Comparable> f1) {
		Comparator<T> cmp = comparing(f1);

		return thenComparing(cmp);
	}

}
