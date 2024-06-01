public class CircularArrayLoopLC457 {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 1, 2, 1, 2};
//        int[] arr = new int[]{2, -1, 1, 2, -1};
        int[] arr = new int[]{-8,-1,1,7,2};
//        int[] arr = new int[]{-1, 2};
        System.out.println(isCircularLoop(arr));
    }

    private static boolean isCircularLoop(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++){
            //iterate through each element and check if it leads to valid cycle
            if(nums[i] == 0) continue;

            int slow_index = i;
            int fast_index = i;
            boolean isForward = nums[i] > 0;

            while (true){
                slow_index = getNextIndex(nums, slow_index, isForward);

                if(slow_index == -1) break; //indicates there is cycle in reverse direction.

                fast_index = getNextIndex(nums, fast_index, isForward);
                //fast pointer will touch every element that slow pointer touches
                if(fast_index == -1) break; //indicates there is cycle in reverse direction.

                if(fast_index != -1){
                   fast_index = getNextIndex(nums, fast_index, isForward);
                }

                if(fast_index == slow_index) return true;

            }
        }
        return false;
    }

    private static int getNextIndex(int[] nums, int index, boolean isForward){
        int n = nums.length;

        if(isForward != (nums[index] > 0)){
           return -1;
        }

        int nextIndex = (index + nums[index] + n) % n;
        if(nextIndex < 0){
            nextIndex += n;
        }
        //handles single element loop
        if(index == nextIndex){
           return -1;
        }

        return nextIndex;
    }

}
