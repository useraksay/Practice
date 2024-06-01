import java.util.Stack;

public class PassingGameScaler {
    public static void main(String[] args) {

    }

    private static int solve(int A, int B, int[] C) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(B);
        for (int i = 0; i < A; i++){
            if(C[i] > 0){
                stack.push(C[i]);
            }else {
                stack.pop();
            }
        }
        ans = stack.peek();
        return ans;
    }
}
