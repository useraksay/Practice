import java.util.ArrayList;
import java.util.List;

public class AllSubSets {

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String str = "ABC";

        ArrayList<String> res = solve(str);
        System.out.println(res);

        solve(0, str, new StringBuilder());
        System.out.println(list);
    }

    private static ArrayList<String> solve(String str){
        if(str.isEmpty()){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        //pick first char from str
        char ch = str.charAt(0);
        //solve recursively for rest of the string
        ArrayList<String> tres = solve(str.substring(1));
        //form final result
        // either include ch
        // or not include ch
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < tres.size(); i++){
             res.add(ch + tres.get(i));
             res.add(tres.get(i));
        }

        return res;
    }

    private static void solve(int index, String str, StringBuilder res){
        if(index == str.length()){
           if(res.toString().isEmpty()) res.append("{}");
           list.add(res.toString());
           return;
        }


        //Take the char at current index, add it to the result,  go to next index
        solve(index + 1, str, res.append(str.charAt(index)));
        res.deleteCharAt(res.length() - 1);
        //Don't take the element at current index, do not add it, go to next index
        solve(index + 1, str, res);
    }
}
