import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PrintPermutationsInRepeats {
    public static void main(String[] args) {
        String a = "AAB";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < a.length(); i++){
            char ch = a.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        printPPSwap(a.toCharArray(), 0);
    }

    public static void printRepeatedPermuatations(HashMap<Character, Integer> map, int n, String a, StringBuilder s, ArrayList<String> ans){
            if(s.length() == n){
                ans.add(s.toString());
                System.out.println(s);
                return;
            }

            for (int i = 0; i < map.size(); i++){
                 char ch = a.charAt(i);
                 if(map.get(ch) > 0){
                   map.put(ch, map.get(ch) - 1);
                   s.append(ch);
                   a = a.substring(0, i) + a.substring(i + 1);
                 }
                 printRepeatedPermuatations(map, n, a, s, ans);
            }
    }

    public static void printPPSwap(char[] s, int pos){
        if(pos == s.length){
           System.out.println(s);
           return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = pos; i < s.length; i++){
             if(set.contains(s[i])) continue;

             set.add(s[i]);
             swap(s, i, pos);
             printPPSwap(s, pos + 1);
             swap(s, i, pos);
        }

    }

    private static void swap(char[] s, int i, int pos) {
        char temp = s[i];
        s[i] = s[pos];
        s[pos] = temp;
    }

}
