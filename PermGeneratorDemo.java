/**
 * PermGeneratorDemo.java
 *
 * Gets input, instantiates appropriate objects and 
 * uses their methods to get results and displays the results.
 */

import java.util.Scanner;
import java.util.ArrayList;
 public class PermGeneratorDemo {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.print("Please enter a string of distinct lower case letters (in alphabetical order): "); 
         String input = sc.next();
         System.out.println();
         //System.out.println("here: " + input);

        LexPermGenerator lexGen = new LexPermGenerator(input);
        MinChangePermGenerator minGen = new MinChangePermGenerator(input);
        
        System.out.println("The permutations of the letters from " + input + " in lexigraphic order are: ");
        ArrayList<String> lexResult = lexGen.getPermutations();
        for(int i = 0; i < lexResult.size(); i++) {
            System.out.println(lexResult.get(i));
        }

        System.out.println();
        System.out.println("The permutations of the letters from " + input + " with \"minimum-change\" are: ");
        ArrayList<String> minResult = minGen.getPermutations();
        for(int i = 0; i < minResult.size(); i++) {
            System.out.println(minResult.get(i));
        }

     }
 }
