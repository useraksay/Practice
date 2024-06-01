import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 8;
        String[][] ans = solveNQueens(n);
        for (int i = 0; i < ans.length; i++){
            for (int j = 0; j < ans[0].length; j++){
                System.out.println(ans[i][j]);
            }
        }
    }

    private static String[][] solveNQueens(int A) {
        int n = A;
        int[] cols = new int[n];
        int[] leftDiagonal = new int[(2 * n)];
        int[] rightDiagonal = new int[(2 * n)];
        int[][] matrix = new int[n][n];
        int index = 0;
        List<String[]> solutions = new ArrayList<String[]>();
        // call recursive function
        nQueens(index, cols, leftDiagonal, rightDiagonal, matrix, n, solutions);

        if(solutions.size() == 0) {
            return new String[0][0];
        }
        // convert list to an array
        String[][] output = new String[solutions.size()][n];
        for (int i = 0; i < solutions.size(); i++) {
            String[] strArray = solutions.get(i);
            for (int j = 0; j < strArray.length; j++) {
                String row = strArray[j];
                output[i][j] = row;
            }
        }
        return output;
    }

    private static void nQueens(int index, int[] cols, int[] leftDiagonal, int[] rightDiagonal,
                         int[][] matrix, int n,
                         List<String[]> solutions) {

        if (index == n) {
            // we have successfully placed the n queens
            String[] currentSolution = new String[n];
            for (int i = 0; i < n; i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1) {
                        temp.append('Q');
                    } else {
                        temp.append('.');
                    }
                }
                currentSolution[i] = temp.toString();
            }
            solutions.add(currentSolution);
            return;
        }

        // each row has n possibilities to place queen
        for (int j = 0; j < cols.length; j++) {

            if (cols[j] == 1 || leftDiagonal[n + index - j] == 1 || rightDiagonal[index + j] == 1) {
                // we can no further place queens in current column, check for next available
                // column
                continue;
            }

            // mark the current column, leftDiagonal and rightDiagonal as visited
            cols[j] = 1;
            leftDiagonal[n + index - j] = 1;
            rightDiagonal[index + j] = 1;
            matrix[index][j] = 1;

            // place the queen for next row
            nQueens(index + 1, cols, leftDiagonal, rightDiagonal, matrix, n, solutions);

            // revert the states of current column, leftDiagonal and rightDiagonal
            cols[j] = 0;
            leftDiagonal[n + index - j] = 0;
            rightDiagonal[index + j] = 0;
            matrix[index][j] = 0;
        }
    }
}
