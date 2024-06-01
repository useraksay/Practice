public class RotateArrayLC189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotateArray(nums, k);
    }

    private static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(n > 1){
           reverse(nums, 0, nums.length - 1);
           reverse(nums, 0, k - 1);
           reverse(nums, k, nums.length - 1);
        }
         printNums(nums);
    }



    private static void reverse(int[] nums, int i, int j) {
        while(i < j) swap(nums, i++, j--);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void printNums(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++){
            System.out.print(" " + nums[i] + " ");
        }
        System.out.print("]\n");
    }

}
