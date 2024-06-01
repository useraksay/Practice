import java.util.ArrayList;

public class SubsetSumPrblm {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 7, 4};
        int k = 11;
        solve(nums, k);
    }

    public static void solve(int[] nums, int k){
        int idx = 0;
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        getSubSet(nums, k, idx, sum, list);
    }

    private static void getSubSet(int[] nums, int k, int i, int sum, ArrayList<Integer> list) {
//        if(sum > k) return;
        if(i == nums.length){
            System.out.println("subset " + list); //print all subsets
            if(sum == k){
                System.out.println("subset with sum = " + k + " " + list);
            }
            return;
        }

    /*     If I choose to include the num at index i
              sum = sum + nums[i]
              add nums[i] to the list
              call recursively for i + 1 index
         If not choose to include the num at index i
              sum = sum + 0
              not add nums[i] to the list
              call recursively for i + 1 index

         If recursive call leads to solution: continue
         Else
              Backtrack     */

        sum = sum + nums[i];
        list.add(nums[i]);
        getSubSet(nums, k, i + 1, sum, list);

        sum = sum - nums[i];
        list.remove(list.size() - 1);
        getSubSet(nums, k, i  + 1, sum, list);
    }


}
