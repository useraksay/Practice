import java.util.ArrayList;

public class WordBreak2 {
    /*
    * A = "catsanddog",
    * B = ["cat", "cats", "and", "sand", "dog"]
    * o/p : ["cat sand dog", "cats and dog"]
    *
    * */
    public static void main(String[] args) {
//          String s = "aabbbabaaabbbabaabaab";
          String s = "catsanddog";
          ArrayList<String> list = new ArrayList<>();
          list.add("cat");
          list.add("cats");
          list.add("and");
          list.add("sand");
          list.add("dog");
         /* list.add("bababbbb");
          list.add("bababbbb");
          list.add("abbb");
          list.add("a");
          list.add("aabbaab");
          list.add("b");
          list.add("babaabbbb");
          list.add("aa");
          list.add("bb");*/
          ArrayList<String> ans = new ArrayList<>();
          wordBreak(s, list, 0, ans, "");
          System.out.println(ans);
    }

    private static void wordBreak(String s, ArrayList<String> list, int index, ArrayList<String> ans, String tempAns) {
        if(s.isEmpty()) {
           ans.add(tempAns);
           return;
        }

        for (int i = index; i < s.length(); i++){
             String str = s.substring(0, i + 1);
             if(list.contains(str)){
                 String res = "";
                 if(i == s.length() - 1){
                    res = tempAns + str;
                 }else{
                    res = tempAns + str + " ";
                 }
                 wordBreak(s.substring(i + 1), list, index, ans, res);
             }
        }
    }
}
