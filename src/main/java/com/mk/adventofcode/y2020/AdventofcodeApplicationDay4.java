package com.mk.adventofcode.y2020;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class AdventofcodeApplicationDay4 {


	public static void main(String[] args) {

		boolean birthYearFound = false;
		boolean issueYearFound = false;
		boolean expirationYearFound = false;
		boolean heightFound = false;
		boolean hairColourFound = false;
		boolean eyeColourFound = false;
		boolean passportIdFound = false;
		boolean countryidFound = false;
		int validPassports = 0;
		int invalidPassports = 0;
		try (Stream<String> stream = Files.lines(Paths.get("/Users/mohitk/projects/personal/adventofcode/src/main/resources/static/day4.txt"))) {

			List<String> lines = stream.collect(Collectors.toList());
			for(String line:lines){
				if(line.trim().length()==0){
					if(birthYearFound&&issueYearFound&&expirationYearFound&&heightFound&&hairColourFound&&eyeColourFound&&passportIdFound){
						System.out.println("Valid");
						validPassports++;
					} else {
						invalidPassports++;
						System.out.println("Invalid passport");
					}
					birthYearFound = false;
					issueYearFound = false;
					expirationYearFound = false;
					heightFound = false;
					hairColourFound = false;
					eyeColourFound = false;
					passportIdFound = false;
					countryidFound = false;
					continue;
				}
				else{
					System.out.println("continue passport");
					if(line.contains("byr:")){
						String birthYear = getValue("byr:", line+" ");
						int b = Integer.parseInt(birthYear);
						birthYearFound = (b>= 1920) && (b<=2002);
					}
					if(line.contains("iyr:")){
						String birthYear = getValue("iyr:", line+" ");
						int b = Integer.parseInt(birthYear);
						issueYearFound = (b>= 2010) && (b<=2020);
					}
					if(line.contains("eyr:")){
						String birthYear = getValue("eyr:", line+" ");

						int b = Integer.parseInt(birthYear);
						expirationYearFound = (b>= 2020) && (b<=2030);
					}
					if(line.contains("hgt:")){
						String height = getValue("hgt:", line+" ");
						if(height.endsWith("cm")){
							int h = Integer.parseInt(height.split("cm")[0]);
							heightFound = (h>= 150) && (h<=193);
						}
						else if(height.endsWith("in")){
							int h = Integer.parseInt(height.split("in")[0]);
							heightFound = (h>= 59) && (h<=76);

						}
						else {
							heightFound = false;
						}
					}
					if(line.contains("hcl:")){
						String hairColour = getValue("hcl:", line+" ");
						if(hairColour.startsWith("#") && hairColour.length() == 7){
							hairColourFound = hairColour.matches("[#][0-9a-f]{6}");
						}else {

							hairColourFound = false;
						}
					}
					if(line.contains("ecl:")){
						String eyecolour = getValue("ecl:", line+" ");
						Set<String> validEye = new HashSet<>();
								validEye.add("amb");
								validEye.add("blu");
								validEye.add("brn");
								validEye.add("gry");
								validEye.add("grn");
								validEye.add("hzl");
								validEye.add("oth");

						eyeColourFound = validEye.contains(eyecolour);
					}
					if(line.contains("pid:")){
						String pid = getValue("pid:", line+" ");

						passportIdFound = pid.matches("[0-9]{9}");
					}
					if(line.contains("cid:")){
						String birthYear = getValue("cid:", line+" ");

						countryidFound = true;
					}
				}


			}
			System.out.println(validPassports);
			System.out.println(invalidPassports);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static String getValue(String s, String line) {
		String[] words = line.split(s);
		return words[1].split(" ")[0];
	}


}
