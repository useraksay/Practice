import java.util.ArrayList;
import java.util.List;

public class PrintAllSubSets {
    public static void main(String[] args) {
        String str = "ABCD";
        List<String> ans = new ArrayList<>();
        solve(str, "",0, ans);
        System.out.println(ans);
    }
    public static void solve(String str, String result, int index, List<String> ans){
        if(str.isEmpty()){
            if(!result.isEmpty())
                ans.add(result);
            return;
        }
        for(int i = index; i < str.length(); i++){
            solve(str.substring(i + 1), result + str.substring(i, i + 1), index, ans);
            solve(str.substring(i + 1), result, index + 1, ans);
        }

    }
}
