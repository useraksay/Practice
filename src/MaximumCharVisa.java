import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MaximumCharVisa {
    public static void main(String[] args) {
        char c = maximumOccurringCharacter("helloworld");
    }

    public static char maximumOccurringCharacter(String text) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char ans = text.charAt(0);
        map.put(ans, 1);
        for (int i = 1; i < text.length(); i++){
             char c = text.charAt(i);
             map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);

        int maxFreq = Integer.MIN_VALUE;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char c = entry.getKey();
            int freq = entry.getValue();
            System.out.println(c + ":" + freq);
            if(freq > maxFreq){
                ans = c;
                maxFreq = freq;
            }
        }
        return ans;
    }
}
