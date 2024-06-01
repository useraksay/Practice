import java.util.Stack;

public class DailyTemparaturesLC739 {
    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperatures(temperatures);
    }
    //Based on decreasing monotonic stack
    private static int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                  int idx = stack.pop();
                  res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
}
