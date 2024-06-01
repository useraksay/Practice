import java.util.ArrayList;

public class Sixlets {
    //global variable to store answer
    public static int ans = 0;
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(17);
        list.add(1000);
        list.add(8);
        int b = 3;
        int res = findSixlet(list, b);
        ans = 0;
        System.out.println(res);
    }

    private static int findSixlet(ArrayList<Integer> list, int b) {
        int sum = 0;
        int count = 0;
        int idx = 0;
        solve(list, b, sum, count, idx);
        return ans;
    }

    private static void solve(ArrayList<Integer> list, int b, int sum, int count, int idx) {
        if(sum > 1000) return;
        if(count == b){
           ans = ans + 1;
           return;
        }
        if(idx == list.size()) return;

        solve(list, b, sum + list.get(idx), count + 1, idx + 1);
        solve(list, b, sum, count, idx + 1);
    }

}
