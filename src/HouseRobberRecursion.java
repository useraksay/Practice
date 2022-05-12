public class HouseRobberRecursion {
    public static void main(String[] args) {
        int[] houses = new int[]{1, 2, 100, 2, 3, 100, 7, 100};
        System.out.println(solve(0, false, houses));
    }

    public static int solve(int i, boolean isPrevHouseRobbed, int[] arr){
        if(i == arr.length) return 0;
        int rob =  0;
        if(!isPrevHouseRobbed){
           rob = solve(i + 1, true, arr) + arr[i];
        }
        int donotRob = solve(i + 1, false, arr);
        return Math.max(rob, donotRob);
    }
}
