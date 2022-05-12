public class LexicographicallyLargest {
    public static void solve(String A){
        String s = A.split("\\_")[0];
        String p = A.split("\\_")[1];
        StringBuilder sortedP = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int freq[] = new int[26];
        for (int i = 0; i <= p.length() - 1; i++) {
            freq[p.charAt(i) - 'a']++;
        }

        for (int i = 25; i >= 0; i--) {
            while (freq[i] > 0) {
                sortedP =  sortedP.append((char) ('a' + i));
                freq[i]--;
            }
        }

        int i = 0, j = 0;
        while (i < s.length() && j < sortedP.length()){
            if(sortedP.charAt(j) > s.charAt(i)){
                ans.append(sortedP.charAt(j));
                j++;
                i++;
            }else{
                ans.append(s.charAt(i));
                i++;
            }
        }

        while(i < s.length()){
            ans.append(s.charAt(i));
            i++;
        }

        System.out.println(ans.toString());
    }
}
