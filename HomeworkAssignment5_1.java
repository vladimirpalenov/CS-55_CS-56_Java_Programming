import java.util.Arrays;

public class HomeworkAssignment5_1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.compareVersions("1.6.0","1.6")==0);
        System.out.println(sol.compareVersions("1", "2.0")==-1);
        System.out.println(sol.compareVersions("2.0", "1.0")==1);
        System.out.println(sol.compareVersions("0.0.9.1", "0.0.9")==1);
        System.out.println(sol.compareVersions("0.0.9.1", "0.0.9")==1);
        System.out.println(sol.compareVersions(".0.2.1.", "0.0.2.1")==0);
        System.out.println(sol.compareVersions(".2.9.9.9.1.1.1.1.1.1.1.1.1.1.1.1", ".1.1.9.99.99.99.99.99.99.99.99.99.99.99.99.99.99.99.99.99.99.99.99.99.99.99.99.99.9")==1);
        System.out.println(sol.compareVersions("1.0.0.0.0.0.0.0.0.0", "1")==0);
        System.out.println(sol.compareVersions("0.0.0.0.0.0.0.0.0.0", "0.0")==0);
    }
}
class Solution {
    /**
     * FUNCTION SINGATURE:
     * int compareVersions(String ver1, String ver2)
     * PURPOSE: the function takes in two strings, representing software versions as input,
     * it checks if these strings start with a '.', if yes, the '0' is being added to the string as the first character,
     * it also checks if the arrays are equal; if they are, the function returns result 0; if the strings are not identical,
     * resulting strings are converted into arrays and checked if the last element of the array is a "0",
     * if yes the function removes it (the last array's element). Then the resulting arrays are passed
     * to the function compareArrays, which returns the resulting value.
     * //@param String ver1, String ver2
     * @return int output: 0 if the versions are the same, 1 if the first version is newer, -1 if the 2nd version is newer.
     */
    public int compareVersions(String ver1, String ver2) {
        int result;
        String v1 = ver1;
        String v2 = ver2;
        if (ver1.charAt(0) == '.'){
            v1 = '0' + v1;
        }
        if (ver2.charAt(0) == '.'){
            v2 = '0' + v2;
        }
        if (ver1.equals(ver2)){
            return 0;
        }
        String[] arr1 = v1.split("\\.");
        String[] arr2 = v2.split("\\.");
        int len1 = arr1.length;
        int len2 = arr2.length;

        if (arr1[len1 - 1].equals("0")){
            arr1 = Arrays.copyOf(arr1, len1 - 1);
            len1 = arr1.length;
        } else if(arr2[len2 - 1].equals("0")){
            arr2 = Arrays.copyOf(arr2, len2 - 1);
            len2 = arr2.length;
        }
        if (len1 <= len2){
            result = compareArrays(arr1, arr2);
        } else{
            result = compareArrays(arr1, arr2);
        }
        return result;
    }

    /**
     * FUNCTION SINGATURE:
     * int compareArrays(String[] array1, String[] array2)
     * PURPOSE: the function takes in two arrays of strings, compares their lengths and assign the resulting value
     * based on the length. It also determines the smallest array's length. After, the function goes through each element
     * of both arrays starting with the 1st, and compares them converting to integers. If one of the arrays' elements
     * is bigger than other, the function returns resulting integer.
     * //@param String[] array1, String[] array2
     * @return int output: 0 if arrays are the same, 1 if first array's elements are greater, -1 if the 2nd array's elements are greater.
     */
    public int compareArrays(String[] array1, String[] array2) {
        int num1;
        int num2;
        int smallerLength;
        int result;
        int length1 = array1.length;
        int length2 = array2.length;
        if (length1 < length2){
            smallerLength = length1;
            result = -1;
        } else if (length1 > length2){
            smallerLength = length2;
            result = 1;
        } else{
            result = 0;
            smallerLength = length1;
        }
        for (int i = 0; i < smallerLength; i++) {
            num1 = Integer.parseInt(array1[i]);
            num2 = Integer.parseInt(array2[i]);
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        return result;
    }

    }