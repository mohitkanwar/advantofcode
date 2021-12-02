package com.mk.adventofcode.y2019;

import com.mk.adventofcode.utility.FileReaderUtility;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class AdventofcodeApplicationDay2 {


	public static void main(String[] args) throws IOException {
		List<String> lines = FileReaderUtility.getLinesFromFile(2019,2);
		List<Integer> code = Arrays.stream(lines.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
		//System.out.println(part1(code, 12, 2));
		part2();

	}

	private static Integer part1(List<Integer> lines, int noun, int verb) {
		int startIndex = 0;
		//System.out.println(lines);
		lines.set(1,noun);
		lines.set(2,verb);
		int function = lines.get(startIndex);
		while (function!=99){
			if(function==1){
				int num1 = lines.get(lines.get(startIndex+1));
				int num2 = lines.get(lines.get(startIndex+2));
				int pos = lines.get(lines.get(startIndex+3));
				lines.set(pos,num1+num2);
			}
			else if(function ==2){
				int num1 = lines.get(lines.get(startIndex+1));
				int num2 = lines.get(lines.get(startIndex+2));
				int pos = lines.get(lines.get(startIndex+3));
				lines.set(pos,num1*num2);

			}
			else {
				throw new RuntimeException();
			}
			startIndex = startIndex +4;
			function = lines.get(startIndex);
		}
		return lines.get(1);

	}

	private static void part2() throws IOException {


		int res = 0;
		for (int noun = 0; noun <= 99; noun++) {
			for (int verb = 0; verb <=99 ; verb++) {
				try {
					List<String> lines = FileReaderUtility.getLinesFromFile(2019,2);
					List<Integer> code = Arrays.stream(lines.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
					res = part1(code, noun, verb);
					//System.out.println("res ["+res+"] n "+noun+" v "+verb);
					if(res == 19690720) {
						System.out.println("n "+noun+" v "+verb);
						System.out.println(noun*100+verb);

					}
				}
				catch (Exception e){
					//System.out.println("e");
				}

			}
		}

	}

}
