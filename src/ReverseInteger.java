public class ReverseInteger {
    public static int solve(int a){
        int ans = 0;
        while(a != 0){
            int d = a % 10;
            ans = ans * 10 + d;
            a /= 10;
        }
        System.out.print(ans);
        return ans;
    }
}
