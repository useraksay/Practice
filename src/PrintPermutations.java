public class PrintPermutations {
    public static void main(String[] args) {
        printPermutation("ABCD", "");
    }

    public static void printPermutation(String str, String ans){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        int n = str.length();
        for (int i = 0; i < n; i++){
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            ans = ans + ch;
            printPermutation(left + right, ans);
            ans = ans.substring(0, ans.length() - 1);
        }
    }
}
