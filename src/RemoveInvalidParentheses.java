import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        
    }

    private static void dfs(){

    }

    private static ArrayList<String> bfs(String s){
        ArrayList<String> res = new ArrayList<>();
        if (s == null)	return res;
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>(); // avoid duplicate results
        q.offer(s);
        visited.add(s);
        boolean foundValid = false;
        while (!q.isEmpty()) {
            String t = q.poll();
            if (isValid(t)) {
                res.add(t);
                foundValid = true;
            }
            // found valid, no need to remove anymore, just iterative the rest of q and add to res when necessary
            if (foundValid)		continue;
            for (int i = 0; i < t.length(); i++) {
                if(t.charAt(i) != '(' && t.charAt(i) != ')')	continue;
                String r = t.substring(0, i) + t.substring(i + 1);
                if (visited.contains(r))	continue;
                visited.add(r);
                q.offer(r);
            }
        }
        return res;
    }

    private static boolean isValid(String s) {
        int count = 0; // stack variable
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')		count++;
            if (s.charAt(i) == ')' && count-- == 0)	return false;
        }
        return count == 0;
    }
}
