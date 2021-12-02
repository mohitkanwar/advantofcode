package com.mk.adventofcode.y2020;

import com.mk.adventofcode.utility.FileReaderUtility;

import java.io.IOException;
import java.util.List;

public class AdventofcodeApplicationDay9 {

	public static void main(String[] ar) throws IOException {
		List<String> lines = FileReaderUtility.getLinesFromFile(2020,9);
		//System.out.println(lines);
		//System.out.println("---");
		int preambleLength = 25;
		int r= part1(lines, preambleLength);
		System.out.println(r);

		part2(lines, r);

	}

	private static void part2(List<String> lines, int requiredSum) {
		System.out.println("===Part 2=====");
		int startIndex = 0;
		int sum = getSum(lines, startIndex, requiredSum);
		while(sum == -1){
			sum = getSum(lines, ++startIndex, requiredSum);
		}
		//System.out.println(startIndex+"  "+ sum);
		List<String> sublist = lines.subList(startIndex, sum);
		sublist.sort(String::compareTo);
		int total = Integer.parseInt(sublist.get(0))+ Integer.parseInt( sublist.get(sublist.size()-1));
		System.out.println(total);


	}

	private static int getSum(List<String> lines, int startIndex, int requiredSum){
		int sum = 0;
		for (int i = startIndex; i < lines.size(); i++) {

			String line = lines.get(i);
			sum = Integer.parseInt(line) + sum;
			//System.out.println(sum);
			if(sum==requiredSum){
				return i;
			}
			if(sum>requiredSum){
				return -1;
			}


		}
		return sum;
	}
	private static int part1(List<String> lines, int preambleLength) {
		for (int i = 0, dSize = lines.size(); i < dSize; i++) {
			String line = lines.get(i);
			if(i >= preambleLength) {
				int numberToBeChecked = Integer.parseInt(line);
				List<String> subList = lines.subList(i- preambleLength,i);

				boolean filteredMatch = subList.stream().filter(x->
					 Integer.parseInt(x)<=numberToBeChecked
				).anyMatch(n->{

					for (String number : subList) {
						if (numberToBeChecked == Integer.parseInt(n) + Integer.parseInt(number)) {
							return true;
						}
					}
					return false;

				});
				if(!filteredMatch)
					return numberToBeChecked;

			}
		}
		return -1;
	}
}