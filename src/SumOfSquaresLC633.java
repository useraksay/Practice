public class SumOfSquaresLC633 {
    public static void main(String[] args) {

    }

    private static boolean judgeSquareSum(int c){
        long n1 = 0, n2 = (long)Math.sqrt(c);
        while (n1 <= n2) {
            long cur = n1 * n1 + n2 * n2;
            if (cur == c) return true;
            if (cur < c) n1++;
            else n2--;
        }
        return false;
    }
}
