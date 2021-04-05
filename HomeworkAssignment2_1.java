import java.math.BigDecimal;
import java.math.RoundingMode;

public class HomeworkAssignment2_1 {
    public static void main(String args[]) {
        int numOfPennies = 8901;
        Solution sol = new Solution();
        System.out.println(sol.breakCash(numOfPennies));
    }
}
class Solution {
    /**
     * FUNCTION SINGATURE:
     * String breakCash(int numPennies)
     * PURPOSE: the function takes in the total of pennies from the user as input,
     * computes its equivalent in dollars, quarters, dimes, nickels, and pennies,
     * and outputs the result in string to the console.
     *
     * @param int numPennies
     * @return String output in dollars, quarters, dimes, nickels, and pennies and converts to Canadian dollars with 2 decimal points (exchange rate is 1.33 CAD for 1 USD).
     */
    public String breakCash(int numPennies) {
        int reminder = numPennies;
        int dollars = (reminder - (reminder % 100)) / 100;
        reminder = reminder - dollars * 100;
        int quarters = (reminder - (reminder % 25)) / 25;
        reminder = reminder - quarters * 25;
        int dimes = (reminder - (reminder % 10)) / 10;
        reminder = reminder - dimes * 10;
        int nickels = (reminder - (reminder % 5)) / 5;
        reminder = reminder - nickels * 5;
        int pennies = reminder;
        double canadianPennies =  numPennies * 1.33;
        BigDecimal canadianDollars = new BigDecimal(canadianPennies / 100).setScale(2, RoundingMode.HALF_UP);
        BigDecimal numDollars = new BigDecimal(numPennies / 100).setScale(2, RoundingMode.HALF_UP);
        double canDollar = canadianDollars.doubleValue();
        double usDollars = numDollars.doubleValue();
        return "The dollar amoumt of your pennies is: " + usDollars + " dollars. \nIn US currency you have: " + dollars + " dollars, " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, " + pennies + " pennies.\n" + "In Canadian currency you have: " + canDollar + " dollars.";
    }
}