public class HomeworkAssignment12_2 {
    public static void main(String args[]) {
        Solution sol = new Solution();
        System.out.println(sol.getMaxPond(new int[]{1})==0);
        System.out.println(sol.getMaxPond(new int[]{22,31,1,23})==66);
        System.out.println(sol.getMaxPond(new int[]{1,3,5})==3);
        System.out.println(sol.getMaxPond(new int[]{3,2,1})==2);
        System.out.println(sol.getMaxPond(new int[]{1,99,1})==2);
        System.out.println(sol.getMaxPond(new int[]{1,1,1,1,1,1,1,1,1})==8);
        System.out.println(sol.getMaxPond(new int[]{1, 2, 3, 1, 2, 1, 4, 8, 2, 2, 2, 0})==18);
        System.out.println(sol.getMaxPond(new int[]{0, 5, 3, 1, 2, 0, 4, 6, 9, 0, 0, 0})==35);
    }
}

class Solution {
    /**
     * MEMBER FUNCTION NAME:
     * getMaxPond(int[] arr)
     * PURPOSE:
     * The function takes in a pointer reference to an array of any arbitrary
     * elevation profile and its array size, and outputs the max cross
     * sectional area of the biggest pond based on this profile.
     * PARAMETER:
     * int[] arr
     * RETURN VALUE:
     * int value of the max cross sectional area.
     **/
    int getMaxPond(int[] arr) {
        int result = 0;
        int currentArea;
        if (arr.length == 1){
            return result;
        }
        for (int i = 0; i < arr.length; i++){
            int side1 = arr[i];
            for (int b = i; b < arr.length; b++){
                if (b != i){
                    currentArea = Math.min(arr[b], side1) * (b - i);
                    if (currentArea > result){
                        result = currentArea;
                    }
                }
            }
        }
        return result;
    }
};