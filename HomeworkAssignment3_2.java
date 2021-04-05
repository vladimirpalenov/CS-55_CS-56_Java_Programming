public class HomeworkAssignment3_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // Test#1
        System.out.println(sol.canIAlwaysWin(2)); //outputs true
        // Test#2
        System.out.println(sol.canIAlwaysWin(6)); //outputs false
    }
}
class Solution {
    /**
     * FUNCTION SINGATURE:
     * boolean canIAlwaysWin(int n)
     * -----------------------------------------
     * PURPOSE: This function determines if there is a chance to win in the Game of Pebbles for the player or not.
     * Game rules: There is a pile of pebbles (little rocks). You and your friend play the game by removing these pebbles,
     * one or several at a time. You go first when the game starts (that is, you pick your game-winning move first)
     * You and your friend take turns to remove the rest. Each of you can remove 1 to 5 pebbles at each turn
     * The one who removes the last pebble will be the winner
     *
     * The function takes in the total number of pebbles as input (int n),
     * if n % 6 equals to 0 there is no chance for the player to win, and the function returns boolean value false,
     * in other case there is always 100% chance for the player to win and the function returns boolean value "true".
     * @param int n
     * @return boolean value true or false
     **/
    public boolean canIAlwaysWin(int n) {
        if (n % 6 == 0){
            return false;
        } else{
            return true;
        }
    }
}