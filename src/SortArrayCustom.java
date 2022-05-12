import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SortArrayCustom {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B){
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < A.size(); i++){
            int num = A.get(i);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for (int i = 0; i < B.size(); i++){
            int num = B.get(i);
            int n = freq.getOrDefault(num, 0);
            while (n-- > 0) {
                ans.add(num);
            }

            // erase the element from the map
            freq.remove(num);
        }
        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            int count = entry.getValue();
            while (count-- > 0) {
                ans.add(entry.getKey());
            }
        }
//        System.out.println(ans);
        return ans;
    }
}
