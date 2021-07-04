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

		Predicate<String> p3 = t -> t.length() > 5;
		
		Predicate<String> chaining = p2.and(p3);
		System.out.println(chaining.test("hello you"));
		
		Predicate<String> chaining1 = Predicate.isEqualTo("Yes");
		System.out.println(chaining1.test("Yes"));

	}

}
