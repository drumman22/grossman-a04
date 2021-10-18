/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution43 {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // Create websiteGen object
        WebsiteGenerator webGen = new WebsiteGenerator();
        webGen.setSiteName(getStringInput("Site name: "));
        webGen.setAuthor(getStringInput("Author: "));
        webGen.setJSFolder(getBoolInput("Do you want a folder for JavaScript? "));
        webGen.setCSSFolder(getBoolInput("Do you want a folder for CSS? "));

        File dirPath = new File("data/website");
        File templatePath = new File("data/index.html");
        webGen.createDirectory(dirPath);
        webGen.formatHtmlTemplate(dirPath, templatePath);
    }

    // Get boolean input using Y or N
    public static boolean getBoolInput(String message) {
        System.out.print(message);
        return validateBoolInput(input.nextLine(), message);
    }

    private static boolean validateBoolInput(String in, String message) {
        if (in.equalsIgnoreCase("Y"))
            return true;
        if (in.equalsIgnoreCase("N"))
            return false;

        System.out.println("Invalid input!");
        System.out.print(message);
        return validateBoolInput(in, message);
    }

    public static String getStringInput(String message) {
        System.out.print(message);
        return input.nextLine();
    }
}
