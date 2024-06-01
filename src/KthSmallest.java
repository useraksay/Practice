public class KthSmallest {
    public static int solve(final int[] A, int B){
        int len = A.length;
        int swapCnt = 0;
        for(int i = 0; i < len; i++){
            int j = i + 1;
            int min = Integer.MAX_VALUE;
            int min_idx = i;
            while(j < len && swapCnt <= B){
                if(A[j] < min){
                   min = A[j];
                   min_idx = j;
                }
                j++;
            }
            //swap
            if(A[i] > min){
                int tmp = A[i];
                A[i] = min;
                A[min_idx] = tmp;
                swapCnt++;
            }
        }
        return A[B - 1];
    }
}
