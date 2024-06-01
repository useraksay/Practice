import java.util.ArrayList;
import java.util.HashMap;

public class IsDictionary {
    public static int solve(ArrayList<String> A, String B){
        int ans = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            map.put(B.charAt(i), i);
        }

        if(A.size() == 1) return ans;

        int prev = map.get(A.get(0).charAt(0));

        for(int i = 1; i < A.size(); i++){
            String word = A.get(i);
            int curr = map.get(word.charAt(0));
            if(curr > prev){
                prev = curr;
                continue;
            } else if(prev > curr) {
                ans = 0;
                break;
            }else { // prev == curr
                ans = compareLexicographically(word, A.get(i - 1), map);
                if(ans == 0) break;
                else continue;
            }
        }
        System.out.println(ans);
        return ans;
    }

    private static int compareLexicographically(String word, String s, HashMap<Character, Integer> map) {
        int m = word.length();
        int n = s.length();
        int res = 0;
        if(m == 1 && n == 1) return res;
        int i = 1 , j = 1;
        while(i < m && j < n){
            if(map.get(word.charAt(i)) > map.get(s.charAt(j))){
               i++;
               j++;
               res = 1;
               break;
            }else if(map.get(word.charAt(i)) == map.get(s.charAt(j))){
                i++;
                j++;
            }else{
               res = 0;
               break;
            }
        }
        return res;
    }
}
