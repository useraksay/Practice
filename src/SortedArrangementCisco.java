import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SortedArrangementCisco {
    public static void main(String[] args) {

    }

    private static long minOperations(List<Integer> numbers){
        int n = numbers.size();
        int ans = 0;
        int inserts = 0;
        int removals = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        inserts++;
        ans++;
        linkedList.offerFirst(numbers.get(0));
        for(int i = 1; i < n; i++){
            int num = numbers.get(i);
            if(num <= linkedList.getFirst()){
               linkedList.offerFirst(num);
               inserts++;
               ans++;
            }else{
               ans += findMinOperation(num, linkedList);
            }
        }

        return ans;
    }

    private static int findMinOperation(int x, LinkedList<Integer> linkedList){
      int total = 0;
      int i;
      for(i = 0; i < linkedList.size(); i++){
          if(linkedList.get(i) < x) continue;
          else break;
      }
      int elementsAtLeft = i - 0;
      int elementsAtRight = linkedList.size() - i;
      if(elementsAtRight < elementsAtLeft){
         //pop from right
         int removals = 0;
         int inserts = 0;
         List<Integer> tempList = new ArrayList<>();
         while(!linkedList.isEmpty() && x < linkedList.getLast()){
               int num = linkedList.pollLast();
               removals++;
               tempList.add(num);
         }
         linkedList.offerLast(x);
         inserts++;
         for(int j = tempList.size() - 1; j >= 0; j--){
             linkedList.offerLast(tempList.get(j));
             inserts++;
         }
         total = removals + inserts;
      }else{
         //pop from left
          int removals = 0;
          int inserts = 0;
          List<Integer> tempList = new ArrayList<>();
          while(!linkedList.isEmpty() && x > linkedList.getFirst()){
              int num = linkedList.pollFirst();
              removals++;
              tempList.add(num);
          }
          linkedList.offerFirst(x);
          inserts++;
          for(int j = tempList.size() - 1; j >= 0; j--){
              linkedList.offerFirst(tempList.get(j));
              inserts++;
          }
          total = removals + inserts;

      }
      return total;
    }

    private static List<String> preProcessDates(List<String> dates){
        int n = dates.size();
        List<String> ans = new ArrayList<>();

        String year = "";
        String month = "";
        String day = "";

        for(int i = 0; i < n; i++){
            String[] s = dates.get(i).split(" ");

            year = s[2];
            int days = s[0].length();
            day = s[0].substring(0, days-2);

            if(day.length()==1) {
                day = "0" + day;
            }

            switch(s[1]) {
                case "Jan":
                    month = "01";
                    break;
                case "Feb":
                    month = "02";
                    break;
                case "Mar":
                    month = "03";
                    break;
                case "Apr":
                    month = "04";
                    break;
                case "May":
                    month = "05";
                    break;
                case "Jun":
                    month = "06";
                    break;
                case "Jul":
                    month = "07";
                    break;
                case "Aug":
                    month = "08";
                    break;
                case "Sep":
                    month = "09";
                    break;
                case "Oct":
                    month = "10";
                    break;
                case "Nov":
                    month = "11";
                    break;
                case "Dec":
                    month = "12";
                    break;
            }

            ans.add(year + "-" + month + "-" + day);
        }

        return ans;
    }


}
