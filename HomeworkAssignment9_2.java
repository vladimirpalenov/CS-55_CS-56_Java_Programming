public class HomeworkAssignment9_2 {
    public static void main(String args[]) {
         Solution sol = new Solution();
         String str1 = "VLADIMIR";
         System.out.println(sol.convertExcelTitleToNumber("ABCDEF"));
         System.out.println(sol.convertExcelTitleToNumber(str1));
        // ...
    }
}

class Solution {
    /**
     * MEMBER FUNCTION NAME:
     * int convertExcelTitleToNumber(String s)
     * PURPOSE:
     * The function takes in a string of capital case A-Z characters as input, the string represents
     * Excel Spreadsheet column title (26-base letter based number). the function converts the string to
     * integer.
     * PARAMETER:
     * String   s
     * RETURN VALUE:
     * int: the integer representation of Excel column title after conversion.
     **/
    int convertExcelTitleToNumber(String s) {
        if (s == null || s.equals("")) return -1;
        int result;
        int power = 0;
        int twentySix = 26;
        if (s.length() == 1){
            result = convertLetterToInt(s.charAt(0));
        } else{
            result = convertLetterToInt(s.charAt(s.length() - 1));
        }
        for (int i = s.length()-2; i >= 0 ; i--){
            result += convertLetterToInt(s.charAt(i)) * powerInt(twentySix, power);
            power++;
        }
        return  result;
    }

    /**
     * MEMBER FUNCTION NAME:
     * int convertLetterToInt(char a)
     * PURPOSE:
     * The function takes in a capital case char A-Z as input, and converts it to the number 1-26 respectively.
     * PARAMETER:
     * char a
     * RETURN VALUE:
     * int: the integer representation of char A-Z as 1-26. If wrong input received program shows error message.
     **/
    int convertLetterToInt(char a){
        int result = 0;
        switch (a){
            case 'A':
                result = 1;
                break;
            case 'B':
                result = 2;
                break;
            case 'C':
                result = 3;
                break;
            case 'D':
                result = 4;
                break;
            case 'E':
                result = 5;
                break;
            case 'F':
                result = 6;
                break;
            case 'G':
                result = 7;
                break;
            case 'H':
                result = 8;
                break;
            case 'I':
                result = 9;
                break;
            case 'J':
                result = 10;
                break;
            case 'K':
                result = 11;
                break;
            case 'L':
                result = 12;
                break;
            case 'M':
                result = 13;
                break;
            case 'N':
                result = 14;
                break;
            case 'O':
                result = 15;
                break;
            case 'P':
                result = 16;
                break;
            case 'Q':
                result = 17;
                break;
            case 'R':
                result = 18;
                break;
            case 'S':
                result = 19;
                break;
            case 'T':
                result = 20;
                break;
            case 'U':
                result = 21;
                break;
            case 'V':
                result = 22;
                break;
            case 'W':
                result = 23;
                break;
            case 'X':
                result = 24;
                break;
            case 'Y':
                result = 25;
                break;
            case 'Z':
                result = 26;
                break;
            default:
                System.out.println("Wrong input");
        }
        return result;
    }

    /**
     * MEMBER FUNCTION NAME:
     * int powerInt (int a, int b)
     * PURPOSE:
     * The function calculates power b of integer a (a^b).
     * PARAMETER:
     * int a
     * int b
     * RETURN VALUE:
     * int: a^b
     **/
    int powerInt (int a, int b){
        int result = a;
        for (int i = 1; i <= b; i++){
            result *= a;
        }
        return result;
    }
}