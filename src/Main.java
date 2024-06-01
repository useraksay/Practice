import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        int x = 10;
        System.out.println("Hello World!! \nWelcome " + x);
//          RearrangeArray.solve(new int[]{3, 2, 0, 1});
//          ReverseInteger.solve(-123);
//          ConvertListToString.convert(Arrays.asList("args","args","012300"));

//        String ncpdp = "010005r";
//        System.out.println(Integer.valueOf(ncpdp.substring(ncpdp.length() - 1)));
//        System.out.println(ncpdp.substring(0, 1));
//          LongestCommonPrefix.solve(Arrays.asList("abab", "ab", "abcd"));
//          LexicographicallyLargest.solve("abcdefgh_zzz");
//          LexicographicallyLargest.solve("z_p");
//          LexicographicallyLargest.solve("ittmcsvmoa_jktvvblefw");
//          ClosestPalindrome.solve("aaaaaaaaaabaaaaaaaaa");
//          StringOperations.solve("AbcaZeoB");
//          ChangeCharacter.solve("abcabbccd", 3);
//        System.out.println(DigitSum.solve(101));
//          RegexCheck.solve(" 0100052' ");
          /*ArrayList<String> list = new ArrayList<>();
          list.add("hello");
          list.add("scaler");
          list.add("interviewbit");
          list.add("ipial");
          list.add("qjqgt");
          list.add("vfnue");
          list.add("vjqfp");
          list.add("eghva");
          list.add("ufaeo");
          list.add("atyqz");
          list.add("chmxy");
          list.add("ccvgv");
          list.add("ghtow");*/
//          IsDictionary.solve(list, "adhbcfegskjlponmirqtxwuvzy");
//          IsDictionary.solve(list, "nbpfhmirzqxsjwdoveuacykltg");
          /*ArrayList<Integer> nums = new ArrayList<>();
          nums.add(1);
          nums.add(1);
          nums.add(2);
          nums.add(2);
          nums.add(3);*/
//          PerfectCards.solve(nums);
          /*ArrayList<Integer> nums = new ArrayList<>();
          nums.add(6);
          nums.add(4);
          nums.add(3);
          nums.add(7);
          nums.add(2);
          nums.add(8);
          SelectionSort.solve(nums);*/
          /*ArrayList<Integer> a = new ArrayList<>();
          a.add(12);
          a.add(7);
          ArrayList<Integer> b = new ArrayList<>();
          b.add(7);
          b.add(1);
          b.add(6);
          b.add(17);
          b.add(2);
          b.add(19);
          b.add(10);
          SortArrayCustom.solve(a, b);*/
        /*ArrayList<Integer> nums = new ArrayList<>();
          nums.add(-1);
          nums.add(1);
          SubArraySumZero.solve(nums);*/
//        LongestSubstringWithoutRepeat.solve("tmmzuxt");

    }

    public static int[] solve(int[] A, int[] B, int C) {
        /*
        * Sample input call from Main method
        * int[] A = {1};
        * int[] B = {2, 4};
        * int C = 4;
        * solve(A, B, C);
        * */
        int m = A.length;
        int n = B.length;
        int[] ans = new int[2];
        int i = 0, j = n - 1;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int diff = Integer.MAX_VALUE;
        while(i < m && j > -1){
            int a = A[i];
            int b = B[j];
            int s = a + b;
            int d = (s - C);

            if(d == 0){
                ans[0] = a;
                ans[1] = b;
                break;
            }

            if(Math.abs(d) <= diff){
                if(!map.containsKey(Math.abs(d))){
                    ArrayList<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(j);
                    map.put(Math.abs(d), ls);
                    diff = Math.abs(d);
                    ans[0] = a;
                    ans[1] = b;
                }else{
                    ArrayList list = map.get(Math.abs(d));
                    int i_idx = (int)list.get(0);
                    int j_idx = (int)list.get(1);
                    if(i <= i_idx){
                        if(j < j_idx){
                            diff = Math.abs(d);
                            ans[0] = a;
                            ans[1] = b;
                        }
                    }
                }
            }

            if(s > C){
                j--;
            }else{
                i++;
            }
        }
        return ans;
    }
}
