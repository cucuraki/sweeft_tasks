package solutions;

public class Task2Solution {
    public static int minSplit(int amount){
        int[] coins = {50, 20, 10, 5, 1};
        int count = 0;
        for(var a: coins){
            count += amount / a;
            amount %= a;
        }
        return count;
    }

}
