package com.mk.adventofcode.y2020;

import com.mk.adventofcode.utility.FileReaderUtility;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class AdventofcodeApplicationDay10 {
	static int[] tribonacci = {0, 1, 1, 2, 4, 7, 13};
	public static void main(String[] ar) throws IOException {
		List<Integer> joltages = FileReaderUtility.getIntegersFromFile(2020,10);
		joltages.sort(Integer::compareTo);
		part1(joltages);
		part2(joltages);
	}

	private static void part2(List<Integer> joltages) {
		Collections.sort(joltages);
		joltages.add(joltages.get(joltages.size()-1)+3);

		int prev = 0;
		long result = 1;
		int consecutiveCount = 1;

		for(int i : joltages){
			if (i == prev+1){
				consecutiveCount++;
			}
			else{
				result *= tribonacci[consecutiveCount];
				consecutiveCount = 1;
			}
			prev = i;
		}
		System.out.println(result);


	}

	private static void part1(List<Integer> joltages) {
		int currentJolt = 0;
		int joltToBeChecked = 0;
		int oneCounter = 0;
		int threeCounter = 0;
		for (int j = 0; j < joltages.size(); j++) {
			for (int i = 0; i < joltages.size(); i++) {

				joltToBeChecked = joltages.get(i);
				if(joltToBeChecked>currentJolt){
					break;
				}
			}
			System.out.println(joltToBeChecked+"   :   "+currentJolt+"  1 C ["+oneCounter+"]  3 C ["+threeCounter);
			int difference = joltToBeChecked - currentJolt;
			if(difference==1){
				oneCounter++;
			}
			if(difference==3){
				threeCounter++;
			}
			currentJolt = joltToBeChecked;
		}

		System.out.println((threeCounter+1)*oneCounter);

	}
}