import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum2 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(7);
        nums.add(4);
        int target = 7;
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        combinationSum(nums, 0, list, target, ans);
        System.out.println(ans);
    }

    private static void combinationSum(ArrayList<Integer> candidates, int index, ArrayList<Integer> list, int sum, ArrayList<ArrayList<Integer>> ans){
        if(sum == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(sum < 0 || index == candidates.size()){
            return;
        }

        for (int i = index; i < candidates.size(); i++){
            if (i > index && candidates.get(i).equals(candidates.get(i - 1))) {
                continue;
            }
            list.add(candidates.get(i));
            combinationSum(candidates, i + 1, list, sum - candidates.get(i), ans);
            list.remove(list.size() - 1);
        }
    }
}
