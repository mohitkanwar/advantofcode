package com.mk.adventofcode.y2021;

import com.mk.adventofcode.utility.FileReaderUtility;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class AdventofcodeApplicationDay1 {


	public static void main(String[] args) throws IOException {
//		List<String> lines = FileReaderUtility.getLinesFromFile(2021,1,true);
		List<String> lines = FileReaderUtility.getLinesFromFile(2021,1);
		part1(lines);
		part2(lines);
	}

	private static void part2(List<String> lines) {

		int count = 0;

		int A = Integer.parseInt(lines.get(0));
		int B = Integer.parseInt(lines.get(1));
		int C = Integer.parseInt(lines.get(2));
		int previousSum = A+B+C;
		for (int i = 3, linesSize = lines.size(); i < linesSize; i++) {
			int value = previousSum +Integer.parseInt(lines.get(i)) - Integer.parseInt(lines.get(i-3));
			if (previousSum < value) {
				count++;
			}
			previousSum = value;
		}
		System.out.println(count);
	}

	private static void part1(List<String> lines) {
		int previous = 0;
		boolean start = true;
		int count = 0;
		for (String line : lines) {
			if(start){
				start = false;
				continue;
			}
			int value = Integer.parseInt(line);
			if(previous<value){
				count++;
			}
			previous = value;
		}
		System.out.println(count);
	}

}
