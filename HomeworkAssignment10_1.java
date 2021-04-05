import java.util.Vector;
public class HomeworkAssignment10_1 {
    public static void main(String args[]) {
        Solution sol = new Solution();
        Vector<Vector<Integer>> v = new Vector<Vector<Integer>>();
        v.add(0,new Vector<Integer>());
        v.get(0).add(0, 0);
        v.add(1,new Vector<Integer>());
        v.get(1).add(0, 4);
        v.get(1).add(1, 1);
        v.add(2,new Vector<Integer>());
        v.get(2).add(0, 5);
        v.get(2).add(1, 3);
        v.get(2).add(2, 8);
        v.add(3,new Vector<Integer>());
        v.get(3).add(0, 1);
        v.get(3).add(1, 6);
        v.get(3).add(2, 7);
        v.get(3).add(3, 3);
        System.out.println(v); // [[0], [4, 1], [5, 3, 8], [1, 6, 7, 3]]
        System.out.println(sol.getMaxPoints(v)); // 16
    }
}

class Solution {
    /**
     * MEMBER FUNCTION NAME:
     * int getMaxPoints(Vector<Vector<Integer>> maze)
     * PURPOSE:
     * The function calculates the biggest possible result in pinball game, where the ball falls from top to the bottom
     * and either get diverted to the Nth or (N+1)-th peg of the row below.
     * The function takes in a vector of vectors consisting of integers, and calculates the biggest sum possible.
     * PARAMETER:
     * Vector<Vector<Integer>> maze
     * RETURN VALUE:
     * int: the biggest sum of the integers a ball can hit
     **/
    int getMaxPoints(Vector<Vector<Integer>> maze) {
        if (maze.elementAt(0).size() == 0){
            return 0;
        }
        Integer tempSum = 0;

        for(int index = maze.size() - 1; index > 0; index--) {
            for (int i = 0; i < maze.elementAt(index).size()-1; i++){
                tempSum = maze.elementAt(index - 1).get(i) + Math.max(maze.get(index).get(i), maze.get(index).get(i + 1));
                maze.elementAt(index-1).set(i, tempSum);
            }
        }
        return maze.elementAt(0).get(0);
    }
}; 