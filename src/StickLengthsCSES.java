import java.util.Arrays;

public class StickLengthsCSES {
    public static void main(String[] args) {
            int[] arr = new int[]{1, 1, 1, 3, 2, 5, 5, 5, 9};
//            int[] arr = new int[]{1, 2, 3};
            int res;
//            res = solveByBinarySearch(arr);
            res = solveByMedian(arr);
            System.out.println(res);
    }

    public static int solveByBinarySearch(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = low + ((high - low) / 2);
            int cost = findCost(arr[mid], arr);
            if(cost < ans){
               ans = cost;
               high = mid - 1;
            }else{
               low = mid + 1;
            }

        }
        return ans;
    }

    public static int solveByMedian(int[] arr){
        int cost = 0;
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++){
            cost += Math.abs(arr[i] - arr[n/2]);
        }

        return cost;
    }


    private static int findCost(int mid, int[] arr){
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++){
             sum = sum + Math.abs(mid - arr[i]);
        }
        return sum;
    }



}
