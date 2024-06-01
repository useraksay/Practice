import java.util.ArrayList;

public class SelectionSort {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            int min_index = findMinIndex(A, i);
            ans.add(min_index);
            if(i != min_index) {
                swap(A, i, min_index);
            }
        }
        //System.out.println(ans);
        ans.remove(ans.size() - 1);
        return ans;
    }

    public static void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    public static int findMinIndex(ArrayList<Integer> A, int start) {
        int min_index = start;
        ++start;

        while(start < A.size()) {
            if(A.get(start) < A.get(min_index))
                min_index = start;

            ++start;
        }

        return min_index;
    }

}
