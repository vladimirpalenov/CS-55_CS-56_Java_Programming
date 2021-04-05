
public class HomeworkAssignment8_1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseInt(99)==99);
        System.out.println(sol.reverseInt(10100)==101);
        System.out.println(sol.reverseInt(Integer.MAX_VALUE)==0);
        System.out.println(sol.reverseInt(Integer.MIN_VALUE)==0);
        System.out.println(sol.reverseInt(1999993999)==0);
        System.out.println(sol.reverseInt(1905010000)==105091);
        System.out.println(sol.reverseInt(-1)==-1);
        System.out.println(sol.reverseInt(0)==0);
        System.out.println(sol.reverseInt(-100)==-1);
        System.out.println(sol.reverseInt(45)==54);
        System.out.println(sol.reverseInt(9)==9);
        System.out.println(sol.reverseInt(10)==1);
    }
}

class Solution {
     /**
     //* FUNCTION SINGATURE:
     //* int reverseInt(int input)
     //* PURPOSE: the function takes in any integer as input,
     //* and reverses it, exessive zeros at the beginning of the
     //* integer are being removed. Negative or positive sign remains.
     //* If the resulting number is greater than integer MAX_VALUE or
     //* smaller that MIN_VALUE the 0 is returned.
     //* @param int input
     //* @return int output - reversed input number, or 0 in case of int overflow.
     **/
    public int reverseInt(int input) {
        if (input == 0) return 0;
        String stringInput = Integer.toString(input);
        String reversedInput = "";
        int result;
        int positiveOrNegative = 1;
        boolean zeroOrNot = true;
        long test;

        for (int i = stringInput.length() - 1; i >= 0; i--) {
            if (stringInput.charAt(i) != '-') {
                if (zeroOrNot != true || stringInput.charAt(i) != '0') {
                    reversedInput += stringInput.charAt(i);
                    zeroOrNot = false;
                }
            } else {
                positiveOrNegative = -1;
            }
        }

        test = Long.parseLong(reversedInput) * positiveOrNegative;

        if (test > Integer.MAX_VALUE || test < Integer.MIN_VALUE){
            return 0;
        } else{
            result = Integer.parseInt(reversedInput) * positiveOrNegative;
        }
        return result;
    }

}