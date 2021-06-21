package com.company;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();

    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> vocabulary = new HashMap();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        int loc = 64;

        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                return;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            Iterator var5 = exits.keySet().iterator();

            while(var5.hasNext()) {
                String exit = (String)var5.next();
                System.out.print(exit + ", ");
            }

            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                String[] var7 = words;
                int var8 = words.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    String word = var7[var9];
                    if (vocabulary.containsKey(word)) {
                        direction = (String)vocabulary.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = (Integer)exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}