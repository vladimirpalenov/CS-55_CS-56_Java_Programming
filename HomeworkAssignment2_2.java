import java.lang.*;

public class HomeworkAssignment2_2 {
    public static void main(String args[]) {
        Solution sol = new Solution();
        String[] words = {"abacgy", "abagh", "aba"};
        System.out.println(sol.getLargestPrefix(words));
    }
}
class Solution {
    /**
     * FUNCTION SINGATURE:
     * String getLargestPrefix (String[] words)
     * PURPOSE: the function takes in an array of strings as input,
     * finds common prefix for every string in array,
     * and outputs the common prefix (if there is no one the function returns an empty string "").
     * @param String[] words
     * @return String output of a common prefix (if there is no one the function returns an empty string "").
     */

    public String getLargestPrefix(String[] words) {
        String result = "";
        char currentLetter;
        int minLength = words[0].length();
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < minLength){
                minLength = words[i].length();

            }
        }
        for (int a = 0; a < minLength; a++){
            currentLetter = words[0].charAt(a);
            for (int b = 1; b < words.length; b++){
                if (words[b].charAt(a) != currentLetter){
                    return result;
                }
            }
            result = result + currentLetter;
        }
        return result;
    }
}