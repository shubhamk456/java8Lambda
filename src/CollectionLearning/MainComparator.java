package CollectionLearning;

import java.util.function.Function;

public class MainComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Comparator<Person> cmp = (p1, p2) -> p1.getAge() - p2.getAge();
		Comparator<Person> cmpName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
		Comparator<Person> cmpLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());

		Function<Person, Comparable> f1 = p -> p.getAge();
		Function<Person, String> f2 = p -> p.getLastName();
		Function<Person, String> f3 = p -> p.getFirstName();

		Comparator<Person> cmpPerson = Comparator.comparing(f1);
		Comparator<Person> cmpPerson1 = Comparator.comparing(p1 -> p1.getAge());
		Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
		Comparator<Person> cmpPersonLastName = Comparator.comparing(Person::getLastName);

		Comparator<Person> cmpChaining = cmpPersonAge.thenComparing(cmpPersonLastName);
		Comparator<Person> cmpChaining1 = Comparator.comparing(Person::getAge)
				 .thenComparing(Person::getLastName);
		
		Comparator<Person> cmpChaining2 = Comparator.comparing(Person::getAge)
				 .thenComparing(Person::getLastName).thenComparing(Person::getLastName);
				 

	}

}
