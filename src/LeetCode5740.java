import java.util.HashSet;

public class LeetCode5740 {
     //Print the largest length of occurrence of 'aeiou' with repeats allowed
    // & the occurrences must be in sorted order.
    // Approach: two pointers & hashing
    public static void main(String[] args) {
//     System.out.println(solve("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
       System.out.println(solve("aeeeiiiioooauuuaeiou"));
    }

    public static int solve(String word){
        int ans = 0;
        int n = word.length();
        int i = 0, j = 0;

        while (i < n){
          if(word.charAt(i++) == 'a') break;
        }

        HashSet<Character> set = new HashSet<>();

        char prevChar = '0';
        i = i - 1;
        int firstAIdx = i;
        while(i < n){
            //ch will always be 'a'
            char ch = word.charAt(i);
            if(set.isEmpty()){
               if(ch == 'a'){
                  firstAIdx = i;
               }
               set.add(ch);
            }else{
                int sz = set.size();
                if (sz == 5) {
                    ans = Math.max(i - firstAIdx, ans);
                }
                if(ch == 'a'){
                    firstAIdx = i;
                }

                if(ch == 'e' && prevChar == 'a'){
                    set.add(ch);
                }
                else if(ch == 'i' && prevChar == 'e'){
                    set.add(ch);
                }
                else if(ch == 'o' && prevChar == 'i'){
                    set.add(ch);
                }
                else if(ch == 'u' && prevChar == 'o'){
                    set.add(ch);
                }
                else {
                    set.clear();
                    if(ch == 'a'){
                        set.add(ch);
                    }
                }
            }

            j = i + 1;
            if(j < n){
               while(j < n && word.charAt(j) == ch){
                     j++;
               }
               if(j == n && set.size() == 5 && ch == 'u' && prevChar == 'o'){
                  ans = Math.max(ans, j - firstAIdx);
               }
               prevChar = ch;
               i = j;
            }else if(j == n){
               if(set.size() == 5){
                  ans = Math.max(ans, j - firstAIdx);
               }
               i = j;
            }

        }
        return ans;
    }

}
