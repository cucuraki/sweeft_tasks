package solutions;

import java.util.HashSet;

public class Task3Solution {
    //with array
    public static int notContains(int[] array){
        boolean[] arr = new boolean[array.length];
        for(int a: array){
            if(a > 0 && a <= array.length){
                arr[a - 1] = true;
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(!arr[i]) return i + 1;
        }
        return arr.length + 1;
    }
    //with set
    public static int notContains1(int[] array){
        HashSet<Integer> set = new HashSet<>();
        for(var a: array){
            set.add(a);
        }
        int i = 1;
        while(true){
            if(!set.contains(i)) return i;
            i++;
        }
    }
}
