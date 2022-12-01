package com.mk.adventofcode.y2022;

import com.mk.adventofcode.utility.FileReaderUtility;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class Dec1 {

	private static final int YEAR = 2022;
	private static final int DAY = 1;

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
		int[] max = new int[]{0,0,0};
		int caloriesWithElf = 0;

		for (String line: lines) {
			if(line.trim().length()==0) {
				for (int i = 0; i < max.length; i++) {

					int indexOfSmallestCalory = indexOfSmallest(max);
					if (caloriesWithElf > max[indexOfSmallestCalory]) {
						max[indexOfSmallestCalory] = caloriesWithElf;
						break;
					}

				}

				caloriesWithElf = 0;
			} else {
				int calory = Integer.parseInt(line);
				caloriesWithElf = caloriesWithElf + calory;
			}

		}
		int output = 0;
		for (int i = 0; i < max.length; i++) {
			output = output+ max[i];
		}
		System.out.println(output);

	}

	private static void part1(List<String> lines) {
		int max = 0;
		int caloriesWithElf = 0;
		for (String line: lines) {
			if(line.trim().length()==0) {
				max = Math.max(max, caloriesWithElf);
				caloriesWithElf = 0;
			} else {
				int calory = Integer.parseInt(line);
				caloriesWithElf = caloriesWithElf + calory;
			}

		}
		System.out.println(max);
	}
	public static int indexOfSmallest(int[] array){

		// add this
		if (array.length == 0)
			return -1;

		int index = 0;
		int min = array[index];

		for (int i = 1; i < array.length; i++){
			if (array[i] <= min){
				min = array[i];
				index = i;
			}
		}
		return index;
	}

}
