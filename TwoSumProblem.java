import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    // Method to find indices of the pair whose sum is equal to the target sum
    static int[] findPairIndices(int[] array, int targetSum) {
        int[] indices = new int[2];
        indices[0] = indices[1] = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            int complement = targetSum - number;
            if (map.containsKey(complement)) {
                indices[0] = map.get(complement);
                indices[1] = i;
                return indices;
            }

            map.put(array[i], i);
        }
        return indices;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 5, 6, 10, 8};
        int targetSum = 16;

        int[] result = findPairIndices(array, targetSum);
        System.out.println("Pair with target sum exists at indices [" + result[0] + ", " + result[1] + "]" );
    }
}

/*
Input:
    int[] array = {1, 4, 5, 6, 10, 8};
    int targetSum = 16;
Output:
    Pair with target sum exists at indices [3, 4]
 */