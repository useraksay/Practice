public class BuildLowestNumber {
    public static void main(String[] args) {

    }


    private static void buildLowestNum(String str, int n, StringBuilder res){
        if (n == 0) {
            res.append(str);
        }

        int len = str.length();
        int minIndex = 0;
        for (int i = 1; i <= n ; i++)
            if (str.charAt(i) < str.charAt(minIndex)) {
                minIndex = i;
            }

        res.append(str.charAt(minIndex));
        String new_str = str.substring(minIndex + 1, len - minIndex);

        buildLowestNum(new_str, n - minIndex, res);
    }
}
