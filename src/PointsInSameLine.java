import java.util.ArrayList;
import java.util.HashMap;

public class PointsInSameLine {
    public static void main(String[] args) {
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();

            A.add(2);
            A.add(1);
            A.add(-7);
            A.add(4);
            A.add(1);
            A.add(-2);
            A.add(-7);
            A.add(5);

            B.add(-6);
            B.add(-7);
            B.add(3);
            B.add(10);
            B.add(7);
            B.add(-10);
            B.add(1);
            B.add(2);

            int ans = solve(A, B);
            System.out.println(ans);
    }
    /*
    * A - x co-ordinates
    * B - y co-ordinates
    * */
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B){
        /*
        * Logic:
        * Fix a point and find the slope by checking with other points.
        * Points in a line have same slope and offset (y offset). (y = mx + c)
        * Make a map of slope_offset vs count
        * return the max count
        *
        * */

        int m = A.size();
        int ans = 2;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++){                 // loop through x coordinates
            map.clear();
            int dup = 1;
            for (int j = i + 1; j < m; j++){       // loop through x coordinates
                if(A.get(j) == A.get(i) && B.get(j) == B.get(i)){
                    dup++;
                }else {
                    int dx = A.get(j) - A.get(i);     // x2 - x1
                    int dy = B.get(j) - B.get(i);    //  y2 - y1

                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;
                    String slope = dy + "_" + dx;
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }

                    /*int cx = (A.get(i)*B.get(j) + A.get(j)*B.get(i));
                    int cy = (A.get(j) - A.get(i));
                    if(cy != 0) {
                        int cgcd = gcd(cx, cy);
                        cx /= cgcd;
                        cy /= cgcd;
                    }

                    String offset = cx + "_" + cy;
                    String combined = slope + "_" + offset;*/

                ans = Math.max(ans, dup);
                for(HashMap.Entry<String, Integer> mp : map.entrySet()){
                    ans = Math.max(mp.getValue() + dup, ans);
                }
            }
        }

        return ans;
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;

        return gcd(b,a % b);
    }
}
