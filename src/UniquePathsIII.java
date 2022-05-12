public class UniquePathsIII {
    private static int ans = 0;
    public static void main(String[] args) {

    }

    private static int solve(int[][] A){
        int rows = A.length;
        int cols = A[0].length;
        int zCnt = 0;
        int u = -1, v = -1;
        for (int i = 0; i < rows; i++){
             for (int j = 0; j < cols; j++){
                if(A[i][j] == 1){
                   u = i;
                   v = j;
                }else if(A[i][j] == 0){
                   zCnt = zCnt + 1;
                }
             }
        }
        if(u != -1 || v != -1) {
           boolean[][] visited = new boolean[rows][cols];
           dfs(u, v, zCnt + 1, A, visited);
        }
        return 0;
    }

    private static void dfs(int x, int y, int cnt, int[][] A, boolean[][] visited){
            if(!isValid(x, y, A, visited)){
                return;
            }
            if(A[x][y] == 2){
               if(cnt == 0) ans++;
               return;
            }

            visited[x][y] = true;
            // for a give row x and column y we can travel left, right, up, down.
            dfs(x, y - 1, cnt - 1, A, visited); // left
            dfs(x, y + 1, cnt - 1, A, visited); // right
            dfs(x - 1, y, cnt - 1, A, visited); // up
            dfs(x + 1, y, cnt - 1, A, visited); // down
            visited[x][y] = false;
    }

    private static boolean isValid(int x, int y, int[][] A, boolean[][] visited){
        return (0 <= x && x < A.length && 0 <= y && y < A[0].length && !visited[x][y]);
    }
}
