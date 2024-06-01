public class IsSubsequenceLC392 {
    public static void main(String[] args) {

    }
    //return true if s is a subsequence of t, or false otherwise.
    public static boolean isSubsequence(String s, String t){
       int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length() && j < t.length()){
              if(s.charAt(i) == t.charAt(j)){
                 sb.append(s.charAt(i));
                 i++;
              }
              j++;
        }

        return s.equalsIgnoreCase(sb.toString());
    }
}
