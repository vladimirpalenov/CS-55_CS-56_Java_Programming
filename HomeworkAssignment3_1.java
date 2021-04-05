public class HomeworkAssignment3_1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.separateLetters("babbabababba"));
    }
}
class Solution {
    /**
     * FUNCTION SINGATURE:
     * String separateLetters(String input)
     * PURPOSE: the function takes in a string consisting of only 'a' and 'b's in it as input,
     * and outputs the string with all of the 'a' and 'b' in it separated so that all 'a' appear before 'b' in it.
     * @param String input
     * @return String output of 'a' and 'b' separated so that all 'a' appear before 'b' in it.
     **/
    public String separateLetters(String input) {
        String a = "";
        String b = "";
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == 'a'){
                a += 'a';
            } else{
                b += 'b';
            }
        }
        return a + b;
    }
}