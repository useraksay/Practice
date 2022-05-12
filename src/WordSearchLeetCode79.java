/*
* Given an m x n grid of characters board and a string word, return true if word exists in the grid.
* The word can be constructed from letters of sequentially adjacent cells,
* where adjacent cells are horizontally or vertically neighboring.
* The same letter cell may not be used more than once.
*
* leetcode.com/problems/word-search/discuss/279279/Java-Simple-with-Explanation!
* */
public class WordSearchLeetCode79 {
    public static void main(String[] args) {
//        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = new char[][]{{'A', 'A'}, {'a', 'a'}};
        String word = "Aa";

        boolean ans = exists(board, word);
        System.out.println(ans);

    }

    private static boolean exists(char[][] board, String word) {
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                if(board[row][col] == word.charAt(0)){
                    StringBuilder ans = new StringBuilder();
                    if(dfs(board, word, row, col, ans)){
                       return true;
                    }
                }
            }
        }
        return false;
    }


    /*
    * make a choice
    * recursively solve smaller/next problem
    * if next problem leads to answer return true
    * else backtrack
    * */
    private static boolean dfs(char[][] board, String word, int row, int col, StringBuilder ans){
        if(word.equals(ans.toString())){
            return true;
        }


        //Check for edge cases
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '0'){
            return false;
        }

        //check for the so far accumulated ans string matches with the word
        // if not return false
        for (int i = 0; i < ans.length(); i++){
            if(ans.charAt(i) != word.charAt(i)){
                return false;
            }
        }

        /*
        * we have row & col index, recurse to the left, right, top, bottom
        * but keep the record of visited indexes to avoid duplicate traversal
        * */


        //append before marking as seen
        ans.append(board[row][col]);

        /*set this board position to seen. (Because we can use this position) */
        char tmp = board[row][col];
        board[row][col] = '0';

        // recursively solve for left, right, top, bottom

        if(dfs(board, word, row, col + 1,  ans)
            || dfs(board, word, row, col - 1, ans)
            || dfs(board, word, row + 1, col, ans)
            || dfs(board, word, row - 1, col, ans)){
            return true;
        }

        //backtrack
        ans.deleteCharAt(ans.length() - 1);
        board[row][col] = tmp;

        return false;
    }
}
