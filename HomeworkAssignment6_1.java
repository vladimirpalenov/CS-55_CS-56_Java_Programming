import java.util.*;

public class HomeworkAssignment6_1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14};
        sol.leftShiftElements(arr,31);
        System.out.println(Arrays.toString(arr));
    }
}
class Solution {
    /**
     * FUNCTION SIGNATURE: void leftShiftElements(int[] arr, int M)
     * PURPOSE: This function imitates a circular array and shifts the elements of array to the left
     * by given int number M.
     * PARAMETERS:
     *     int[] arr, int M
     * RETURN VALUE:
     *     no return value, the function makes changes in the array passed to it.
     */
    public void leftShiftElements(int[] arr, int M) {
        int temp;
        int moveNum = M % arr.length; //2
        int b = 0;
        for (int i = moveNum; i < arr.length; i++) {
            temp = arr[b];
            arr[b] = arr[i];
            arr[i] = temp;
            b++;
        }
    }
}


