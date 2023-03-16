package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Task1Solution {
    //with set O(n) time
    static public int singleNumber(int[] nums){
        HashSet<Integer> count = new HashSet<>();
        for(var a: nums){
            if(count.contains(a)){
                count.remove(a);
            }else{
                count.add(a);
            }
        }
        return count.iterator().next();

    }
    //with map O(n) time
    static public int singleNumber2(int[] nums){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(var a: nums){
            if(!hashMap.containsKey(a))
                hashMap.put(a, 1);
            else
                hashMap.put(a, 2);
        }
        for (int a : hashMap.keySet()) {
            if(hashMap.get(a) == 1) return a;
        }
        return 0;
    }

    //with sorting the array O(nlog(n)) time
    static public int singleNumber3(int[] nums){
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i += 2)   {
            if(nums[i] != nums[i - 1]) return nums[i - 1];
        }
        return nums[nums.length - 1];
    }
}
