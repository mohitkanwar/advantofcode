package com.mk.adventofcode.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderUtility {

    public static List<String> getLinesFromFile(int year, int day) throws IOException {
       return getLinesFromFile(year,day,false);
    }

    public static List<String> getLinesFromFile(int year,int day,boolean isExample) throws IOException {

        try (Stream<String> stream = Files.lines(Paths.get(FileReaderUtility.class.getResource("/static/"+year+"/day"+day+(isExample?"-e":"")+".txt").getPath()))) {
            return stream.collect(Collectors.toList());

        }catch (IOException e) {
            System.out.println("Exception");
            e.printStackTrace();
            throw e;
        }
    }


    public static List<Integer> getIntegersFromFile(int year, int day) throws IOException {
        return getIntegersFromFile(year,day,false);
    }

    public static List<Integer> getIntegersFromFile(int year,int day,boolean isExample) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(FileReaderUtility.class.getResource("/static/"+year+"/day"+day+(isExample?"-e":"")+".txt").getPath()))) {
            return stream.map(Integer::parseInt).collect(Collectors.toList());

        }catch (IOException e) {
            System.out.println("Exception");
            e.printStackTrace();
            throw e;
        }
    }

    public static List<List<Character>> getFileAs2DArray(int year,int day,boolean isExample) throws IOException {

            List<List<Character>> rows = new ArrayList<>();

            try{
                List<String> lines = getLinesFromFile(year,day,isExample);
                lines.forEach(line -> {
                    String[] characters = line.split("");
                    rows.add(Arrays.stream(characters).map(s -> s.charAt(0)).collect(Collectors.toList()));
                });


            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                // handle it
            }

        return rows;

    }
}
