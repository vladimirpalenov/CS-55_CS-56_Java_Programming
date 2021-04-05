public class HomeworkAssignment12_1 {
    public static void main(String args[]) {
        Solution sol = new Solution();
        System.out.println(sol.getTotalWaterAmount(new int[]{5,2,1,2,1,5})==14);
        System.out.println(sol.getTotalWaterAmount(new int[]{0,1,0})==0);
        System.out.println(sol.getTotalWaterAmount(new int[]{10,1,3})==2);
        System.out.println(sol.getTotalWaterAmount(new int[]{9,1,11})==8);
        System.out.println(sol.getTotalWaterAmount(new int[]{10, 20, 30 , 40, 42, 40, 30, 20, 40, 50, 55, 50, 40, 30, 20, 10, 3})==38);
        System.out.println(sol.getTotalWaterAmount(new int[]{1,2,3,4,5,6,5,4,3,6,22,3,2})==6);
        System.out.println(sol.getTotalWaterAmount(new int[]{0,1,2,5,4,2,6,4,3,2,1,1,1,1,1,1,8})==43);
        System.out.println(sol.getTotalWaterAmount(new int[]{5, 4, 1, 2})==1);
        System.out.println(sol.getTotalWaterAmount(new int[]{9})==0);
        System.out.println(sol.getTotalWaterAmount(new int[]{9,1})==0);
        System.out.println(sol.getTotalWaterAmount(new int[]{9,1,2,8,0,100,2,3,100,0,5})==225);

    }
}

class Solution {
    /**
     * MEMBER FUNCTION NAME:
     * getTotalWaterAmount(int[] arr)
     * PURPOSE:
     * The function takes in a pointer reference to an array of any arbitrary
     * elevation and its array size, and outputs the total amount of water
     * retention in that given terrain
     * Example: [9, 1, 7] returns 6.
     * PARAMETER:
     * int[] arr
     * RETURN VALUE:
     * int value of the total volume of water retention.
     **/
    int getTotalWaterAmount(int[] arr) {
        int volume = 0;
        int maxElevation = arr[0];;
        int maxElevationIndex = 0;
        boolean downSlope = false;
        int currentMaxElevation;
        int localVolume = 0;
        if (arr.length == 1 || arr.length == 2){
            return volume;
        }
        for (int count = 0; count < arr.length; count++){
            if (arr[count] > maxElevation){
                maxElevation = arr[count];
                maxElevationIndex = count;
            }
        }
        if (maxElevationIndex == 0){
            currentMaxElevation = arr[arr.length - 1];
            for (int a = arr.length - 2; a >= 0; a--){
                if (arr[a] >= currentMaxElevation && !downSlope){
                    currentMaxElevation = arr[a];
                } else if (arr[a] >= currentMaxElevation && downSlope){
                    volume += localVolume;
                    localVolume = 0;
                    downSlope = false;
                    currentMaxElevation = arr[a];
                } else if (arr[a] < currentMaxElevation && !downSlope){
                    downSlope = true;
                    localVolume = localVolume + currentMaxElevation - arr[a];
                } else if (arr[a] < currentMaxElevation && downSlope){
                    localVolume = localVolume + currentMaxElevation - arr[a];
                }
            }
        } else if (maxElevation == arr[arr.length-1]){
            currentMaxElevation = arr[0];
            for (int b = 1; b < arr.length; b++){
                if (arr[b] >= currentMaxElevation && !downSlope){
                    currentMaxElevation = arr[b];
                } else if (arr[b] >= currentMaxElevation && downSlope){
                    volume += localVolume;
                    localVolume = 0;
                    downSlope = false;
                    currentMaxElevation = arr[b];
                } else if (arr[b] < currentMaxElevation && !downSlope){
                    downSlope = true;
                    localVolume = localVolume + currentMaxElevation - arr[b];
                } else if (arr[b] < currentMaxElevation && downSlope){
                    localVolume += currentMaxElevation - arr[b];
                }
            }
        } else{
            currentMaxElevation = arr[arr.length - 1];
            for (int a = arr.length - 2; a >= maxElevationIndex; a--){
                if (arr[a] >= currentMaxElevation && !downSlope){
                    currentMaxElevation = arr[a];
                } else if (arr[a] >= currentMaxElevation && downSlope){
                    volume += localVolume;
                    localVolume = 0;
                    downSlope = false;
                    currentMaxElevation = arr[a];
                } else if (arr[a] < currentMaxElevation && !downSlope){
                    downSlope = true;
                    localVolume = localVolume + currentMaxElevation - arr[a];
                } else if (arr[a] < currentMaxElevation && downSlope){
                    localVolume = localVolume + currentMaxElevation - arr[a];
                }
            }
            currentMaxElevation = arr[0];
            for (int b = 1; b <= maxElevationIndex; b++){
                if (arr[b] >= currentMaxElevation && !downSlope){
                    currentMaxElevation = arr[b];
                } else if (arr[b] >= currentMaxElevation && downSlope){
                    volume += localVolume;
                    localVolume = 0;
                    downSlope = false;
                    currentMaxElevation = arr[b];
                } else if (arr[b] < currentMaxElevation && !downSlope){
                    downSlope = true;
                    localVolume = localVolume + currentMaxElevation - arr[b];
                } else if (arr[b] < currentMaxElevation && downSlope){
                    localVolume += currentMaxElevation - arr[b];
                }
            }
        }
        return volume;
    }
}
