import java.util.HashSet;
import java.util.Set;

public class StringOperations {
    /*
    * Concatenate the string with itself.
    * Delete all the uppercase letters.
    * Replace each vowel with '#'.
    * */
    public static void solve(String A){
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        //concat with itself
        StringBuilder concatStr = new StringBuilder(A.concat(A));
        StringBuilder ans = new StringBuilder();

        //delete Upper case
        for(int i = 0; i < concatStr.length(); i++){
            if(!((concatStr.charAt(i) >= 65) && (90 >= concatStr.charAt(i)))){
                ans.append(concatStr.charAt(i));
            }
        }
        //replace vowel with '#'
        for(int i = 0; i < ans.length(); i++){
            if(vowels.contains(ans.charAt(i))){
                ans.setCharAt(i, '#');
            }
        }

        System.out.println(ans.toString());
    }
}
