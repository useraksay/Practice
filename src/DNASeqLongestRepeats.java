public class DNASeqLongestRepeats {
    public static void main(String[] args) {
        String seq = "ATT";
        System.out.println(solve(seq));
    }


    public static int solve(String a){
        int n = a.length();
        int ans = 0;
        int count = 0;
        char ch = a.charAt(0);

        for (int i = 0; i < n; i++){
            if(a.charAt(i) == ch){
                count++;
                ans = Math.max(ans, count);
            }else{
                ch = a.charAt(i);
                count = 1;
            }
        }

        return ans;
    }
}
