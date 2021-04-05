
public class HomeworkAssignment4_1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getShortestLength(1211));
        System.out.println(sol.getShortestLength(1234));
        System.out.println(sol.getShortestLength(-156));
        System.out.println(sol.getShortestLength(0));
        System.out.println(sol.getShortestLength(111));

    }
}
class Solution {
    /**
     * FUNCTION SINGATURE:
     * int getShortestLength(int n)
     * PURPOSE: the function returns the number of digits in the smallest palindrome
     * possible which starts with the int n. The function takes in an integer n
     * as input. If the value of int n is negative - function returns 0; if it's greater than 0
     * and less than 10, the function returns 1. If int n is greater or equal to 10,
     * it is checked if it's a palindrome using a function isAPalindrome(). If it's a
     * palindrome, the number of digits of int n is returned. If int n is not a palindrome,
     * the function completes it to the smallest possible palindrome and returns the number of digits in it.
     //* @param int n
     * @return An integer - number of digits in the smallest possible palindrome
     * starting with a given number, or a 0 if the given number is negative.
     */
    public int getShortestLength(int n) {
        String str = String.valueOf(n);
        String addition = "";
        int result = 0;
        int length = str.length();
        if (n < 0) {
            result = 0;
        } else if (n < 10) {
            result = 1;
        } else if (isAPalindrome(str) == true){
            result = str.length();
        } else{
            for (int i = 0; i < length; i++) {
                addition = str.charAt(i) + addition;
                String palindrome = str + addition;
                if (palindrome.equals( new StringBuilder(palindrome).reverse().toString()) ){
                    result = (str + addition).length();
                    break;
                }

            }
        }
        return result;
    }

    /**
     * FUNCTION SINGATURE:
     * boolean isAPalindrome(String input)
     * PURPOSE: the function takes in a String input, consisting of any characters,
     * and checks if it is a palindrome. It returns a boolean value, true - if the
     * input string is a palindrome and false if it's not.
     //* @param String input
     * @return boolean value
     */
    public boolean isAPalindrome(String input) {
        int len = input.length();
        int step = len / 2;
        boolean result = true;
        for (int i = 0; i < step; i++){
            if (input.charAt(i) != input.charAt(len - 1 - i)){
                result = false;
            }
        }
        return result;
    }
}