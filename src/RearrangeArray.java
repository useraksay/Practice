public class RearrangeArray {
    public static void solve(int[] arr) {
        //[3 2 0 1]
        //[1 0 3 2]
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int curr_num = arr[i];
            int new_num = arr[curr_num];
            arr[i] = (curr_num) + ((new_num % n) * n);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
            System.out.print(arr[i]);
        }
    }
}
