import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 4, 7, 7};
        int[] result = kMostFrequent(arr, 2);

        for(int elem : result) {
            System.out.print(elem + " ");
        }
    }

    private static int[] kMostFrequent(int[] nums, int k) {
        //Map which stores number and it's occurrence count
        Map<Integer, Integer> countMap = new HashMap<>();

        //Variable which stores maximum frequency of any number
        int maxFreq = 0;

        //Traverse an array
        for(int i = 0; i < nums.length; i++) {
            int freq = countMap.getOrDefault(nums[i],0) + 1;
            countMap.put(nums[i], freq);

            //keep track of maximum occurrence
            maxFreq = Math.max(maxFreq, freq);
        }

        //Declare a bucket, which store multiple values
        List<Integer>[] bucket = new ArrayList[maxFreq + 1];

        for(int n : countMap.keySet()) {
            int freq = countMap.get(n);

            if(bucket[freq] == null)
               bucket[freq] = new ArrayList<>();

            bucket[freq].add(n);
        }

        int[] resultArr = new int[k];
        int count = 0;

        //Pick top k elements
        for(int i = bucket.length-1; i >= 0; i--) {
            if(bucket[i]!=null){
                for (int n : bucket[i]) {
                    resultArr[count++] = n;

                    if (count == k)
                        return resultArr;
                }
            }
        }

        return resultArr;
    }
}


