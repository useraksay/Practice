/*
* Given an unsorted array of n integers that can contain integers from 1 to n.
* Some elements can be repeated multiple times and some other elements can be absent from the array. Count the frequency of all elements that are present and print the missing elements.
* */

public class CountFrequency {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 3, 5};
        solve(arr);
    }

    public static void solve(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
             arr[i] = arr[i] - 1;
        }

        for (int i = 0; i < n; i++){
             int index = arr[i] % n;
             arr[index] = arr[index] + n;
        }

        for (int i = 0; i < n; i++){
             System.out.println(i + 1 + "::" + arr[i]/n);
        }
        System.out.println(arr);
    }
}
