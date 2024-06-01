import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChangeCharacter {
    public static void solve(String A, int B){
        int[] freq = new int[26];
        for(int i = 0; i < A.length(); i++){
            char ch = A.charAt(i);
            freq[ch - 'a']++;
        }

        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > 0){
                arr.add(freq[i]);
            }
        }
        Collections.sort(arr);
        int i = 0;
        while (B != 0){
            int cnt = arr.get(i);
            if(B >= cnt){
                B = B - cnt;
            }else {
                break;
            }
            i++;
        }
        System.out.println(arr.size() - i);
    }
}
