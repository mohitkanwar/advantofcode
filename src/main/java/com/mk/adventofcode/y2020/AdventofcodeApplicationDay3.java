package com.mk.adventofcode.y2020;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class AdventofcodeApplicationDay3 {


	public static void main(String[] args) {

		try (Stream<String> stream = Files.lines(Paths.get("/Users/mohitk/projects/personal/adventofcode/src/main/resources/static/2020/day3.txt"))) {

			List<String> collect = stream.collect(Collectors.toList());
			int o11 = calculate(1,1,collect);
			System.out.println(o11);
			int o31 = calculate(3,1,collect);
			System.out.println(o31);
			int o51 = calculate(5,1,collect);

			System.out.println(o51);
			int o71 = calculate(7,1,collect);

			System.out.println(o71);
			int o12 = calculate(1,2,collect);

			System.out.println(o12);

			System.out.println("----"+(o11*o12*o31*o51*o71));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static int calculate(int right, int down,List<String> collect) {
		int currentPosition = 0;
		int treeCount = 0;
		for (int i = 0, collectSize = collect.size(); i < collectSize; i=i+down) {
			String line = collect.get(i);
			int lineLength = line.length();
			if (line.charAt(currentPosition) == '#') {
				treeCount++;
			}
			if (currentPosition + right > lineLength - 1) {
				currentPosition = currentPosition + right - lineLength;
			} else {
				currentPosition = currentPosition + right;
			}
			System.out.println(line + "                ======" + line.charAt(currentPosition)+"             ======"+currentPosition+"           ===="+lineLength);
		}
		return treeCount;
	}

}
