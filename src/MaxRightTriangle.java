import java.util.ArrayList;
import java.util.HashMap;

public class MaxRightTriangle {
    public static void main(String[] args) {

    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B){
        long mod = (long) (1e9 + 7);
        HashMap<Integer, Integer> mx = new HashMap<>();
        HashMap<Integer, Integer> my = new HashMap<>();
        int n = A.size();
        long ans = 0;

        for (int i = 0; i < n; i++){
            mx.put(A.get(i), mx.getOrDefault(A.get(i), 0) + 1);
            my.put(B.get(i), my.getOrDefault(B.get(i), 0) + 1);
        }

        for (int i = 0; i < n; i++){
            int a = mx.get(A.get(i));
            int b = my.get(B.get(i));
            ans = ans + ((a - 1)*(b - 1) % mod) ;
        }
        return (int) ans;
    }
}
