/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jason Grossman
 */

package baseline;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class Solution44 {
    static List<Item> itemList;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        parseJSON();
        System.out.print("What is the product name? ");
        String input = Solution44.input.nextLine();

        while (!searchItemByName(input)) {
            System.out.print("Sorry, that product was not found in our inventory.\nWhat is the product name? ");
            input = Solution44.input.nextLine();
        }
    }

    public static void parseJSON() throws IOException {
        File jsonData = new File("data/exercise44_input.json");
        Reader reader = Files.newBufferedReader(jsonData.toPath());

        // Convert JSON file to a map (dictionary)
        Gson gson = new Gson();
        Map<?, ?> map = gson.fromJson(reader, Map.class);

        String productList = gson.toJson(map.get("products"));
        itemList = new Gson().fromJson(productList, new TypeToken<List<Item>>(){}.getType());
    }

    public static boolean searchItemByName(String name) {
        for (Item item : itemList) {
            if (item.name.equals(name)) {
                System.out.printf("Name: %s%nPrice: %.2f%nQuantity: %d", item.name, item.price, item.quantity);
                return true;
            }
        }
        return false;
    }
}