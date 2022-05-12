import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CompareAndSort {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> solve(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> b) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Long> prefixSum = new ArrayList<>();
        HashMap<Integer, Long> hash = new HashMap<>();
        generateHash(a, hash);
        prefixSum.add(hash.get(a.get(0)));

        for(int i = 1; i < a.size(); i++){
            prefixSum.add(prefixSum.get(i - 1) + hash.get(a.get(i)));
        }

        for (int i = 0; i < b.size(); i++){
            long val1 = prefixSum.get(b.get(i).get(1)) - ((b.get(i).get(0) > 0) ? (prefixSum.get(b.get(i).get(0) - 1)) : 0L);
            long val2 = prefixSum.get(b.get(i).get(3)) - ((b.get(i).get(2) > 0) ? (prefixSum.get(b.get(i).get(2) - 1)) : 0L);
            ans.add((val1 == val2) ? 1 : 0);
        }
        return ans;
    }

    private static void generateHash(ArrayList<Integer> a, HashMap<Integer, Long> hash) {
        for (int i = 0; i < a.size(); i++){
            Random random = new Random();
            hash.put(a.get(i), random.nextLong());
        }
    }
}
