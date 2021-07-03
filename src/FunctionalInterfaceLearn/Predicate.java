package FunctionalInterfaceLearn;


// a lambda expression is an instance of a functional interface
// a functional interface is an interface with only one method
public interface Predicate<T> {
	
	boolean test(T t);

}
