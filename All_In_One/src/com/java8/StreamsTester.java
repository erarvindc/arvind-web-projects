package com.java8;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

public class StreamsTester {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<String> list = Arrays.asList( 
				"Just", "testing", "towards", "Something", "tangy" );

		Stream<String> stream = list.stream();
		
		
		
		stream
		.filter(s -> s.startsWith("t"))  // Predicament    // also 
		.filter(s -> true );  // as good as no barricade filter, so it will pass all elements.
		//.map()
		
		// NOTE - forEach implements Consumer interface.
	//	.forEach( s -> System.out.println(s) ) // Terminal Conditions  
		
 	//	.findFirst(s -> new Optional<String>  ).orElse("s");
 		
		
		
		// If not declared again, 
		//throws Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
		stream = list.stream();
		
		long count = stream
		.filter(s -> s.startsWith("t"))  // Predicament
		.count();  // Terminal Condition
		
		System.out.println(count);
		
		List<Employee> employees = Arrays.asList( 
			new Employee(1, "Andy"),
			new Employee(2, "Nick"),
			new Employee(3, "Katy"),
			new Employee(4, "Sean"),
			new Employee(5, "Neil")			
			);
		
		System.out.println("----------- Approach 1 -------------");
		employees
			.stream()
			.filter(x -> (x.getId() >= 4 || x.getName().startsWith("N")))
			.map(x -> {
					x.setName("UPDATED - " + x.getName()); 
					return x;
				})
			.forEach(System.out::println);
		
		String y = "N";
		System.out.println("----------- Approach 2 -------------");
		//List<String> newList = new ArrayList<String>();
		
		System.out.println(employees
				.stream()
				.sorted()
				.filter(x -> (x.getId() >= 4 || x.getName().startsWith("N")))
				.map(x -> {
						x.setName("UPDATED - " + x.getName()); 
						return x;
					})
				.collect(Collectors.toList()).toString()
				);
		// NOTE - The original source list does not get modified.
	}
	
}


class Employee{
	
	String name;
	int id;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	} 
	
	
}