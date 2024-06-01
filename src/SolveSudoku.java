import java.util.ArrayList;

public class SolveSudoku {
    public static void main(String[] args) {
            int a = 9;
            char b = (char) (a + '0');
            System.out.println(b);
            ArrayList<ArrayList<Character>> board = new ArrayList<>();
            sudoku(board);
    }

    public static boolean sudoku(ArrayList<ArrayList<Character>> a){
        if(a.isEmpty()){
           return false;
        }

        int rows = a.size();
        int cols = a.get(0).size();
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                 Character ch = a.get(row).get(col);
                 if(ch != '.'){
                    continue;
                 }
                //Try to fill a number from 1 to 9
                for (int num = 1; num <= 9; num++){
                     if (isValidNum(a, row, col, num)) {
                        a.get(row).set(col, (char) (num + '0'));
                        //solve recursively
                        if(sudoku(a)){
                            // if sudoku is solved for the choices made so far
                            return true;
                        }
                        //else backtrack
                        a.get(row).set(col, '.');
                     }
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isValidNum(ArrayList<ArrayList<Character>> a, int row, int col, int num) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(row).get(i) == (char) (num + '0')) {
                return false;
            }
        }

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).get(col) == (char) (num + '0')) {
                return false;
            }
        }

        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (a.get(i).get(j) == (char) (num + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

}
