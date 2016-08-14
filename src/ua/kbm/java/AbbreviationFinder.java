package ua.kbm.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class AbbreviationFinder {
    
    public static void main(String[] args) throws IOException {
        String file = args[0];
        String pattern = args[1];
        Files.readAllLines(Paths.get(file)).stream()
                .filter((s) -> getStringPattern(s.trim().split(" ")).contains(pattern))
                .forEach(System.out::println);
    }

    private static String getStringPattern(String[] words) {
        return Stream.of(words)
                .filter(s -> !s.isEmpty() && Character.isLetter(s.charAt(0)))
                .map(s1 -> String.valueOf(s1.charAt(0)))
                .reduce("", (a, b)-> a+b).toLowerCase();
    }
}