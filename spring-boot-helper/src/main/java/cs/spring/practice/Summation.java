package cs.spring.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Summation {
	
	public static void main(String[] args) {
		int sum = IntStream.range(1, 201).sum();
		System.out.println(sum);
		
		List<List<String>> lListOfLists = new ArrayList<>();
		String[] lStrArray = {"A", "B", "C"};
		List<String> lListA = Arrays.asList(lStrArray);
		
		String[] lStrArray2 = {"D", "E", "F"};
		List<String> lListB = Arrays.asList(lStrArray2);

		lListOfLists.add(lListA);
		lListOfLists.add(lListB);
		
		List<String> lList = 
				lListOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(lList.toString());
	}

}
