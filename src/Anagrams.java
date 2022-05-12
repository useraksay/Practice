import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            list.add("cat");
            list.add("dog");
            list.add("god");
            list.add("tac");
            System.out.println(solve(list));
    }

    public static ArrayList<ArrayList<Integer>> solve(final List<String> a){
        int n = a.size();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        //sort individual elements
        for(int i = 0; i < n; i++){
            String str = countSort(a.get(i));
            a.set(i, str);
        }

        for (int i = 0; i < n; i++){
            String str = a.get(i);
            int hash = str.hashCode();
            if(!map.containsKey(hash)){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i + 1);
                map.put(hash, temp);
            }else {
                ArrayList<Integer> temp = map.get(hash);
                temp.add(i + 1);
                map.put(hash, temp);
            }
        }
        for(HashMap.Entry<Integer, ArrayList<Integer>> mp : map.entrySet()){
            ArrayList<Integer> mpValue = mp.getValue();
            ans.add(mpValue);
        }
        return ans;
    }

    private static String countSort(String s) {
        int[] freq = new int[26];
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            freq[c - 97]++;
        }
        for (int i = 0; i < freq.length; i++){
            while(freq[i] > 0){
                char c = (char) ((char) 97 + i);
                ans.append(c);
                freq[i]--;
            }
        }
        return ans.toString();
    }
}
