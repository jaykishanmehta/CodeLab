package com.code.practice.java8.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.*;

public class Manager {

	public static void main(String[] args) {

		System.out.println("============== DATA =============");
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alna = new Trader("Alna", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				//new Transaction(brian, 2011, 300),		//Copied transaction
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alna, 2012, 950));
		
		transactions.forEach(System.out::println);
		System.out.println("================Manager ==============");
		
		System.out.println("\n1. Find all transactions in the year 2011 and sort them by value (small to high).");
		
		transactions.stream()
			.filter(t -> t.getYear() == 2011)
			.sorted((t1,t2) -> t1.getValue() == t2.getValue() ? 0 : t1.getValue() < t2.getValue() ? 1 : -1)
			.forEach(System.out::println);
		
		System.out.println("\n2. What are all the unique cities where the traders work?");
		
		transactions.stream()
			.map(t -> (t.getTrader()).getCity())
			.distinct()
			.forEach(System.out::println);
		
		System.out.println("\n3. Find all traders from Cambridge and sort them by name.");
		
		transactions.stream()
			.filter(t -> (t.getTrader()).getCity().equalsIgnoreCase("Cambridge"))
			.map(t -> (t.getTrader()).getName())
			.distinct()
			.sorted()
			.forEach(System.out::println);
		
		System.out.println("\n4. Return a string of all traders� names sorted alphabetically.");
		
		System.out.println(transactions.stream()
				.map(t -> (t.getTrader()).getName())
				.distinct()
				.sorted()
				.reduce((n1,n2) -> n1+ "\n" + n2).orElse("No traders"));
		
		System.out.println("\n5. Are any traders based in Milan?");
		
		System.out.println(transactions.stream()
			.anyMatch(t -> (t.getTrader()).getCity().equalsIgnoreCase("Milan")));
		
		System.out.println("\n6. Print all transactions� values from the traders living in Cambridge.");
		
		transactions.stream()
			.filter(t -> (t.getTrader()).getCity().equalsIgnoreCase("Cambridge"))
			.map(Transaction::getValue)
			.collect(toList());
			//.forEach(System.out::println);
	
		System.out.println("\n7. What�s the highest value of all the transactions?");
		
		Optional<Integer> max = transactions.stream()
				.map(Transaction::getValue)
				.reduce(Integer::max);
		
		System.out.println(max.get());
		
		System.out.println("\n8. Find the transaction with the smallest value");
		
		Optional<Integer> smallest = transactions.stream()
				.map(Transaction::getValue)
				.reduce((a,b) -> a < b ? a : b);
		
		System.out.println(smallest.get());
		
	}

}
