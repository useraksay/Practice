import java.util.ArrayList;
import java.util.Collections;

public class MaxStocksithDay {
    public static void main(String[] args) {
        int[] prices = new int[]{10, 7, 19};
        int k = 45;
        MaxStocksithDay maxStocksithDay = new MaxStocksithDay();
        System.out.println(maxStocksithDay.buyStocks(prices, k));
    }

    public int buyStocks(int[] prices, int k){
        int n = prices.length;
        int ans = 0;
        ArrayList<PriceDayPair> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(new PriceDayPair(prices[i], i + 1));
        }
        Collections.sort(list, (o1, o2) -> o1.getPrice() > o2.getPrice() ? 1 : o1.getPrice() < o2.getPrice() ? -1 : 0);

        for (int i = 0; i < list.size(); i++){
//             System.out.println(list.get(i).getPrice() + " " + list.get(i).getDay());
            int price = list.get(i).getPrice();
            int stocks = list.get(i).getDay();

            if(price * stocks <= k){
               k = k - price * stocks;
               ans = ans + stocks;
            }else {
               ans = ans + (k/ price);
               k = k - price * (k/ price);
            }
        }
        return ans;
    }

    private class PriceDayPair{
        private int price;
        private int day;

        public PriceDayPair(int price, int day){
            this.price = price;
            this.day = day;
        }

        public int getPrice() {
            return price;
        }

        public int getDay() {
            return day;
        }
    }
}
