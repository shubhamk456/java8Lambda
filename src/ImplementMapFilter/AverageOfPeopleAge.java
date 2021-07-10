package ImplementMapFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

import CollectionLearning.Person;

public class AverageOfPeopleAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> people = new ArrayList<>();

		int sum = 0;
		int count = 0;
		for (Person p : people) {
			if (p.getAge() > 20) {
				sum += p.getAge();
				count++;
			}
		}
		int average = 0;
		if (count > 0)
			average = sum / count;

		// people[map]age[filter]age>20[Reduce]avg

		// map List<Person> -> List<Integer>
		// filter List<Integer> -> List<Integer>
		// reduce List<Integer> -> Integer

//	if we want to make these in java 7 then we need to add these function

//	List<Person> peoples =new ArrayList<>();
//	List<Integer> ages = Lists.map(peoples,person->person.getAge());
//	List<Integer> agesGT20 =Lists.filter(ages,age->age>20);
//	int sum = Lists.reduce(agesGT20,(a1,a2)->a1+a2);

		// ************************************************************
//	Parallelization

//	This algo is easily computed in parallel
//	But there is a condition
//	Red(a,Red(b,c)) = Red(Red(a,b),c)
//	ie associative

//********************************************************************

		// Associative?Not associative

		BinaryOperator<Integer> op1 = (i1, i2) -> i1 + i2;
		// Associative

		BinaryOperator<Integer> op2 = (i1, i2) -> Math.max(i1, i2);
		// Associative

		BinaryOperator<Integer> op3 = (i1, i2) -> i1 * i1 + i2 * i2;
		// not associative

		BinaryOperator<Integer> op4 = (i1, i2) -> i1;
		// associative

		BinaryOperator<Integer> op5 = (i1, i2) -> (i1 + i2) / 2;
		// not associative

//	If lambda is passed as a parameter is not associative , what is going to happen?

//	* In fact :nothing!
//	* The code will compile properly
//	* It will execute properly
//	* A result will be returned
//	* But it will be false

//******************************************************************

// Implementation of the reduction step:

		List<Integer> ints = new ArrayList<>(Arrays.asList(1));
		int sum1 = 0;
		BinaryOperator<Integer> op9 = (i1, i2) -> i1 + i2;

		for (int i : ints) {
			sum1 = op9.apply(sum, i);
		}

// another way of writing this

		int reduction = reduce(ints, sum1, op9);
		
	//********************************************************************************************
		
//		The complextiy of writing this is very bad
//	     int average1 = people
//					.map(p->p.getAge())
//					.filter(age->age<20)
//					.average();
		
			
//		That's why we use Stream operation
	}

	public static int reduce(List<Integer> values, int valueIfEmpty, BinaryOperator<Integer> reduction) {

		int result = valueIfEmpty;

		for (int value : values) {
			result = reduction.apply(result, value);
		}
		return result;

	}

}
