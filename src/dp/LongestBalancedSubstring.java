package dp;

import java.util.Stack;

public class LongestBalancedSubstring {
    public static void main(String[] args) {
        String s = new String("([[]]()}[");
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++){
            /*if(s.charAt(i) == '{' || s.charAt(i) == '['){
               sb.append('(');
            }else if(s.charAt(i) == '}' || s.charAt(i) == ']'){
                sb.append(')');
            }else{
                sb.append(s.charAt(i));
            }*/
        }
        System.out.println(LBSlengthDP(sb.toString()));
        System.out.println(LBSlength(sb.toString()));
    }

    private static int LBSlengthDP(final String str) {
        char[] s = str.toCharArray();
        int ans = 0;
        int n = s.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if ((s[i] == ')' && i - dp[i - 1] - 1 >= 0 && s[i - dp[i - 1] - 1] == '(') || (s[i] == '}' && i - dp[i - 1] - 1 >= 0 && s[i - dp[i - 1] - 1] == '{') || (s[i] == ']' && i - dp[i - 1] - 1 >= 0 && s[i - dp[i - 1] - 1] == '[')) {
                dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2 >= 0)
                        ? dp[i - dp[i - 1] - 2]: 0);
                ans = Math.max(dp[i], ans);
            }
        }
        return ans;
    }

    private static int LBSlength(final String str){
        char[] s = str.toCharArray();
        int ans = 0;
        int n = s.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            char bracket = s[i];
            if(!stack.isEmpty() && isOppositeParantheses(bracket, s[stack.peek()])){
                stack.pop();
                ans = ans + 2;
            }else {
                stack.push(i);
            }
        }
        return ans;
    }

    private static boolean isOppositeParantheses(char bracket, char c) {
        return (bracket == ')' && c == '(') || (bracket == '}' && c == '{') || (bracket == ']' && c == '[');
    }
}
