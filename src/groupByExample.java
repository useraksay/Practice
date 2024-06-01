import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupByExample {

    public void test(){
        List<Map<String, String>> rowMap = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("ncpdp", "0100052");
        map.put("capablity", "slan");
        map.put("capablityInd", " ");

        map.put("ncpdp", "0100052");
        map.put("capablity", "slan");
        map.put("capablityInd", "spa");

        map.put("ncpdp", "0100052");
        map.put("capablity", "c24h");
        map.put("capablityInd", "y");

        map.put("ncpdp", "0100013");
        map.put("capablity", "slan");
        map.put("capablityInd", " ");

        map.put("ncpdp", "0100013");
        map.put("capablity", "slan");
        map.put("capablityInd", "rus");

        map.put("ncpdp", "0100013");
        map.put("capablity", "c24h");
        map.put("capablityInd", "n");
    }

}
