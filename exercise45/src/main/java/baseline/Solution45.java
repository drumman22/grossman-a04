/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.io.*;

public class Solution45 {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("data/exercise45_input.txt");
        replaceWords(inputFile, "utilize", "use");
    }

    public static void replaceWords(File path, String word, String newWord) throws IOException {
        String line = "";
        String oldtext = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null) {
                oldtext += line + "\r\n";
            }
        }

        String replacedtext  = oldtext.replaceAll(word, newWord);

        try (FileWriter writer = new FileWriter("data/exercise45_output.txt")) {
            writer.write(replacedtext);
        }
    }
}