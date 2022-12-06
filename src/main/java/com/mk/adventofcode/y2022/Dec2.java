package com.mk.adventofcode.y2022;

import com.mk.adventofcode.utility.FileReaderUtility;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class Dec2 {

	private static final int YEAR = 2022;
	private static final int DAY = 2;

	public static void main(String[] args) throws IOException {
		List<String> exampleLines = FileReaderUtility.getLinesFromFile(YEAR, DAY, true);
		System.out.println("Example Part 1");
		System.out.println("==================");
		part1(exampleLines);
		System.out.println("Example Part 2");
		System.out.println("==================");
		part2(exampleLines);
		System.out.println("==================");
		System.out.println("==================");
		System.out.println("==================");
//		List<String> lines = FileReaderUtility.getLinesFromFile(2021,1,true);
		List<String> lines = FileReaderUtility.getLinesFromFile(YEAR, DAY);
		System.out.println("Part 1");
		System.out.println("==================");
		part1(lines);
		System.out.println("Part 2");
		System.out.println("==================");
		part2(lines);
	}

	private static void part2(List<String> lines) {
		int totalScore = 0;
		for(String line: lines) {
			Move opponentMove = getMove(line.charAt(0));
			Move yourMove = choseMove(line.charAt(2), opponentMove);
			int gameScore = getVictoryStatus(opponentMove, yourMove);
			int moveScore = getMoveScore (yourMove);

			totalScore = totalScore + gameScore + moveScore;
		}
		System.out.println(totalScore);

	}

	private static Move choseMove(char victoryStatus, Move opponentMove) {
		if (victoryStatus == 'Y') {
			return opponentMove;
		} else if (victoryStatus == 'X') {
			if(opponentMove == Move.Paper) {
				return Move.Rock;
			} else if(opponentMove == Move.Rock) {
				return Move.Scissors;
			} else {
				return Move.Paper;
			}

		} else {
			if(opponentMove == Move.Paper) {
				return Move.Scissors;
			} else if(opponentMove == Move.Rock) {
				return Move.Paper;
			} else {
				return Move.Rock;
			}
		}
	}

	private static void part1(List<String> lines) {
		int totalScore = 0;
		for(String line: lines) {
			Move opponentMove = getMove(line.charAt(0));
			Move yourMove = getMove(line.charAt(2));
			int gameScore = getVictoryStatus(opponentMove, yourMove);
			int moveScore = getMoveScore (yourMove);

			totalScore = totalScore + gameScore + moveScore;
		}
		System.out.println(totalScore);
	}

	private static int getMoveScore(Move yourMove) {
		if (yourMove == Move.Rock) {
			return 1;
		} else if (yourMove == Move.Paper) {
			return 2;
		} else {
			return 3;
		}
	}

	private static int getVictoryStatus(Move opponentMove, Move yourMove) {
		if(opponentMove == yourMove) {
			return 3;
		}
		if (
				(yourMove== Move.Rock && opponentMove == Move.Scissors)||
						(yourMove== Move.Paper && opponentMove == Move.Rock)||
						(yourMove== Move.Scissors && opponentMove == Move.Paper)
		) {
			return 6;
		}

		return 0;
	}

	private static Move getMove(char character) {
		if (character == 'A' || character == 'X') {
			return Move.Rock;
		} else if (character == 'B' || character == 'Y') {
			return Move.Paper;
		} else {
			return Move.Scissors;
		}

	}

	enum Move {
		Rock, Paper, Scissors
	}
}
