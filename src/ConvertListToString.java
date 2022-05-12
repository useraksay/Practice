import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToString {
    public static String convert(List<String> stringList) {
        //System.out.println(stringList);
        String res = String.join(",", stringList
                .stream()
                .map(name -> ("'" + name + "'"))
                .collect(Collectors.toList()));
        System.out.println(res);
        return res;
    }

    public static void computeIfPresentTest(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "kiosks");
        map.put("2", "neon");
    }

}
