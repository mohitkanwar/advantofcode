package com.mk.adventofcode.y2020;

import com.mk.adventofcode.utility.FileReaderUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventofcodeApplicationDay12 {

	private static int N = 0;
	private static int E = 0;
	private static char face = 'E';
	private static char[] directions = {'N','E','S','W'};
	public static void main(String[] ar) throws IOException {
		List<String> instructions = FileReaderUtility.getLinesFromFile(2020, 12, false);
		//part1(instructions);
		part2();

	}


	private static void part1(List<String> instructions) {

		instructions.forEach(instruction->{
			move(instruction);
			System.out.println("North :- "+N+" East :- "+ E+" Facing :-"+face);
		});

		if(N<0){
			N = N*(-1);
		}
		if(E<0){
			E = E*(-1);
		}
		System.out.println(" Ans :-" + (N+E));
	}

	private static void move(String instruction) {
		Character command = instruction.charAt(0);
		int moveBy = Integer.parseInt(instruction.substring(1));

		moveCommand(command, moveBy);
	}

	private static void moveCommand(Character command, int moveBy) {
		if(command == 'N'){
			N = N + moveBy;
		}
		if(command == 'S'){
			N = N - moveBy;
		}
		if(command == 'E'){
			E = E + moveBy;
		}
		if(command == 'W'){
			E = E - moveBy;
		}
		if(command == 'F'){
			moveCommand(face, moveBy);
		}
		if(command == 'L' ||command == 'R'){
			turn(command, moveBy);
		}
	}

	private static void turn(Character command, int moveBy) {

		int currentIndex = 0;
		for (int i = 0; i < directions.length; i++) {
			if(directions[i]==face){
				currentIndex = i;
				break;
			}
		}


		int positionsToTurn = moveBy/90;
		int newPosition = 0;
		if(command=='R'){

			newPosition = currentIndex + positionsToTurn;
		}
		if(command=='L'){

			newPosition = currentIndex - positionsToTurn;
		}

		if(newPosition<0){
			newPosition = newPosition + 4;
		}
		if(newPosition>3){
			newPosition = newPosition - 4;
		}
		face = directions[newPosition];
	}

	public static void part2() throws FileNotFoundException {
		Scanner s = new Scanner(new File("/Users/mohitk/projects/personal/adventofcode/src/main/resources/static/"+2020+"/day"+12+".txt"));
		int x = 0;
		int y = 0;
		int d = 0;

		//The waypoint is represented as a vector (xw, yw) and not by an actual point. The waypoint is relative to the starting point and not to the position of the ship.
		int xw = 10;
		int yw = 1;

		while (s.hasNextLine()) {
			String l = s.nextLine();
			char a = l.charAt(0);
			int b = Integer.parseInt(l.substring(1));
			switch(a){
				case 'N':
					yw = yw + b;
					break;
				case 'E':
					xw = xw + b;
					break;
				case 'S':
					yw = yw - b;
					break;
				case 'W':
					xw = xw - b;
					break;
				case 'L':
					for (int i = 0; i < (b / 90); i++){
						int oldxw = xw;
						xw = -yw;
						yw = oldxw;
					}
					break;
				case 'R':
					for (int i = 0; i < (b / 90); i++) {
						int oldxw = xw;
						xw = yw;
						yw = -oldxw;
					}
					break;
				case 'F':
					for (int i = 0; i < b; i++){
						x = x + xw;
						y = y + yw;
					}
					break;
			}
		}
		System.out.println(Math.abs(x) + Math.abs(y));
	}


}