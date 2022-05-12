import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongestCommonPrefix {
    public static String solve(List<String> A){
        StringBuilder ans = new StringBuilder();
        Comparator<String> byLength = (s1, s2) -> s1.length() > s2.length() ? -1 : 1;
        Optional<String> shortest = A.stream().sorted(byLength.reversed()).findFirst();
        System.out.println("shortest :" + shortest);
        return ans.toString();
    }
}
