import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StockPredictions {

    public static int maximumTransactions (double cash, double cost) {
        
        int maximum = 0;
        if ( cash >= cost) {
            maximum++;
            cash = cash - cost;
        }
        return maximum;
    }
    
    static void printTransactions(double m, int k, int d, String[] name, int[] owned, double[][] prices) {
        
        /*
    m - the amount of money you could spend that day.
    k - the number of different stocks available for buying or selling.
    d - the number of remaining days for trading stocks.
    k lines follow, each in the following format: name owned prices

    name - the name of the stock (a string).
    owned - the number of shares you own of that stock.
    prices - 5 space separated numbers representing the stock's price for the last 5 days. These are ordered from oldest     to newest, so the last number is the current stock price.
        */
        
        int count = 0;
        double average = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 4; j++) {
                average = average + prices[i][j];
            }
            average = (average / 4);
            double cash = prices[i][4];
            double[] cost = prices[i];
            if (cost[4] > cost[1] /*&& cost[2] < cost[3] && cost[3] > cost[1]*/) {
                if (owned[i] > 0 && cost[4] > cost[3]) {
                    str.append(name[i] + " SELL " + owned[i] + "\n");
                    count++;
            }
            } else if
                    (cost[4] < 1 && cost[4] > -1000 && cash < average) {
                    str.append(name[i] + " DO NOTHING" + owned[i] + "\n");
                    count++;
                
                } else {
                    int priceIndex = (int)(m / cost[4]);
                    if (priceIndex > 0) {
                        m = m - (priceIndex * cost[4]);
                        str.append(name[i] + " BUY " + priceIndex + "\n");
                        count++;
                }
            }
            
            }
        System.out.println(count);
        if (count != 0) {
            System.out.println(str.toString());
        }

        }
    
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        double _m;
        _m = in.nextDouble();
        
        int _k;
        _k = in.nextInt();
        
        int _d;
        _d = in.nextInt();
        
        String[] _name = new String[_k];
        int[] _owned = new int[_k];
        double[][] _prices = new double[_k][5];
        
        String _name_item;
        int _owned_item;
        double _prices_item_item;
        
        for(int _i = 0; _i < _k; _i++) {
            _name_item = in.next();
            _name[_i] = _name_item;
            
            _owned_item = in.nextInt();
            _owned[_i] = _owned_item;
            
            for(int _j = 0; _j<5; _j++) {
                _prices_item_item = in.nextDouble();
                _prices[_i][_j] = _prices_item_item;                
            }
        }
        
        printTransactions(_m, _k, _d, _name, _owned, _prices);
        
    }
}
