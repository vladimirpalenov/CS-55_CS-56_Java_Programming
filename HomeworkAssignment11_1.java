public class HomeworkAssignment11_1 {
    public static void main(String args[]) {
        Solution sol = new Solution();
        System.out.println(sol.countNumber("9")==19);
        System.out.println(sol.countNumber("10001")==113011);
        System.out.println(sol.countNumber("1000")==1130);
        System.out.println(sol.countNumber("111")==31);
        System.out.println(sol.countNumber("20")==1210);
        System.out.println(sol.countNumber("888")==38);
    }
}

class Solution {
    /**
     * MEMBER FUNCTION NAME:
     * int countNumber(String str)
     * PURPOSE:
     * The function takes in a string consisting of digits 0-9 only, which can not start with a '0'
     * and outputs an int, representing a count of digits in a given string. For example,
     * input "111" returns 31, "1000" returns 1130, etc.
     * PARAMETER:
     * String str
     * RETURN VALUE:
     * int: the count for each digit occurance it a given string
     **/
    int countNumber(String str) {
        if (str.length() == 1){
            return Integer. parseInt("1" + str);
        };
        char currentChar = str.charAt(0);
        int count = 1;
        String result = "";
        for (int i = 1; i < str.length(); i++){
            if (i == str.length() - 1 && currentChar == str.charAt(i)){
                count++;
                result = result + count + currentChar;
            } else if (i == str.length() - 1 && currentChar != str.charAt(i)){
                result = result + count + currentChar;
                count = 1;
                result = result + count + str.charAt(i);
            }else if (str.charAt(i) == currentChar){
                count++;
            } else{
                result = result + count + currentChar;
                currentChar = str.charAt(i);
                count = 1;
            }
        }
        return Integer. parseInt(result);
    }
};