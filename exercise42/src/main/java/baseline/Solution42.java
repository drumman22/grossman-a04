/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Solution42 {
    public static void main(String[] args) throws IOException {
        // Create file objects for input and output
        File inputFile = new File("data/exercise42_input.txt");
        File outputFile = new File("data/exercise42_output.txt");

        // Get a list of Person objects
        List<Person> people = getPersonList(inputFile);

        // Write list to output file
        writePersonList(outputFile, people);
    }

    public static List<Person> getPersonList(File inputFile) throws IOException {
        List<String> allLines = Files.readAllLines(inputFile.toPath());
        return generatePersonList(allLines);
    }

    public static List<Person> generatePersonList(List<String> lines) {
        // Initialize Person List to be made
        List<Person> people = new ArrayList<>();

        for (String line : lines) {
            // Split the parameters by comma
            String[] param = line.split(",");

            // Create person object using constructor
            Person person = new Person(param[1], param[0], Integer.parseInt(param[2]));

            // add person to person list (people)
            people.add(person);
        }

        return people;
    }

    public static void writePersonList(File outputFile, List<Person> people) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(String.format("%-9s %-9s %-9s%n", "Last", "First", "Salary"));
            writer.write("--------------------------\n");

            // Add each person into table
            for (Person p : people)
                writer.write(String.format("%-9s %-9s %-9s%n", p.getLast(), p.getFirst(), p.getSalary()));
        }
    }
}
