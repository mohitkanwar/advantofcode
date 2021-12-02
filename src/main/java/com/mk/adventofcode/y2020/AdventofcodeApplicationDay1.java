package com.mk.adventofcode.y2020;

import com.mk.adventofcode.utility.FileReaderUtility;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AdventofcodeApplicationDay1 {


	public static void main(String[] args) throws IOException {
		List<String> lines = FileReaderUtility.getLinesFromFile(2020,1);
		final int total = 2020;

		for (int k = 0; k < lines.size(); k++) {
			for (int j = 0; j < lines.size(); j++) {


				int finalJ = j;
				int finalK = k;
				if (lines.stream().anyMatch(x -> Integer.parseInt(x) + Integer.parseInt(lines.get(finalK)) +  Integer.parseInt(lines.get(finalJ)) == total)) {
					System.out.println(Integer.parseInt(lines.get(finalK)) * Integer.parseInt(lines.get(finalJ))* (total - (Integer.parseInt(lines.get(finalK))+Integer.parseInt(lines.get(finalJ)))));
					break;
				}
				;
			}

		}
	}

}
