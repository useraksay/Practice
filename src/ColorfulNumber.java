import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ColorfulNumber {
    public static int solve(int A){
        ArrayList<Integer> digits = new ArrayList<>();
        while (A != 0){
            digits.add(A % 10);
            A = A / 10;
        }
        Collections.reverse(digits);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < digits.size(); i++){
            int product = 1;
            for (int j = i; j < digits.size(); j++){
                product *= digits.get(j);
                if(set.contains(product)){
                    return 0;
                }
                set.add(product);
            }
        }
        return 1;
    }
}
