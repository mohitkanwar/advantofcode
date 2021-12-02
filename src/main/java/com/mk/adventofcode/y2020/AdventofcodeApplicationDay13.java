package com.mk.adventofcode.y2020;

import com.mk.adventofcode.utility.FileReaderUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdventofcodeApplicationDay13 {


	public static void main(String[] ar) throws IOException {
		List<String> instructions = FileReaderUtility.getLinesFromFile(2020, 13, false);
		//part1(instructions);
		part2(instructions);

	}

	private static void part2(List<String> instructions) {
		BigInteger counter = new BigInteger("100000000000000");
		boolean resultFound = false;
		String busLine = instructions.get(1);
		String[] busStrings= busLine.split(",");

		while(!resultFound){
			resultFound = true;
			for (int i = 0, busStringsLength = busStrings.length; i < busStringsLength; i++) {
				String busId = busStrings[i];
				if(!busId.equals("x")){
					if(!counter.add(new BigInteger(i+"")).divideAndRemainder(new BigInteger(busId))[1].equals(BigInteger.ZERO)){
						resultFound = false;
						break;
					}
				}

			}
			if(!resultFound)
			counter = counter.add(BigInteger.ONE);
		}
		System.out.println(counter.toString());
	}


	private static void part1(List<String> instructions) {
		int arrivalTime = Integer.parseInt(instructions.get(0));
		int earliestTimeForBus = arrivalTime;
		int selectedBus = 0;
		String busLine = instructions.get(1);
		String[] busStrings= busLine.split(",");

		List<Integer> availableBuses = Arrays.stream(busStrings).map(s -> {
			try{

				return Integer.parseInt(s);
			} catch (Exception e){
				return -1;
			}
		}).filter(integer -> integer!=-1).collect(Collectors.toList());
		boolean busFound = false;
		while(!busFound){
			for (int i = 0; i < availableBuses.size(); i++) {
				int bus = availableBuses.get(i);
				if(earliestTimeForBus%bus ==0){
					busFound = true;
					selectedBus = bus;
					break;
				}
			}
			if(!busFound)
			earliestTimeForBus++;
		}
		System.out.println(" earliestTimeForBus Time :-" + earliestTimeForBus +" SelectedBus"+selectedBus);
		System.out.println("Ans ="+ (earliestTimeForBus-arrivalTime)*selectedBus);
	}



}