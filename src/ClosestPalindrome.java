public class ClosestPalindrome {
    public static void solve(String A){
        int n = A.length();
        String ans = "NO";
        int i = 0, j = n - 1;
        int misMatch = 0;
        while(i <= j){
            if(A.charAt(i) != A.charAt(j)){
                misMatch++;
            }
            i++;
            j--;
        }
        if(n % 2 == 1){
            if(misMatch == 1 || misMatch == 0) {
                ans = "YES";
            }
        }else{
            if(misMatch == 1) {
                ans = "YES";
            }
        }
        System.out.println(ans);
    }
}
