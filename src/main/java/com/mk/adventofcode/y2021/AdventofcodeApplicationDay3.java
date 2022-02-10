package com.mk.adventofcode.y2021;

import com.mk.adventofcode.utility.FileReaderUtility;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class AdventofcodeApplicationDay3 {


	public static void main(String[] args) throws IOException {
		List<String> lines = FileReaderUtility.getLinesFromFile(2021,3,true);
//		List<String> lines = FileReaderUtility.getLinesFromFile(2021,3);
		part1(lines);
		part2(lines);
	}

	private static void part2(List<String> lines) {
		int lifeSupportRate,oxygenRate = 0,Co2Rate = 0;
		Set<String> selectedNumbers = new HashSet<>();
		selectedNumbers.addAll(lines);

		int size = lines.get(0).length();

		while (selectedNumbers.size()>1){
			for(int i = 0; i< size; i++) {
				selectedNumbers = calculateOxygen(i,size, selectedNumbers);
				if(selectedNumbers.size() == 1){
					break;
				}
			}
		}
		Integer.parseInt(selectedNumbers.stream().findFirst().get(),2);

		lifeSupportRate = oxygenRate * Co2Rate;
		System.out.println(oxygenRate);
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

		int gamma = Integer.parseInt(String.valueOf(gammaRate), 2);
		int eps = Integer.parseInt(String.valueOf(epsilonRate), 2);
		System.out.println(eps*gamma);
	}

}
