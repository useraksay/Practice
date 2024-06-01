import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
    public static int solve(String A){
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int n = A.length();
        int ans = 0;
        while(i < n && j < n){
            char ch = A.charAt(j);
            if(!set.contains(ch)){
               set.add(ch);
               ans = Math.max(ans, j - i + 1);
               j++;
            }else {
               while(A.charAt(i) != ch){
                     set.remove(A.charAt(i));
                     i++;
               }
               set.remove(A.charAt(i++));
               set.add(ch);
               ans = Math.max(ans, j - i + 1);
               j++;
            }
        }
//        System.out.println(ans);
        return ans;
    }
}
