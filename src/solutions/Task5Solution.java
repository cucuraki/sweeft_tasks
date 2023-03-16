package solutions;

import java.util.HashMap;

public class Task5Solution {
    //O(log(n)) time
    public static long countVariantsBinary(int stareCount) {
        long[] vec = {1, 1};
        long[] matrix = {1, 1, 1, 0};
        while (true) {
            if (stareCount % 2 == 1) {
                multiplyMatrixWithVector(matrix, vec);
            }
            stareCount >>= 1;
            if (stareCount == 0) {
                break;
            }
            squareMatrix(matrix);
        }
        return vec[1];
    }


    //O(2^n) time
    public static int countVariantsRecursion(int staresCount) {
        if (staresCount == 0) return 1;
        if (staresCount == 1) return 1;
        return countVariantsRecursion(staresCount - 1)
                + countVariantsRecursion(staresCount - 2);
    }

    //with map
    private static HashMap<Integer, Integer> mp = new HashMap<>();

    public static int countVariantsMap(int staresCount) {
        if (staresCount == 0) return 1;
        if (staresCount == 1) return 1;
        int prev = mp.containsKey(staresCount - 1) ? mp.get(staresCount - 1) : countVariantsRecursion(staresCount - 1);
        int prev2 = mp.containsKey(staresCount - 2) ? mp.get(staresCount - 2) : countVariantsRecursion(staresCount - 2);
        int ret = prev + prev2;
        mp.put(staresCount, ret);
        return ret;
    }

    //O(n) time, with no recursion
    public static int countVariants(int staresCount) {
        if (staresCount == 0) return 1;
        if (staresCount == 1) return 1;
        int prev = 1, nw = 1, temp;
        for (int i = 1; i < staresCount; i++) {
            temp = prev;
            prev = nw;
            nw += temp;
        }

        return nw;
    }


    //helper functions
    private static void squareMatrix(long[] arr) {
        long a = arr[0], b = arr[1], c = arr[2], d = arr[3];
        arr[0] = a * a + b * c;
        arr[1] = a * b + b * d;
        arr[2] = arr[1];
        arr[3] = c * b + d * d;
    }

    private static void multiplyMatrixWithVector(long[] arr, long[] vec) {
        long vec0 = vec[0], vec1 = vec[1];
        vec[0] = arr[0] * vec0 + arr[1] * vec1;
        vec[1] = arr[2] * vec0 + arr[3] * vec1;
    }
}
