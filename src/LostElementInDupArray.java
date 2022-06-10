public class LostElementInDupArray {
    public static void main(String[] args) {
//        arr1 = 4, 6, 8, 10
//        arr2 = 1, 4, 6, 8, 10
//        ans = 1

//        arr1 = 4, 6, 8, 10
//        arr2 = 4, 6, 8, 10, 12
//        ans = 12

//        Approach: do binary search TC:O(log(n))
//        do xor for unsorted array & unsorted TC:O(n)
    }

    private static int solve(int[] arr1, int[] arr2){
        int m = arr1.length;
        int n = arr2.length;

        int low = 0, high = 0;

        if(m > n){
           high = arr1.length - 1;
        }else {
           high = arr2.length - 1;
        }

        while (low <= high){
               int mid = (low + high) / 2;

            if(arr1[mid] != arr2[mid]){
               // element lies in left half of bigger array
               high = mid - 1;
            }else {
               // element lies in right half of bigger array
                low = mid + 1;
            }
        }
        return high;
    }
}
