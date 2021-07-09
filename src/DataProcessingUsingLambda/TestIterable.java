package DataProcessingUsingLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import CollectionLearning.Person;
import FunctionalInterfaceLearn.Predicate;

public class TestIterable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// On Iterable		
//	boolean  forEach(Consumer<? super E> consumer);	

// On Collection
//boolean removeIf(Predicate<? super E> filter);\

		List<Person> people = new ArrayList<>();
		people.forEach(System.out::println);

		people.removeIf(person -> person.getAge() < 20);

		List<String> list = new ArrayList<>(Arrays.asList("10", "is", "a", "good", "person"));
		list.forEach(System.out::println);

		// On List
//		boolean replaceAll(UnaryOperator<? super E> operator);

//		boolean sort(Comparator<? super E> comparator);

//		list.replaceAll(name -> name.toUpperCase());
		list.replaceAll(String::toUpperCase);
		list.forEach(System.out::println);

		people.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge));

		// MAP

		// on map
//		void forEach(BiConsumer<? super K, ? super V> consuemr);

		Map<City, List<Person>> map = new HashMap<>();

		map.forEach((city, person) -> System.out.println(city + ":" + list.size() + "people"));

		// on Map
//		V compute(K key,Bifunction<? super K,? super V,? extends V> remapping);
		// useful to build map of map

		Map<String, Map<String, Person>> map1 = new HashMap<>();
		Person john = null;
		// key, newValue
		map1.computeIfAbsent(
				"One",
				key -> new HashMap<String, Person>()
				).put("two", john);
		
		// on Map
		
//		V merge(
//				K key,V newValue,
//				BiFunction<? super V,? super V,? extends V> remapping);
		
		
Map<City,List<Person>> map2 = new HashMap<>();
Map<City,List<Person>> map3=new HashMap<>();
map3.forEach(
		(key,value)->
		map2.merge(key, value, 
				(existingPeople,newPeople)->{
					existingPeople.addAll(newPeople);
					return existingPeople;
				}
				
				)
		
		);
	
	}

}
