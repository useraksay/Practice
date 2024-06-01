import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexCheck {
    public static void solve(String ncpdp){
//        System.out.println(Arrays.asList(" 100100", "100100 ", " 120090 ").stream().map(str -> str.trim()).distinct().collect(Collectors.toList()));
//        System.out.println(Arrays.asList(" 100100", "100100 ", " 120090 ", "0100381  ").stream().map(String::trim).distinct().collect(Collectors.toList()));
        ncpdp = ncpdp.trim();
        System.out.println(ncpdp);
        String regex = "^[a-zA-Z0-9]+$";
//        String regex = "^[0-9]{6}[a-zA-Z]+\\d$|^[0-9]{6}\\d$";
        boolean bool = Pattern.matches(regex, ncpdp);
        System.out.println(bool);
    }
}
