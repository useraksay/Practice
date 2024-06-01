/*
* leetcode.com/problems/search-in-rotated-sorted-array/submissions/
* */
public class SearchInRotatedSortedArr1 {
    public static void main(String[] args) {
//        int[] nums = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
        int[] nums = new int[]{7, 8, 1, 2, 3, 4, 5, 6};
//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 4;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target){
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 2);
            if(nums[mid] == target) return mid;
            //left sorted
            if(nums[left] <= nums[mid] && nums[right] < nums[mid]){
                if(target >= nums[mid] || target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            } else if(nums[left] > nums[mid] && nums[right] >= nums[mid]){ //right sorted
                if(target >= nums[left] || target <= nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else if(nums[left] <= nums[mid] &&  nums[right] >= nums[mid]){  // normally sorted
               /* if(nums[left] == target) return left;
                if(nums[right] == target) return right;
                if(nums[mid] == target) return mid;*/
                if(target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                break;
            }
        }
        return -1;
    }
}
