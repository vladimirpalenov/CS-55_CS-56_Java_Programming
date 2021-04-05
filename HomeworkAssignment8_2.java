public class HomeworkAssignment8_2 {
    public static void main(String args[]) {
        Solution sol = new Solution();
        System.out.println(sol.convertString2Integer("123")==123);
        System.out.println(sol.convertString2Integer("-999")==-999);
        System.out.println(sol.convertString2Integer("000")==0);
        System.out.println(sol.convertString2Integer("0001")==1);
        System.out.println(sol.convertString2Integer("1000")==1000);
        System.out.println(sol.convertString2Integer("0")==0);
        System.out.println(sol.convertString2Integer("5")==5);
    }
}

class Solution {
     /**
     //* FUNCTION SINGATURE:
     //* int convertString2Integer(String input)
     //* PURPOSE: the function takes in a string consisting only of
     //* digits and a '-' sign as input, and converts it into an integer.
     //* @param String input
     //* @return integer value of the string input after conversion.
     **/
    public int convertString2Integer(String input) {
        int result = 0;
        int counter = input.length() - 1;
        int positiveOrNegative = 1;
        boolean zeroOrNot = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '-') {
                if (zeroOrNot != true || input.charAt(i) != '0') {
                    result = result + convertDigit2Integer(input.charAt(i)) * power(10, counter);
                    zeroOrNot = false;
                    counter--;
                } else{
                    counter--;
                }
            } else {
                positiveOrNegative = -1;
                counter--;
            }
        }
        result *= positiveOrNegative;
        return result;
    }

    /**
     //* FUNCTION SINGATURE:
     //* int power(int a, int b)
     //* PURPOSE: the function performs power calculations on integers
     //* @param int a, int b
     //* @return integer value of int a to the power of b
     **/
    public int power(int a, int b){
        int result = 1;
        for (int i = 1; i <= b; i++) {
            result *= a;
        }
        return result;
    }

    /**
     //* FUNCTION SINGATURE:
     //* int convertDigit2Integer (char input)
     //* PURPOSE: the function converts characters into integers.
     //* If non-digit value is passed as input, 0 is returned.
     //* @return integer value of input character, or 0 if the char is not a digit.
     **/
    public int convertDigit2Integer (char input){
        switch(input) {
            case '0' :
                return 0;
            case '1' :
                return 1;
            case '2' :
                return 2;
            case '3' :
                return 3;
            case '4' :
                return 4;
            case '5' :
                return 5;
            case '6' :
                return 6;
            case '7' :
                return 7;
            case '8' :
                return 8;
            case '9' :
                return 9;
            default  :
                return 0;
        }
    }
}

