package DataProcessingUsingLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import CollectionLearning.Person;

public class LiveExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p1 = new Person("shubham", "khandelwal", 24);
		Person p2 = new Person("santosh", "arora", 37);
		Person p3 = new Person("jai", "sethia", 26);
		List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3));

		people.removeIf(person -> person.getAge() < 30);
		people.replaceAll(
				person -> new Person(person.getFirstName().toUpperCase(), person.getLastName(), person.getAge()));

		people.sort((pt, pl) -> pt.getAge() - pl.getAge());
		people.sort(Comparator.comparing(Person::getAge).reversed());
		
		
		
	}

}
