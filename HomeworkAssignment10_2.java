public class HomeworkAssignment10_2 {
    public static void main(String args[]) {
        Solution sol = new Solution();
        Node a = new Node("a1");
        a.next = new Node("a2");
        a.next.next = new Node("c1");
        a.next.next.next = new Node("c2");
        Node b = new Node("b1");
        b.next = new Node("b2");
        b.next.next = a.next.next;
        b.next.next.next = a.next.next.next;
        System.out.println(sol.getClosestCommonWaypoint(a,b)); 
    }
}
class Node {
    String label;
    Node next;
    Node(String label) {
        this.label = label;
    }
};

class Solution {
    /**
     * MEMBER FUNCTION NAME:
     * Node getClosestCommonWaypoint(Node A, Node B)
     * PURPOSE:
     * The function takes in two Node objects, (linked lists, representing waypoints) and finds the
     * closest common waypoint from any given two path input, Node A and Node B. If there is no common
     * point, the function returns null.
     * PARAMETER:
     * Node A, Node B
     * RETURN VALUE:
     * Node: the closest common waypoint, null if there is no common point.
     **/
    Node getClosestCommonWaypoint(Node A, Node B) {

        for( ; A != null; A = A.next){
            for(Node C = B; C != null; C=C.next){
                if(A.label.equals(C.label)){
                    return A;
                }
            }
        }
    return null;
    }
};