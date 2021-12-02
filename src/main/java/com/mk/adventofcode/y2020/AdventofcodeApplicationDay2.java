package com.mk.adventofcode.y2020;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@SpringBootApplication
public class AdventofcodeApplicationDay2 {

	private static String[] input(){
		return new String[]{
				"1-3 a: abcde"
		};
	}

	public static void main(String[] args) {
		AtomicInteger valid = new AtomicInteger();
		AtomicInteger invalid = new AtomicInteger();
		try (Stream<String> stream = Files.lines(Paths.get("/Users/mohitk/projects/personal/adventofcode/src/main/resources/static/2020/day2.txt"))) {
			stream.forEach((line)->{
				String[] combi = line.split(": ");
				String rule = combi[0];
				String password = combi[1];
				String[] ruleCombo = rule.split("-");
				String min = ruleCombo[0];
				String[] ruleWordCombo = ruleCombo[1].split(" ");
				String max = ruleWordCombo[0];

				char alphabet = ruleWordCombo[1].charAt(0);
				int occurance = StringUtils.countOccurrencesOf(password, String.valueOf(alphabet));
				// Part 1
//				if(Integer.parseInt(min)<=occurance && occurance<= Integer.parseInt(max)){
//
//					valid.getAndIncrement();
//				} else {
//					invalid.getAndIncrement();
//				}

				char first = password.charAt(Integer.parseInt(min)-1);
				if(password.length()>=Integer.parseInt(max)){

					char second = password.charAt(Integer.parseInt(max)-1);
					if((first==alphabet)^(second==alphabet)){
						valid.getAndIncrement();
						System.out.println(" For Valid Rule :["+ line +"] first ["+first+"] second ["+second+"] alphabet ["+alphabet+"] ");
					} else {
						invalid.getAndIncrement();
						System.out.println(" For inValid Rule :["+ line +"] first ["+first+"] second ["+second+"] alphabet ["+alphabet+"] ");
					}
				}
				 else {
					invalid.getAndIncrement();
					System.out.println(" For invalid due to length  Rule :["+ line +"] first ["+first+"]  alphabet ["+alphabet+"] ");
				}

			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Valid :"+ valid.toString());
		System.out.println("InValid :"+ invalid.toString());
	}

}
