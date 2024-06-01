import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PerfectCards {
    public static String solve(ArrayList<Integer> A){
        int n = A.size();
        String ans = "LOSE";
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        }

        if(map.size() > 2 || map.size() < 2) return ans;

        HashSet<Integer> set = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            set.add(entry.getValue());
        }
        if(set.size() > 1){
            ans = "LOSE";
        }else {
            ans = "WIN";
        }
        System.out.println(ans);
        return ans;
    }
}
