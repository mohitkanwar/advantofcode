package com.mk.adventofcode.y2020;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class AdventofcodeApplicationDay5 {


	public static void main(String[] args) {


		try (Stream<String> stream = Files.lines(Paths.get("/Users/mohitk/projects/personal/adventofcode/src/main/resources/static/day5.txt"))) {

			List<Integer> sortedSet = new ArrayList<>();
			stream.forEach(ticketId -> {
				int start = 0;
				int stop = 127;

				int colStart = 0;
				int colStop = 8;
				//String ticketId = "BBFFBBFRLL";
				String[] ticketSequence = ticketId.split("");
				int index = 0;
				int seatID = getSeatId(ticketId, index,start,stop, colStart, colStop );
				sortedSet.add(seatID);
				//System.out.println(seatID);
			});

			Collections.sort(sortedSet);

			sortedSet.forEach(id ->{
				if(!sortedSet.contains(id+1)){
					System.out.println(id);
				}
			});



		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	private static int getSeatId(String ticketID, int index, int start, int stop,int colStart, int colStop) {

		if(index == ticketID.length()){
			return start*8 + colStart;
		}
		else {

			char c = ticketID.charAt(index);
			if(c == 'B'){
				// upper half
				if(start+stop%2 !=0){
					int half = (start + stop +1) / 2;
					start = half;
				}
				else {
					int half = (start + stop) / 2;
					start = half;
				}
			}
			else if( c =='F'){
				// lower half
				if(start+stop%2 !=0){
					int half = (start + stop +1) / 2;
					stop = half;
				}
				else {
					int half = (start + stop) / 2;
					stop = half;
				}


			}
			else if(c=='R'){
				if(colStart+colStop%2 !=0){
					int half = (colStart + colStop +1) / 2;
					colStart = half;
				}
				else {
					int half = (colStart + colStop) / 2;
					colStart = half;
				}

			}
			else if(c=='L'){
				// lower half
				if(colStart+colStop%2 !=0){
					int half = (colStart + colStop +1) / 2;
					colStop = half;
				}
				else {
					int half = (colStart + colStop) / 2;
					colStop = half;
				}
			}
			//System.out.println(c +"  --  start ["+start+"] --  stop["+stop+"]  -- colStart ["+colStart+"] -- colStop --["+colStop+"] ");
			return getSeatId(ticketID, ++index, start, stop, colStart, colStop);
		}


	}


}
