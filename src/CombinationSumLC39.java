import java.util.ArrayList;

public class CombinationSumLC39 {
//    private static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
            int[] candidates = new int[]{2, 3, 6, 7};
            int target = 7;
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            combinationSum(candidates, 0, list, target, ans);
            System.out.println(ans);
            //To solve for not allowing duplicates - sort candidates array and remove duplicates
    }

    private static void combinationSum(int[] candidates, int index, ArrayList<Integer> list, int sum, ArrayList<ArrayList<Integer>> ans){
        if(sum == 0){
           System.out.println(list);
           ans.add(list);
           return;
        }

        if(sum < 0){
           return;
        }

        for (int i = index; i < candidates.length; i++){
             list.add(candidates[i]);
             combinationSum(candidates, i, list, sum - candidates[i], ans);
             list.remove(list.size() - 1);
        }

    }
}
