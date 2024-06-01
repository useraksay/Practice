public class MaxProdSubArray {
    public static void main(String[] args) {
           int[] arr = new int[] {2, 3, -2, 4, 1, -1};
           int res = solve(arr);
           System.out.println(res);
    }

    public static int solve(int[] arr){
        int min_prod = arr[0];
        int max_prod = arr[0];
        int ans = max_prod;
        int n = arr.length;

        for(int i = 1; i < n; i++){
            int num = arr[i];
            int temp_max = Math.max(num, Math.max(num * max_prod, num * min_prod));
            min_prod = Math.min(num, Math.min(num*max_prod, num*min_prod));
            max_prod = temp_max;
            ans = Math.max(max_prod, ans);
        }
        return Math.max(ans, max_prod);
    }
}
