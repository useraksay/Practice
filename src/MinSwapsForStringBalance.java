/*
* https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/discuss/1390811/Clear-Explanation-oror-C%2B%2B-oror-Greedy-oror-Detailed-Explanation
* https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/discuss/1390193/Python-Greedy-O(n)-explained
* https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/discuss/1393432/C%2B%2B-Simple-Intuitive-Solution-With-Explanation-O(n)-TC-O(1)-SC
* */
public class MinSwapsForStringBalance {
    public static void main(String[] args) {
        String s = "[]]][[][";
        System.out.println(minSwaps(s));
    }

    private static int minSwaps(String s){
        int n = s.length();
        int ans = 0;
        int open = n / 2;
        int close = n / 2;

        for (int i = 0; i < n; i++){
             char ch = s.charAt(i);
             if(ch == '['){
                open++;
             }else{
                close++;
             }

             if(close > open){
               //swap with the open near to end of s
                ans++;
                close--;
                open++;
             }
        }
        return ans;
    }

    private static int minSwapsDiff(String s){
        int n = s.length(), open = 0, closed = 0, end = n - 1, ans = 0;
        for(int i=0; i<n; ++i) {
            if(s.charAt(i) == '[') {
               open++;
            }else {
               closed++;
            }
            if(closed > open) {
               while(s.charAt(end) != '[') end--;
               s = swap(end, i, s);
               ans++;
               closed--;
               open++;
            }
        }
        return ans;
    }

    private static String swap(int end, int i, String s) {
        StringBuilder sb = new StringBuilder(s);
        char ch = sb.charAt(end);
        sb.setCharAt(end, sb.charAt(i));
        sb.setCharAt(i, ch);
        return sb.toString();
    }

}
