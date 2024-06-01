import java.util.Arrays;

public class ApartmentsCSES {
    public static void main(String[] args) {
        int k = 5;
        int[] applicants = new int[]{60, 45, 80, 60};
        int[] apartments = new int[]{30, 60, 75};
        int res = solve(k, applicants, apartments);
        System.out.println(res);
    }

    public static int solve(int k, int[] applicants, int[] apartments){
        Arrays.sort(applicants); // 45 60 60 80
        Arrays.sort(apartments); // 30 60 75

        int ans = 0;

        int i = 0, j = 0;
        while(i < applicants.length){
              while(j < apartments.length){
                  if(Math.abs(apartments[j] - applicants[i]) <= k){
                     ans++;
                     j++;
                     break;
                  }else if(applicants[i] + k < apartments[j]){
                     break;
                  }
                  j++;
              }
              i++;
        }
        return ans;
    }
}
