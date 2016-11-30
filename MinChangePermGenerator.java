/**
 * MinChangePermGenerator.java
 *
 * Creates ArrayLists of Strings, as necessary, to store 
 * and return the list of permutations with minimum-changes
 * in the order described in the text. 
 */

import java.util.ArrayList;
public class MinChangePermGenerator {
    private ArrayList<String> permutations; 
    private String inputString;
    private boolean changeDirection;

    /*
     * Constructor. Instatiates the ArrayList.
     */
    public MinChangePermGenerator(String input) {
        inputString = input;
        permutations = new ArrayList<String>();
        changeDirection = false;
    }
    
    //Recursive algorithm for getting minimum-change permutations
    public ArrayList<String> getPermutations() {
        if(inputString.equals("")) { //string is empty
            permutations.add(inputString);
        } else {
            //strip input string from the end one character at a time
            //recursively generating permutations
            char lastChar = inputString.charAt(inputString.length() - 1);
            String simplerWord = inputString.substring(0, inputString.length() - 1);
            MinChangePermGenerator simplerWordGenerator = new MinChangePermGenerator(simplerWord);
            ArrayList<String> currentPerms = simplerWordGenerator.getPermutations();

            //Alternates between right-to-left and left-to-right
            //traversal of elements.
            for(int i = 0; i < currentPerms.size(); i++) {
                String curPerm = currentPerms.get(i);

                if(changeDirection) { //go left to right
                    for(int m = 0; m <= curPerm.length(); m++) {
                        String curString = curPerm.substring(0, m) + lastChar + curPerm.substring(m);
                        permutations.add(curString);
                    }
                } else { //go right to left
                    for(int n = curPerm.length(); n >= 0 ; n--) {
                        String curString = curPerm.substring(0, n) + lastChar + curPerm.substring(n);
                        permutations.add(curString);
                    }
                }
                changeDirection = !changeDirection;
            }
        }
        return permutations;
    }
}
