/**
 * LexPermGenerator.java
 *
 * Creates ArrayLists of Strings, as necessary, to store 
 * and return the list of permutations in lexigraphic 
 * order that it generates. 
 */

import java.util.ArrayList;

public class LexPermGenerator {
    private ArrayList<String> permutations; 
    private String inputString;

    /*
     * Constructor. Instatiates the ArrayList.
     */
    public LexPermGenerator(String input) {
        inputString = input;
        permutations = new ArrayList<String>();
    }
    
    //Recursive algorithm for getting lexigraphic permutations 
    /*If the string is empty return it 

    Loop through all character positions of the string containing the characters to be 
    permuted, for each character
    Form a simpler word by removing the character
    Generate all permutations of the simpler word recursively
    Add the removed character to the front of each permutation of the simpler word, and 
    add the resulting permutation to a list

    Return all these newly constructed permutations*/
    public ArrayList<String> getPermutations() {
        if(inputString.equals("")) {
            permutations.add(inputString);
        } else {
            for(int x = 0; x < inputString.length(); x++) {
                char removedChar = inputString.charAt(x);
                String simplerWord = inputString.substring(0, x) + inputString.substring(x+1);

                LexPermGenerator simplerWordGenerator = new LexPermGenerator(simplerWord);
                ArrayList<String> currentPerms = simplerWordGenerator.getPermutations();
                for(int i = 0; i < currentPerms.size(); i++) {
                    String curPerm = currentPerms.get(i);
                    permutations.add(removedChar + curPerm);
                }
            }
        }
        return permutations;
    }
}
