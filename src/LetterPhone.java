import java.util.ArrayList;
/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/1148252/Short-and-Easy-Solutions-or-Multiple-Approaches-Explained-or-Beats-100
 * */
public class LetterPhone {
    public static ArrayList<String> ans = new ArrayList<>();
    public static ArrayList<String> charList = new ArrayList<>();
    static {
        charList.add("0");
        charList.add("1");
        charList.add("abc");
        charList.add("def");
        charList.add("ghi");
        charList.add("jkl");
        charList.add("mno");
        charList.add("pqrs");
        charList.add("tuv");
        charList.add("wxyz");
    }
    public static void main(String[] args) {
        String ques = "23";
        StringBuilder sb = new StringBuilder();
        solve(sb, 0, ques);
        System.out.println(ans);
    }

    private static void solve(StringBuilder curr, int index, String ques){
        if(index == ques.length()){
            ans.add(curr.toString());
            return;
        }

        int digit = ques.charAt(index) - '0';
        for (int i = 0; i < charList.get(digit).length(); i++){
             curr.append(charList.get(digit).charAt(i));
             solve(curr, index + 1, ques);
             curr.deleteCharAt(curr.length() - 1);
        }
        return;
    }
}
