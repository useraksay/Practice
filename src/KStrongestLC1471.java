import java.util.Arrays;
/*
* leetcode.com/problems/the-k-strongest-values-in-an-array/discuss/674346/Learn-randomized-algorithm-today-which-solves-this-problem-in-O(n).
* */
public class KStrongestLC1471 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int k = 2;
        getStrongest(arr, k);
    }

    private static int[] getStrongest(int[] arr, int k){
        int n = arr.length;
        Arrays.sort(arr);
        int median = arr[(n - 1)/2];

        int i = 0, j = n - 1, l = 0;
        int[] res = new int[k];
        while(l < k){
            if(Math.abs(arr[i] - median) > Math.abs(arr[j] - median)){
                res[l++] = arr[i++];
            }else {
                res[l++] = arr[j--];
            }
        }
        return res;
    }
}
