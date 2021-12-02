package com.mk.adventofcode.y2019;

import com.mk.adventofcode.utility.FileReaderUtility;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class AdventofcodeApplicationDay1 {


	public static void main(String[] args) throws IOException {
		List<Integer> lines = FileReaderUtility.getIntegersFromFile(2019,1);

		part1(lines);
		part2(lines);

	}

	private static void part1(List<Integer> lines) {
		int sum = lines.stream().mapToInt(integer -> (integer/3) -2).sum();
		System.out.println(sum);
	}

	private static void part2(List<Integer> lines) {
		int sum = lines.stream().mapToInt(integer -> {
			int fuel = (integer/3) -2;
			int total = fuel;
			while (fuel>=0){
				fuel = (fuel/3) -2;
				if(fuel>0) total = total + fuel;
			}
			return total;

		}).sum();
		System.out.println(sum);
	}

}
