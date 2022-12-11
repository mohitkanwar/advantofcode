package com.mk.adventofcode.y2022;

import com.mk.adventofcode.utility.FileReaderUtility;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class Dec4 {

	private static final int YEAR = 2022;
	private static final int DAY = 4;

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
		int counter = 0;
		for(String line: lines) {
			String[] parts = line.split(",");
			int startPartOne = Integer.parseInt(parts[0].split("-")[0]);
			int endPartOne = Integer.parseInt(parts[0].split("-")[1]);
			int startPartTwo = Integer.parseInt(parts[1].split("-")[0]);
			int endPartTwo = Integer.parseInt(parts[1].split("-")[1]);

			if(!((startPartTwo > endPartOne)
					|| startPartOne > endPartTwo)){
				counter++;
			}

		}
		System.out.println(counter);

	}

	private static void part1(List<String> lines) {
		int counter = 0;
		for(String line: lines) {
			String[] parts = line.split(",");
			int startPartOne = Integer.parseInt(parts[0].split("-")[0]);
			int endPartOne = Integer.parseInt(parts[0].split("-")[1]);
			int startPartTwo = Integer.parseInt(parts[1].split("-")[0]);
			int endPartTwo = Integer.parseInt(parts[1].split("-")[1]);

			if((startPartOne<=startPartTwo && endPartOne>= endPartTwo)
					|| (startPartTwo<=startPartOne && endPartTwo>= endPartOne)){
				counter++;
			}

		}
		System.out.println(counter);
	}

}
