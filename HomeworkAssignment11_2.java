import java.util.Vector;
public class HomeworkAssignment11_2 {
    public static void main(String args[]) {
        Solution sol = new Solution();
        Vector v = new Vector();
        v.add(9);
        v.add(9);
        v.add(9);
        v.add(9);
        System.out.println(sol.plusPlusN(v)); // [1, 0, 0, 0, 0]
    }
}

class Solution {
    /**
     * MEMBER FUNCTION NAME:
     * Vector plusPlusN(Vector v)
     * PURPOSE:
     * The function performs pre-increment operation (++i) for the integer, represented by the given input vector
     * Example: [9, 9, 9] returns [1, 0, 0, 0]. Can be used for big numbers.
     * PARAMETER:
     * Vector plusPlusN(Vector v)
     * RETURN VALUE:
     * Vector v after ++i incremention
     **/
    Vector plusPlusN(Vector v) {
        for (int i = v.size()-1; i >= 0; i--){
            int temp = (Integer) v.get(i);
            if (temp < 9){
                v.set(i, temp + 1);
                break;
            } else if(i == 0 && temp == 9){
                v.set(i, 0);
                v.add(0, 1);
            } else{
                v.set(i, 0);
            }
        }
        return v;
    }
};
