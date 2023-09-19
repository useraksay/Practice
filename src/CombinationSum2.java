import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


    private void dfs(int[] candidates, int index, List<Integer> currSet, int target, List<List<Integer>> result) {
        // good base case
        if (target == 0) {
            List<Integer> currCopy = new ArrayList<>(currSet);
            result.add(currCopy);
            return;
        }

        // bad base cases
        if (target < 0) {
            return;
        }

        if (index >= candidates.length) {
            return;
        }

        // two decisions: we can add this current number to our result
        // OR we can ignore this number and do a dfs for the next number
        currSet.add(candidates[index]);

        // this first branch will have all the subsets which contain this currently added number
        // we can add this number again so index is not changed
        dfs(candidates, index + 1, currSet, target - candidates[index], result);

        // backtrack
        currSet.remove(currSet.size() - 1);

        // skip duplicates
        //how it works ?
        //suppose we have an array (sorted by us) like [1, 1, 2, 6, 7, 10]
        //if our index is at 0 we have 1, we can include 1 and go on to include as many 1's
        // if we decide to exclude 1 from our answer list we skip all the 1's and move to index which is not 1.
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index += 1;
        }

        // second branch will have all the subsets which don't have this current number
        dfs(candidates, index + 1, currSet, target, result);
    }
}
