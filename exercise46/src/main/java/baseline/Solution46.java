/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.util.*;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;

public class Solution46 {
    // TreeMap will keep list sorted when we append
    static TreeMap<String, Integer> wordFrequencyMap = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        File inputFile = new File("data/exercise46_input.txt");
        wordsToMap(inputFile);
        printWordFrequency();
    }

    public static void wordsToMap(File inputFile) throws IOException {
        // Convert file to string
        String allWords = Files.readString(inputFile.toPath());

        // Split by whitespace
        String[] words = allWords.split("\\s+");

        for (String word : words) {
            if (!wordFrequencyMap.containsKey(word)) {
                // Put word into map and default to 1
                wordFrequencyMap.put(word, 1);
            } else {
                // Increment by 1 if the word is already in the map
                wordFrequencyMap.put(word, wordFrequencyMap.get(word) + 1);
            }
        }
    }

    public static String numToStars(int num) {
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            builder.append("*");
            num--;
        }

        return builder.toString();
    }

    public static void printWordFrequency() {
        // Print the key and value for each entry
        for (Map.Entry<String, Integer> wordEntry : wordFrequencyMap.entrySet())
            System.out.printf("%10s: %s%n", wordEntry.getKey(), numToStars(wordEntry.getValue()));
    }
}