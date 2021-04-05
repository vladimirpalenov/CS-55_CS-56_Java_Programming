public class HomeworkAssignment9_1 {
    public static void main(String args[]) {
         Solution sol = new Solution();
         System.out.println(sol.getNumPossibleSigns("ABC123", new String[]{"123C","123A","123 ADA"}));
         System.out.println(sol.getNumPossibleSigns("A", new String[]{"S","M","C"}));
         System.out.println(sol.getNumPossibleSigns("ABCDEFGHIJKLMNORSTUVWXYZ1234567890", new String[]{"2 FIRST ST"," 13 PUN ST", "101 AKER"}));
         System.out.println(sol.getNumPossibleSigns("ABCDAAST", new String[]{"999 S ST", "A BAD ST", "B BAD ST"}));
    }
}

class Solution {
    /**
     * MEMBER FUNCTION NAME:
     * getNumPossibleSigns
     * PURPOSE:
     * The function takes in a series of addresses in a string array and compares each of them with the available
     * letterInventory, returning the number of addresses that are POSSIBLE to form from the given letterInventory
     * PARAMETER:
     * String   letterInventory
     * String[] addresses
     * RETURN VALUE:
     * int: the number of possible addresses that can be formed from your inventory of letters
     **/
    int getNumPossibleSigns(String letterInventory, String[] addresses) {
        int result = 0;
        boolean fits = true;
        char[] charArr = letterInventory.toCharArray();
        for (int i = 0; i < addresses.length; i++){
            for (int count = 0; count < addresses[i].length(); count++){
                if (!arrContainsChar(charArr, addresses[i].charAt(count))){
                    fits = false;
                    break;
                } else{
                    fits = true;
                }
            }
            if (fits) result++;
            charArr = letterInventory.toCharArray();
        }
        return result;
    }
    /**
     * MEMBER FUNCTION NAME:
     * boolean arrContainsChar(char[] charArray, char a)
     * PURPOSE:
     * The function takes in an array of integers and a character, and checks if the array contains given character or
     * not, a boolean value true is returned if the array contains the char, false if it doesn't. Once a matching char
     * is found in the array, it is replaced in the original array with '@' char to not be used again.
     * PARAMETERS:
     * char[] charArray
     * char a
     * RETURN VALUE:
     * boolean: true if the array contains character, false - if not.
     **/
    boolean arrContainsChar(char[] charArray, char a){
        boolean result = false;
        for (int i = 0; i < charArray.length; i++){
            if (a == ' '){
                result = true;
                break;
            } else if(charArray[i] == a){
                result = true;
                charArray[i] = '@';
                break;
            }
        }
        return result;
    }
}