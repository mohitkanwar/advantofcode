package com.mk.adventofcode.y2020;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class AdventofcodeApplicationDay6 {


	public static void main(String[] args) {


		try (Stream<String> stream = Files.lines(Paths.get("/Users/mohitk/projects/personal/adventofcode/src/main/resources/static/day6.txt"))) {

			int total = 0;
			List<String> lines = stream.collect(Collectors.toList());
			List<String> group = new ArrayList<>();
			boolean[] answered = new boolean[26];
			for (int j = 0; j < lines.size(); j++) {
				String line = lines.get(j);

				if (line.trim().length() == 0) {

					if(group.size() == 1){
						total = total + group.get(0).length();
					}else {
						for (int i = 0, groupSize = group.size(); i < groupSize; i++) {
							String s = group.get(i);
							String[] sp = s.split("");
							if(i == 0){
								for (int k = 0; k < sp.length; k++) {
									if(sp[k].equals("a")){
										answered[0] = true;
									}
									if(sp[k].equals("b")){
										answered[1] = true;
									}
									if(sp[k].equals("c")){
										answered[2] = true;
									}
									if(sp[k].equals("d")){
										answered[3] = true;
									}
									if(sp[k].equals("e")){
										answered[4] = true;
									}
									if(sp[k].equals("f")){
										answered[5] = true;
									}
									if(sp[k].equals("g")){
										answered[6] = true;
									}
									if(sp[k].equals("h")){
										answered[7] = true;
									}
									if(sp[k].equals("i")){
										answered[8] = true;
									}
									if(sp[k].equals("j")){
										answered[9] = true;
									}
									if(sp[k].equals("k")){
										answered[10] = true;
									}
									if(sp[k].equals("l")){
										answered[11] = true;
									}
									if(sp[k].equals("m")){
										answered[12] = true;
									}
									if(sp[k].equals("n")){
										answered[13] = true;
									}
									if(sp[k].equals("o")){
										answered[14] = true;
									}
									if(sp[k].equals("p")){
										answered[15] = true;
									}
									if(sp[k].equals("q")){
										answered[16] = true;
									}
									if(sp[k].equals("r")){
										answered[17] = true;
									}
									if(sp[k].equals("s")){
										answered[18] = true;
									}
									if(sp[k].equals("t")){
										answered[19] = true;
									}
									if(sp[k].equals("u")){
										answered[20] = true;
									}
									if(sp[k].equals("v")){
										answered[21] = true;
									}
									if(sp[k].equals("w")){
										answered[22] = true;
									}
									if(sp[k].equals("x")){
										answered[23] = true;
									}
									if(sp[k].equals("y")){
										answered[24] = true;
									}
									if(sp[k].equals("z")){
										answered[25] = true;
									}
								}
							}
							else {
								for (int i1 = 0; i1 < answered.length; i1++) {
									boolean prevAns = answered[i1];
									if(prevAns){
										if(!s.contains(getChar(i1))){
											answered[i1]=false;
										}
									}
								}
							}

						}

						for (int i = 0; i < answered.length; i++) {
							if(answered[i]){
								total++;
							}
						}
					}

					group = new ArrayList<>();
					answered = new boolean[26];

				} else {

					group.add(line);
//					String[] split = line.split("");
//					for (int i = 0; i < split.length; i++) {
//						if (split[i].trim().length() > 0) {
//							answered.add(split[i]);
//						}
//					}


				}
				System.out.println(total);
			}

		} catch (IOException e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
	}

	private static String getChar(int i1) {
		String chars = "abcdefghijklmnopqrstuvwxyz";
		return String.valueOf(chars.charAt(i1));
	}


}
