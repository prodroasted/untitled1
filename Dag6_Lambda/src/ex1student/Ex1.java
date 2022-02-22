package ex1student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Filter;

public class Ex1 {

	public static void main(String[] args) {
		List<Person> list = List.of(
				new Person("Bent", 25), new Person("Susan", 34),
				new Person("Mikael", 60), new Person("Klaus", 44),
				new Person("Birgitte", 17), new Person("Liselotte", 9));
		List<Person> persons = new ArrayList<Person>(list);
		System.out.println(persons);
		System.out.println();
		System.out.println(findFirst(list, person -> person.getAge() == 44));
		System.out.println();
		System.out.println(findFirst(list, person -> person.getName().startsWith("S")));
		System.out.println();
		System.out.println(findFirst(list, Ex1::multipleIs));
		System.out.println("--------------------------------------------------------------------");
		System.out.println(findAll(list, person -> person.getName().contains("i")));
		System.out.println();
		System.out.println(findAll(list, person -> person.getName().startsWith("S")));
		System.out.println();
		System.out.println(findAll(list, person -> person.getName().length() == 5));
		System.out.println();
		System.out.println(findAll(list, person -> person.getName().length() >= 6 && person.getAge() < 40));


	}

	/**
	 * Returns from the list the first person
	 * that satisfies the predicate.
	 * Returns null, if no person satisfies the predicate.
	 */
	public static Person findFirst(List<Person> list, Predicate<Person> filter) {
		for (Person p : list) {
			if (filter.test(p))
				return p;
		}
		return null;
	}

	public static boolean multipleIs (Person p){
		return p.getName().chars().filter(c ->  c == 'i').count() >= 2;
	}

	public static ArrayList<Person> findAll(List<Person> list, Predicate<Person> filter) {
		ArrayList<Person> arrList = new ArrayList<>();
		for (Person p : list) {
			if (filter.test(p)) {
				arrList.add(p);
			}
		}
		return arrList;
	}

}
