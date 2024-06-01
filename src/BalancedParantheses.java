import java.util.ArrayList;

public class BalancedParantheses {
    public static void main(String[] args) {
        int n = 3;
        int o = n, c = n;
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder("");
        solve(n, o, c, s, ans);
        System.out.println(ans);
    }

    public static void solve(int n, int o, int c, StringBuilder s, ArrayList<String> ans){
        if(o == 0 && c == 0){
            ans.add(s.toString());
            return;
        }

        if(o > c){
           //leads to invalid parantheses
           return;
        }

        if(o > 0){
           s.append('(');
           solve(n,o - 1, c, s, ans);
               if(s.length() > 0){
                  s.deleteCharAt(s.length() - 1);
               }
        }

        s.append(')');
        solve(n, o,c - 1, s, ans);
        if(s.length() > 0)
           s.deleteCharAt(s.length() - 1);
        return;
    }

    public static void solve2(int n, int open, int close, StringBuilder sb, ArrayList<String> ans){
        if(open == n && close == n){
            //System.out.print(sb.toString());
            ans.add(sb.toString());
            return;
        }

        if(open < close) return; // invalid parantheses

        //choose open braces & recurse
        if(open < n){
            sb.append('(');
            solve2(n, open + 1, close, sb, ans);
            if(sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);

        }

        //not choose open brace instead choose closed brace and recurse
        sb.append(')');
        solve2(n, open, close + 1, sb, ans);
        if(sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);

        return;
    }
}
