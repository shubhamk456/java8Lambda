package FunctionalInterfaceLearn;

public class TestPredicate {

	public static void main(String[] args) {

		// using with anonymous class
		Predicate<String> p = new Predicate<String>() {

			@Override
			public boolean test(String t) {

				return t.length() < 20;
			}
		};

		// using with lambda expression

		Predicate<String> p1 = (String t) -> t.length() < 20;
		Predicate<String> p2 = (t) -> t.length() < 20;
		System.out.println(p2.test("hello world"));

	}

}
