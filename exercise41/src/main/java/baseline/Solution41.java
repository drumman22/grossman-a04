/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution41 {
    public static void main(String[] args) throws IOException {
        // Create file objects for input and output
        File inputFile = new File("data/exercise41_input.txt");
        File outputFile = new File("data/exercise41_output.txt");

        // Create list and get input for names
        List<String> names = readNames(inputFile);

        // Sort list of names
        List<String> sortedNames = sortNames(names);

        // Output names
        writeNames(outputFile, sortedNames);
    }

    public static List<String> readNames(File inputFile) throws IOException {
        // Create list to hold names
        List<String> names = new ArrayList<>();

        String name;
        // try with reader resource
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            // Read all names
            while ((name = reader.readLine()) != null) {
                names.add(name);
            }
        }

        return names;
    }

    public static List<String> sortNames(List<String> names) {
        List<String> copy = new ArrayList<>(names);
        Collections.sort(copy);
        return copy;
    }

    public static void writeNames(File outputFile, List<String> names) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(String.format("Total of %d names\n-----------------\n", names.size()));
            for (String name : names) {
                writer.write(name + "\n");
            }
        }
    }
}
