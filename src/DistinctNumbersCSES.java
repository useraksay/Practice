import java.util.Arrays;

public class DistinctNumbersCSES {
    public static void main(String[] args) {
            int[] arr = new int[]{2, 3, 2, 3, 2};
            int ans = solve(arr);
            System.out.println(ans);
    }

    public static int solve(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int ans = 1;
        for (int i = 1; i < n; i++){
            if(arr[i] != arr[i - 1]){
                ans++;
            }
        }
        return ans;
    }
}
