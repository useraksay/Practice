import java.util.ArrayList;

public class GrayCode {
    public static void main(String[] args) {
            System.out.println(grayCode(2));
    }

    public static ArrayList<Integer> grayCode(int n){
        if(n == 1){
           ArrayList baseRes = new ArrayList();
           baseRes.add(0);
           baseRes.add(1);
           return baseRes;
        }
        ArrayList<Integer> smallRes = grayCode(n - 1);
        ArrayList<Integer> res = new ArrayList();

        for(int i = 0; i < smallRes.size(); i++){
            res.add(smallRes.get(i));
        }
        for(int i = smallRes.size() - 1; i >= 0; i--){
            int y = (int)Math.pow(2,n-1);
            int x = smallRes.get(i) + y;
            res.add(x);
        }
        return res;
    }

    //DP solution to get graycodes
    public static ArrayList <Integer> grayCodeDP(int a) {
        int n = a;
        ArrayList <Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            int curSize = result.size();
            // push back all element in result in reverse order
            for (int j = curSize - 1; j >= 0; j--) {
                result.add(result.get(j) + (1 << i));
            }
        }
        return result;
    }
}
