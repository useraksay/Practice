/*
*Given a string containing only R and L.
*Find the number of balanced substrings(equal number of L’s and R’s) you will encounter
*where you can traverse only in the left-right direction.
*
* RLRRLLRLRL  Answer: 4 (RL, RRLL, RL, RL)
* LLLLRRRR  Answer:1 (LLLLRRRR)
* RLLLLRRRLR  Answer:3 (RL, LLLRRR, LR)
* */
public class LRBalanceWalmart {
    public static void main(String[] args) {
        System.out.println(solve("RLRRLLRLRL"));
        System.out.println(solve("LLLLRRRR"));
        System.out.println(solve("RLLLLRRRLR"));
    }

    private static int solve(String str){
        int ans = 0;
        char[] arr = str.toCharArray();
        int n = arr.length;
        int bal = 0;

        for (int i = 0; i < n; i++){
             char c = arr[i];
             if(c == 'L'){
                bal -= 1;
             }else if(c == 'R'){
                bal += 1;
             }

             if(bal == 0){
                 ans++;
             }
        }
        return ans;
    }
}
