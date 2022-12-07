package com.mk.adventofcode.y2022;

import com.mk.adventofcode.utility.FileReaderUtility;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class Dec3 {

	private static final int YEAR = 2022;
	private static final int DAY = 3;

	public static void main(String[] args) throws IOException {
		List<String> exampleLines = FileReaderUtility.getLinesFromFile(YEAR, DAY, true);
		System.out.println("Example Part 1");
		System.out.println("==================");
		part1(exampleLines);
		System.out.println("Example Part 2");
		System.out.println("==================");
		part2(exampleLines);
		System.out.println("==================");
		System.out.println("==================");
		System.out.println("==================");
//		List<String> lines = FileReaderUtility.getLinesFromFile(2021,1,true);
		List<String> lines = FileReaderUtility.getLinesFromFile(YEAR, DAY);
		System.out.println("Part 1");
		System.out.println("==================");
		part1(lines);
		System.out.println("Part 2");
		System.out.println("==================");
		part2(lines);
	}

	private static void part2(List<String> lines) {
		int totalPriority = 0;
		for (int j = 0; j < lines.size(); j++) {
			String rucksack1 = lines.get(j);
			String rucksack2 = lines.get(j+1);
			String rucksack3 = lines.get(j+2);
			j = j+2;


			Set<Character> itemSet1 = rucksack1.chars().distinct().mapToObj(i->(char)i).collect(Collectors.toSet());
			Set<Character> itemSet2 = rucksack2.chars().distinct().mapToObj(i->(char)i).collect(Collectors.toSet());
			Set<Character> itemSet3 = rucksack3.chars().distinct().mapToObj(i->(char)i).collect(Collectors.toSet());


			int priority = 0;


			for (Character character : itemSet1) {
				if (itemSet2.contains(character) && itemSet3.contains(character)) {
					priority = getPriority(character);
					break;
				}
			}
			totalPriority = totalPriority + priority;
		}
		System.out.println(totalPriority);

	}

	private static void part1(List<String> lines) {
		int totalPriority = 0;
		for(String rucksack: lines){
			char[] itemArray = rucksack.toCharArray();
			Set<Character> compartment1 = new HashSet<>();
			Set<Character> compartment2 = new HashSet<>();
			int priority = 0;
			for (int i = 0; i < itemArray.length; i++) {
				if (i < itemArray.length/2) {

					compartment1.add(itemArray[i]);
				} else {
					compartment2.add(itemArray[i]);

				}
			}

			for(Character character: compartment1) {
				if(compartment2.contains(character)) {
					priority = getPriority(character);
				}
			}
			totalPriority = totalPriority + priority;
		}
		System.out.println(totalPriority);
	}

	private static int getPriority(Character character) {
		if (Character.isLowerCase(character)) {

			int numericValue = Character.getNumericValue(character);
			return numericValue-9;
		}
		int numericValue = Character.getNumericValue(character);
		return numericValue-9+26;
	}


}
