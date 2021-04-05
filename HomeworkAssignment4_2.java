import java.lang.*;

public class HomeworkAssignment4_2 {
    public static void main(String args[]) {
        Solution sol = new Solution();
        System.out.println(sol.deduplicate("AABB")); // should output "Empty"
        System.out.println(sol.deduplicate("A"));    // "A"
        System.out.println(sol.deduplicate("ABBA")); // should output "Empty"
        System.out.println(sol.deduplicate("AAA"));  // "A"
        System.out.println(sol.deduplicate("MISSISSIPPI"));  // "M" because everything else is removed
        System.out.println(sol.deduplicate("KKCCD"));  // "D" because everything else is removed
        System.out.println(sol.deduplicate("RRVKOOKLYIIYUUDCAABBCDADJHHJIGFFGMQQITOOTRXYYX")); // "VLADIMIR"
    }
}

class Solution {
    /**
     * FUNCTION SINGATURE:
     * String deduplicate(String input)
     * PURPOSE: Takes a string consisting of any characters. If the (String input) is more than 2 characters long,
     * the function executes while loop, with isDuplicate() function as a condition, until there is no duplicates
     * left in the String. If there are any consecutive pairs of duplicates, they are being removed by
     * removeDuplicatesOnce() function on every iteration of the while loop. The function returns a String with all
     * consecutive pairs of duplicates removed or "Empty" String if the string is empty.
     * // @param String input
     * @return String value with all consecutive pairs of duplicates removed. If an empty string was used as input or
     * there is an empty string left after removing of duplicates, the function returns "Empty".
     **/
    public String deduplicate(String input) {
        String result = input;
        if (input.length() > 1){
            while (isDuplicate(result) == true) {
        result = removeDuplicatesOnce(result);
            }
        }
        if (result.length() == 0){
            return "Empty";
        } else{
            return result;
        }
    }

    /**
     * FUNCTION SINGATURE:
     * String removeDuplicatesOnce(String input1)
     * PURPOSE: Takes a string of any characters and removes consecutive pairs of duplicates one time.
     * Returns string with consecutive pairs of duplicates removed one time;
     * // @param String input1
     * @return String value with duplicates removed once.
     **/

    public String removeDuplicatesOnce(String input1) {
        String beginning = "";
		String ending = "";
        for(int i = 1; i < input1.length(); i++){
            if (input1.charAt(i) != input1.charAt(i-1)){
                beginning += input1.charAt(i-1);
                ending = input1.substring(i);
            } else{
                ++i;
                ending = input1.substring(i);
            }
        }
        return beginning + ending;
    }

    /**
     * FUNCTION SINGATURE:
     * boolean isDuplicate (String str)
     * PURPOSE: Takes a string and checks if it has any consecutive pairs of duplicates.
     * If there are duplicates - returns boolean value true, if no duplicates -
     * returns boolean value false;
     * // @param String str
     * @return boolean value true or false.
     **/

    public boolean isDuplicate (String str) {
        boolean returnValue = false;
        for (int a = 1; a < str.length(); a++){
            if (str.charAt(a) == str.charAt(a-1)){
                returnValue = true;
                break;
            } else{
                returnValue = false;
            }
        }
        return returnValue;
    }
}



