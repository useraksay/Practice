import java.util.ArrayDeque;
import java.util.Deque;
/*
* leetcode.com/problems/jump-game-vii/discuss/1224681/Python3-Thinking-process-no-DP-needed
* 2 <= s.length <= 105
* s[i] is either '0' or '1'
* s[0] == '0'
* 1 <= minJump <= maxJump < s.length
* */
public class JumpGame7LC {
    public static void main(String[] args) {
//        String s = "01001100";
//        String s = "01000000";
        String s = "00111010";
        int minJump = 3;
        int maxJump = 5;
        boolean res = canReach(s, minJump, maxJump);
        System.out.println(res);
    }
    //Below is O(n2) solution (BFS)
    private static boolean canReach(String s, int minJump, int maxJump){
        int len = s.length();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);

        while(!deque.isEmpty()){
            int currIndex = deque.pop();

            if(currIndex == len - 1) return true;

            //put indexes from currIndex + minJump to currIndex + maxJump into queue
            int start = currIndex + minJump;
            int end = currIndex + maxJump;
            if(start < len){
               for (int i = start; i <= Math.min(end, len - 1); i++){
                    if(s.charAt(i) == '0'){
                       deque.add(i);
                    }
               }
            }
        }
        return false;
    }
}
