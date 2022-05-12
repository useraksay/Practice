import java.util.ArrayList;
import java.util.HashMap;

public class SubArraySumZero {
    /*Check whether any sub array has sum zero*/
    public static boolean solve(ArrayList<Integer> A){
        boolean ans = false;
        int n = A.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += A.get(i);
            if(sum == 0) return true;
            if(map.containsKey(sum)){
                return true;
            }else {
                map.put(sum, i);
            }
        }

        return ans;
    }
}
