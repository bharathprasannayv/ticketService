package com.bharath.codechallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BharathCodeChallenge {

	/*
	 * Person is a class with 4 sttributes namely Age , Location , Gender and Salary
	 * 
	 * Create Persons data which is sufficient to address the following requirements
	 * 
	 * 1. Average Sum of the Salaries of the perosns who match following crieterion
	 * 
	 * - Age > 25 - Gender is Female - Location Hyderabad - Salary > 25000
	 * 
	 * 2. Seggregate the Persons based on locations
	 * 
	 * HYD - 4 CHENNAI - 2 Bangalore - 1
	 * 
	 * Use : Java 8 features only like streams , method refrence , optionlas ,
	 * predicate supier consumer
	 * 
	 */

	public static void main(String[] args) {
		Person p1 = new Person(52, "Hyderabad", "Male", 20000);
		Person p2 = new Person(34, "Chennai", "Female", 30000);
		Person p3 = new Person(23, "Hyderabad", "Female", 34000);
		Person p4 = new Person(45, "Benguluru", "Male", 20000);
		Person p5 = new Person(33, "Hyderabad", "Male", 20000);

		Person p7 = new Person(41, "Chennai", "Female", 25000);
		Person p8 = new Person(23, "Hyderabad", "Female", 34000);

		Person p10 = new Person(43, "Hyderabad", "Male", 20000);

		Person p6 = new Person(33, "Hyderabad", "Female", 44000);
		Person p9 = new Person(45, "Hyderabad", "Female", 50000);

		List<Person> persons = new ArrayList<>();

		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		persons.add(p5);
		persons.add(p6);
		persons.add(p7);
		persons.add(p8);
		persons.add(p9);
		persons.add(p10);

		List<Person> matched = persons.stream().filter(p -> p.getAge() > 25)
				.filter(p -> p.getGender().equalsIgnoreCase("Female"))
				.filter(p -> p.getLocation().equalsIgnoreCase("Hyderabad")).filter(p -> p.getSalary() > 25000)
				.collect(Collectors.toList());

		matched.stream().mapToLong(p -> p.getSalary()).average()
				.ifPresent(avg -> System.out.println("Average sum is" + avg));

		Map<String, List<Person>> mapData = persons.stream().collect(Collectors.groupingBy(Person::getLocation));
		mapData.forEach((String s,List<Person> p)->System.out.println(s+"-"+p.size()));
	}

}
