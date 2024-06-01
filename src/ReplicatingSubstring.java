import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

public class ReplicatingSubstring {
    public static int solve(int A, String B){
        int n = B.length();
        int ans = -1;
        if(A == 1) return 1;

        HashMap<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < n; i++){
            char ch = B.charAt(i);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < n; i++){
            char ch = B.charAt(i);
            if(charMap.get(ch) % A != 0){
                ans = -1;
                break;
            }
        }

        return ans;

    }
}
