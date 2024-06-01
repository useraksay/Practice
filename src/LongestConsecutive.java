import java.util.HashSet;
import java.util.List;

public class LongestConsecutive {
    public static int solve(final List<Integer> A){
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.size(); i++){
            set.add(A.get(i));
        }

        for (int i = 0; i < A.size(); i++){
            int num = A.get(i);
            int tempAns = 0;
            if(!set.contains(num - 1)){
               tempAns++;
               num = num + 1;
               while (set.contains(num)){
                   tempAns++;
                   num = num + 1;
               }
               ans = Math.max(ans, tempAns);
            }
        }

        return ans;
    }
}
