package com.mk.adventofcode.y2021;

import com.mk.adventofcode.utility.FileReaderUtility;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class AdventofcodeApplicationDay2 {


	public static void main(String[] args) throws IOException {
//		List<String> lines = FileReaderUtility.getLinesFromFile(2021,2,true);
		List<String> lines = FileReaderUtility.getLinesFromFile(2021,2);
//		part1(lines);
		part2(lines);
	}

	private static void part2(List<String> lines) {
		int forward = 0;
		int depth = 0;
		int aim = 0;
		for (String line : lines) {
			String[] input = line.split(" ");
			if(input[0].equals("forward")){
				forward = forward + Integer.parseInt(input[1]);
				depth = depth+aim* Integer.parseInt(input[1]);
			}
			else if (input[0].equals("up")){
				aim = aim - Integer.parseInt(input[1]);
			}
			else if (input[0].equals("down")){
				aim = aim + Integer.parseInt(input[1]);
			}
		}
		System.out.println(forward*depth);
	}

	private static void part1(List<String> lines) {
		int forward = 0;
		int depth = 0;
		for (String line : lines) {
			String[] input = line.split(" ");
			if(input[0].equals("forward")){
				forward = forward + Integer.parseInt(input[1]);
			}
			else if (input[0].equals("up")){
				depth = depth - Integer.parseInt(input[1]);
			}
			else if (input[0].equals("down")){
				depth = depth + Integer.parseInt(input[1]);
			}
		}
		System.out.println(forward*depth);
	}

}
