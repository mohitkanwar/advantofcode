package com.mk.adventofcode.y2021;

import com.mk.adventofcode.utility.FileReaderUtility;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class AdventofcodeApplicationDay3 {


	public static void main(String[] args) throws IOException {
		List<String> lines = FileReaderUtility.getLinesFromFile(2021,3,true);
//		List<String> lines = FileReaderUtility.getLinesFromFile(2021,3);
		System.out.println("Part 1");
		System.out.println("------");
		part1(lines);
		System.out.println("======================================================");
		System.out.println("Part 2");
		System.out.println("------");
		part2(lines);
	}

	private static void part2(List<String> lines) {
		int oxygenGeneratorRating = 0;
		int CO2ScrubberRating = 0;

		int wordLength = lines.get(0).length();
		int[] oneCounts = new int[wordLength];
		for(int i=0; i<wordLength; i++) {
			oneCounts[i] = 0;


			for (int j = 0; j < lines.size(); j++) {
				String word = lines.get(j);
				if(word.charAt(i)=='1') {
					oneCounts[i]++;
				}
			}
		}
		int[] mostCommonBit = new int[wordLength];
		for (int i = 0; i < wordLength; i++) {
			mostCommonBit[i] = oneCounts[i] >= (lines.size()/2) ? 1 : 0;
		}
		String oxygenGenRating = getOxygenGeneratorRating(lines, mostCommonBit);

		System.out.println(oxygenGenRating);
		int lifeSupportRating = oxygenGeneratorRating * CO2ScrubberRating;


	}

	private static String getOxygenGeneratorRating(List<String> lines, int[] mostCommonBit) {
		List<String> linesCopy = List.copyOf(lines);
		for(int i=0; i<mostCommonBit.length; i++) {
			int finalI = i;
			List<String> linesCopy2 = linesCopy.stream()
					.filter(word ->{
								boolean selected = word.charAt(finalI) == mostCommonBit[finalI];
								if (selected) {
									System.out.println(word);
								} else {
									System.out.println(word.charAt(finalI));
									System.out.println(mostCommonBit[finalI]);
								}
								return selected;
							}
							)
					.collect(Collectors.toList());
			System.out.println(linesCopy2.size());
			if (linesCopy2.size() == 1) {
				return linesCopy2.get(0);
			}
		}

		return null;
	}

	private static Set<String> calculateOxygen(int i, int size, Set<String> selectedNumbers) {
		int[] rate = new int[size];
		Set<String> tempNumbers = new HashSet<>();
		tempNumbers.addAll(selectedNumbers);
		for (String line : selectedNumbers) {
			char[] input = line.toCharArray();
			for(int j=0;j<input.length;j++){
				rate[j] += input[j] -48;
			}
		}
		for(int j = 0; j< size; j++){
			rate[j] = (rate[j]>= selectedNumbers.size()/2)?1:0;
		}



			for(String line: selectedNumbers){
				if((line.charAt(i)-48)!=rate[i]){
					tempNumbers.remove(line);
				}
				if(tempNumbers.size()==1){
					break;
				}
			}

		return tempNumbers;
	}

	private static void part1(List<String> lines) {
		String gammaRate = "";
		String epsilonRate = "";
		int[] rate = new int[12];

		for (String line : lines) {
			char[] input = line.toCharArray();
			for(int i=0;i<input.length;i++){
				rate[i] += input[i] -48;
			}
		}
		for(int i = 0; i< lines.get(0).length();i++){
			rate[i] = (rate[i]>lines.size()/2)?1:0;
		}

		for(int i = 0; i<rate.length; i++){
			gammaRate += String.valueOf(rate[i]);
		}
		for(int i = 0; i<rate.length; i++){
			epsilonRate += String.valueOf(rate[i]==1?0:1);
		}

		int gamma = Integer.parseInt(gammaRate, 2);
		int eps = Integer.parseInt(epsilonRate, 2);
		System.out.println(eps*gamma);
	}

}
