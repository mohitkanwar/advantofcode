package com.mk.adventofcode.y2022;

import com.mk.adventofcode.utility.FileReaderUtility;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class Dec2 {

	private static final int YEAR = 2022;
	private static final int DAY = 2;

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


	}

	private static void part1(List<String> lines) {

	}


}
