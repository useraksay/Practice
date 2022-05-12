public class AnotherRecurrenceProblem {
    public static void main(String[] args) {
        int a = 3;
        int res = solve(a);
        System.out.println(res);
    }

    private static int solve(int a){
        if(a == 0) return 1;
        if(a == 1) return 1;
        if(a == 2) return 2;

        return solve(a - 1) + solve(a - 2) + solve(a - 3) + a;
    }
}
