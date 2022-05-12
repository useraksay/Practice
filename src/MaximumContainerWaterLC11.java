public class MaximumContainerWaterLC11 {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height){
            int n = height.length;
            int ans = 0;
            int i = 0, j = n - 1;
            while(i < j){
               ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));

               if(height[i] == height[j]){
                   i++;  //move either
               }

               if(height[i] < height[j]){
                   i++;
               }else {
                   j--;
               }

            }
            return ans;
    }
}
