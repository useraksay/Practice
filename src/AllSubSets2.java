import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllSubSets2 {

    private static Set<List<Integer>> result = new HashSet<>();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);

//        solve(0, new ArrayList<>(), list);
//        System.out.println(result);
        solve2(0, new ArrayList<>(), list);
    }

    private static void solve(int index, List<Integer> ds, List<Integer> list){
        if(index == list.size()){
            System.out.println(ds);
            result.add(ds);
            return;
        }

        ds.add(list.get(index));
        solve(index + 1, ds, list);

        while (index + 1 < list.size() && list.get(index) == list.get(index + 1)){
            index += 1;
        }

        ds.remove(ds.size() - 1);
        solve(index + 1, ds, list);
    }

    private static void solve2(int index, List<Integer> ds, List<Integer> list){
        if(index - 1 > 0 && list.get(index) != list.get(index - 1)){
            index += 1;
            return;
        }

        if(index == list.size()){
            System.out.println(ds);
            result.add(ds);
            return;
        }

        ds.add(list.get(index));
        solve(index + 1, ds, list);

        ds.remove(ds.size() - 1);


        if(index + 1 != list.size() && list.get(index) == list.get(index + 1)) {
            index += 1;
        }else {
            solve(index + 1, ds, list);
        }
    }
}
