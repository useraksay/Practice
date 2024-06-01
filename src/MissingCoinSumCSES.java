public class MissingCoinSumCSES {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5, 8, 10};
        int ans = solve(nums);
        System.out.println(ans);
    }
/*
* solve by Induction
* */
    public static int solve(int[] arr){
        int n = arr.length;
        int currSum = 0;
        if(arr[0] == 1){
           currSum = 1;
        }else {
           return 1;
        }
        int i = 1;
        while(i < n){
            if(arr[i] > currSum + 1){
               return currSum + 1;
            }else{
               currSum += arr[i];
            }
            i++;
        }

        if(i == n){
           currSum = currSum + 1;
        }

        return currSum;
    }

}
