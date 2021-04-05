
public class HomeworkAssignment5_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getSecretMessage("  santa    monica college   ")); // prints "smc"
        System.out.println(sol.getSecretMessage("     "));                    // prints nothing
        System.out.println(sol.getSecretMessage("santa monica"));         // prints "sm"
    }
}
class Solution {
    /**
     * FUNCTION SIGNATURE: String getSecretMessage(String str)
     * PURPOSE: get secret message by taking the first character from each word in the input sentence, in the order they appear
     * PARAMETER:
     *     String str, the input sentence
     * RETURN VALUE:
     *     String, the secret message
     */
    public String getSecretMessage(String str) {
        String result = "";
        String[] arrOfStr = str.split(" ");
        for (int i = 0; i < arrOfStr.length; i++){
            if (arrOfStr[i].length() != 0){
                result += arrOfStr[i].charAt(0);
            }
        }
        return result;
    }
}