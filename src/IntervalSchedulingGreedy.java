import java.util.Arrays;

public class IntervalSchedulingGreedy {
    public static void main(String[] args) {
        int[] start = new int[]{3, 4, 5, 8};
        int[] end = new int[]{5, 9, 8, 10}; // 5 8 9 10
        int res = solve(start, end);
        System.out.println(res);
    }

    public static int solve(int[] start, int[] end){
        int ans = 1;
        Arrays.sort(end);
        int j = 0;
        for (int i = 1; i < start.length; i++){
             if(start[i] >= end[j]){
                ans++;
                j++;
             }
        }
        return ans;
    }
}
