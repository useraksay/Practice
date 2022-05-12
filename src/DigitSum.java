public class DigitSum {
    public static int solve(int A){
        return (A - 1) % 9 + 1;

        /*if(A == 0) return 0;

        return (A % 10) + solve(A/10);*/
    }
}
