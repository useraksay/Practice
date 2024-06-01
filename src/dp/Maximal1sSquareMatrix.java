package dp;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Maximal1sSquareMatrix {
    public static void main(String[] args) {

    }

    public static int findLargestSquareSizeByDP(List<List<Integer>> samples) {
        if(samples == null) return 0;
        if(samples.size() == 0) return 0;
        // Write your code here
        int rows = samples.size();
        int cols = samples.get(0).size();
        int[][] mat = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                mat[i][j] = samples.get(i).get(j);
            }
        }

        int[][] dp = new int[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                dp[i][j] = mat[i][j];
                if (i > 0 && j > 0 && mat[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }

                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    public static int findLargestSquareByRecursion(int[][] mat, int m, int n,
                                        AtomicInteger maxsize) {
        // base condition
        if (m < 0 || n < 0) {
            return 0;
        }

        // find the largest square matrix ending at mat[m][n-1]
        int left = findLargestSquareByRecursion(mat, m, n - 1, maxsize);

        // find the largest square matrix ending at mat[m-1][n]
        int top = findLargestSquareByRecursion(mat, m - 1, n, maxsize);

        // find the largest square matrix ending at mat[m-1][n-1]
        int diagonal = findLargestSquareByRecursion(mat, m - 1, n - 1, maxsize);

        /* The largest square matrix ending at mat[m][n] will be 1 plus
            minimum of largest square matrix ending at mat[m][n-1],
            mat[m-1][n] and mat[m-1][n-1] */

        int size = 0;
        if (mat[m][n] != 0) {
            size = 1 + Integer.min(Integer.min(top, left), diagonal);
        }

        // update maximum size found so far
        maxsize.set(Integer.max(maxsize.get(), size));

        // return the size of the largest square matrix ending at mat[m][n]
        return size;
    }

}
