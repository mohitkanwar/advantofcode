package com.mk.adventofcode.y2020;

import com.mk.adventofcode.utility.FileReaderUtility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdventofcodeApplicationDay11 {
	private static List<List<Character>> twoDFile;
	private static final char FLOOR = '.';
	private static final char EMPTY = 'L';
	private static final char OCCUPIED = '#';
	public static void main(String[] ar) throws IOException {
		twoDFile = FileReaderUtility.getFileAs2DArray(2020,11, false);
		//part1(twoDFile);
		part2(twoDFile);

	}

	private static void part2(List<List<Character>> twoDFile) {

//printSeatingArrangement(twoDFile);
		List<List<Character>> input = twoDFile;
		List<List<Character>> result = playGame(input);
		int i = 0;
		int count = 0;
		while(!isEqual(input,result)){
			input = result;
			result = playGamePart2(result);
			System.out.println("Not Equal" + (++i));
		}
		printSeatingArrangement(result);
		for (int y = 0; y < result.size(); y++) {
			for (int x = 0; x < result.get(y).size(); x++) {
				if(isSeatOccupied(x,y,result)) {
					count++;
				}
			}
		}
		System.out.println(count);


	}

	private static void part1(List<List<Character>> twoDFile) {
		//printSeatingArrangement(twoDFile);
		List<List<Character>> input = twoDFile;
		List<List<Character>> result = playGame(input);
		int i = 0;
		int count = 0;
		while(!isEqual(input,result)){
			input = result;
			result = playGame(result);
			System.out.println("Not Equal" + (++i));
		}
		printSeatingArrangement(result);
		for (int y = 0; y < result.size(); y++) {
			for (int x = 0; x < result.get(y).size(); x++) {
				if(isSeatOccupied(x,y,result)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static List<List<Character>> playGame(List<List<Character>> twoDFile) {
		List<List<Character>> copiedFile = getACopy(twoDFile);

		for (int y = 0; y < twoDFile.size(); y++) {
			for (int x = 0; x < twoDFile.get(y).size(); x++) {
				int neighbours = getFilledNeighbourSeats(x, y, twoDFile);
				if(neighbours==0 && isSeatEmpty(x, y, twoDFile)){
					copiedFile.get(y).set(x,OCCUPIED);
				}
				if(neighbours>=4 && isSeatOccupied(x,y, twoDFile)){
					copiedFile.get(y).set(x,EMPTY);
				}
			}
		}
		return copiedFile;
	}

	private static List<List<Character>> playGamePart2(List<List<Character>> twoDFile) {
		List<List<Character>> copiedFile = getACopy(twoDFile);

		for (int y = 0; y < twoDFile.size(); y++) {
			for (int x = 0; x < twoDFile.get(y).size(); x++) {
				int neighbours = getFilledNeighbourSeatsPart2(x, y, twoDFile);
				if(neighbours==0 && isSeatEmpty(x, y, twoDFile)){
					copiedFile.get(y).set(x,OCCUPIED);
				}
				if(neighbours>=5 && isSeatOccupied(x,y, twoDFile)){
					copiedFile.get(y).set(x,EMPTY);
				}
			}
		}
		return copiedFile;
	}

	private static boolean isEqual(List<List<Character>> one,List<List<Character>> two) {
		boolean isEqual = true;

		if(one==null&&two==null){
			return true;
		}
		if(one == null || two == null){
			return false;
		}
		if(one.size()!=two.size()){
			return false;
		}
		for (int y = 0; y < one.size(); y++) {
			for (int x = 0; x < one.get(y).size(); x++) {
				if(one.get(y).get(x)!=two.get(y).get(x)){
					return false;
				}
			}
		}
		return isEqual;
	}


	private static List<List<Character>> getACopy(List<List<Character>> twoDFile) {
		List<List<Character>> copy = new ArrayList<>();
		twoDFile.forEach(line ->{
			List<Character> copiedChars = new ArrayList<>();
			line.forEach(character -> {
				copiedChars.add(character);
			});
			copy.add(copiedChars);
		});
		return copy;
	}

	private static int getFilledNeighbourSeats(int x, int y, List<List<Character>> twoDFile){
		int neighbours = 0;
		if(isSeatOccupied((x-1), (y-1), twoDFile)){
			neighbours++;
		}
		if(isSeatOccupied((x), (y-1), twoDFile)){
			neighbours++;
		}
		if(isSeatOccupied((x+1), (y-1), twoDFile)){
			neighbours++;
		}
		if(isSeatOccupied((x-1), (y), twoDFile)){
			neighbours++;
		}
		if(isSeatOccupied((x+1), (y), twoDFile)){
			neighbours++;
		}
		if(isSeatOccupied((x-1), (y+1), twoDFile)){
			neighbours++;
		}
		if(isSeatOccupied((x), (y+1), twoDFile)){
			neighbours++;
		}
		if(isSeatOccupied((x+1), (y+1), twoDFile)){
			neighbours++;
		}
		return neighbours;
	}

	private static int getFilledNeighbourSeatsPart2(int x, int y, List<List<Character>> twoDFile){
		int neighbours = 0;
		int i = 1;
		while (isFloor(x-i,y-i,twoDFile)){
			i++;
		}
		if(isSeatOccupied((x-i), (y-i), twoDFile)){
			neighbours++;
		}

		i = 1;
		while (isFloor(x,y-i,twoDFile)){
			i++;
		}
		if(isSeatOccupied((x), (y-i), twoDFile)){
			neighbours++;
		}

		i = 1;
		while (isFloor(x+i,y-i,twoDFile)){
			i++;
		}
		if(isSeatOccupied((x+i), (y-i), twoDFile)){
			neighbours++;
		}

		i = 1;
		while (isFloor(x+i,y,twoDFile)){
			i++;
		}
		if(isSeatOccupied((x+i), (y), twoDFile)){
			neighbours++;
		}
		i = 1;
		while (isFloor(x-i,y,twoDFile)){
			i++;
		}
		if(isSeatOccupied((x-i), (y), twoDFile)){
			neighbours++;
		}
		i = 1;
		while (isFloor(x-i,y+i,twoDFile)){
			i++;
		}
		if(isSeatOccupied((x-i), (y+i), twoDFile)){
			neighbours++;
		}
		i = 1;
		while (isFloor(x,y+i,twoDFile)){
			i++;
		}
		if(isSeatOccupied((x), (y+i), twoDFile)){
			neighbours++;
		}
		i = 1;
		while (isFloor(x+i,y+i,twoDFile)){
			i++;
		}
		if(isSeatOccupied((x+i), (y+i), twoDFile)){
			neighbours++;
		}

		return neighbours;
	}

	private static boolean isSeatOccupied(int x, int y, List<List<Character>> twoDFile){
		if((y<0)||(y>=twoDFile.size())){
			return false;
		}
		if((x<0)||(x>=twoDFile.get(y).size())){
			return false;
		}
		return twoDFile.get(y).get(x) == OCCUPIED;
	}

	private static boolean isSeatEmpty(int x, int y, List<List<Character>> twoDFile){
		if((y<0)||(y>=twoDFile.size())){
			return false;
		}
		if((x<0)||(x>=twoDFile.get(y).size())){
			return false;
		}
		return twoDFile.get(y).get(x) == EMPTY;
	}

	private static boolean isFloor(int x, int y, List<List<Character>> twoDFile){
		if((y<0)||(y>=twoDFile.size())){
			return false;
		}
		if((x<0)||(x>=twoDFile.get(y).size())){
			return false;
		}
		return twoDFile.get(y).get(x) == FLOOR;
	}

	private static void printSeatingArrangement(List<List<Character>> twoDFile) {
		for (int y = 0; y < twoDFile.size(); y++) {
			for (int x = 0; x < twoDFile.get(y).size(); x++) {
				print(x,y, twoDFile);

			}
			System.out.println();
		}
	}

	private static void print(int x, int y, List<List<Character>> twoDFile){
		System.out.print(twoDFile.get(y).get(x));

	}
}