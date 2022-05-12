import java.util.ArrayList;

public class AllSubSets {
    public static void main(String[] args) {
        String str = "ABC";

        ArrayList<String> res = solve(str);
        System.out.println(res);
    }

    public static ArrayList<String> solve(String str){
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
}
