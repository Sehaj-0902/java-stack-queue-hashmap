import java.util.HashMap;
import java.util.Map;

public class CheckPairSum {
    static boolean pairExists(int[] array, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();

        if (array.length < 2) {
            return false;
        }

        for (int number : array) {
            map.put(number, map.getOrDefault(number,0) + 1);
        }

        for (int number : array) {
            int complement = targetSum - number;
            if (map.containsKey(complement)) {
                if (complement == number) {
                    if (map.get(number) > 1) {
                        return true;
                    }
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 5, 6, 10, 8};
        int targetSum = 16;

        if (pairExists(array, targetSum)) {
            System.out.println("Pair with target sum " + targetSum + " exists.");
        } else {
            System.out.println("Pair with target sum " + targetSum + " does not exist.");
        }
    }
}

/*
Input:
    int[] array = {1, 4, 5, 6, 10, 8};
    int targetSum = 16;
Output:
    Pair with target sum 16 exists.
 */