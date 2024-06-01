import java.util.HashSet;

public class PlayListCSES {
    public static void main(String[] args) {
        int[] playList = new int[]{1, 2, 1, 3, 2, 7, 4};
//        int[] playList = new int[]{1, 2, 1, 3, 2, 7, 4, 2};
//        int[] playList = new int[]{1, 2, 3, 4, 5};
        int res = solve(playList);
        System.out.println(res);
    }

    public static int solve(int[] playList){
        int ans = 0;
        int n = playList.length;
        HashSet<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        while(i < n && j < n){
              if(set.add(playList[j])){
                 j++;
              }else{
                 ans = Math.max(ans, set.size());
                 set.clear();
                 i = j;
              }
        }
        return Math.max(ans, set.size());
    }
}
