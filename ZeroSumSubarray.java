import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ZeroSumSubarray {
        // Method to find zero sum subarray
        static List<List<Integer>> findSubarray(int[] array) {
            List<List<Integer>> list = new ArrayList<>();
            HashMap<Integer, List<Integer>> map = new HashMap<>();

            int sum = 0;

            map.put(0, new ArrayList<>());
            map.get(0).add(-1);

            for (int i = 0; i < array.length; i++) {
                sum += array[i];
                if(map.containsKey(sum)) {
                    for (int index : map.get(sum)) {
                        List<Integer> subarray = new ArrayList<>();
                        for (int j = index + 1; j <= i; j++) {
                            subarray.add(array[j]);
                        }
                        list.add(subarray);
                    }
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, -3, -1, 0, 2};
        List<List<Integer>> subarrays = findSubarray(array);

        if (subarrays.isEmpty()) {
            System.out.println("No zero-sum subarrays found.");
        }
        else {
            System.out.println("Zero-sum subarrays:");
            for(List<Integer> sub : subarrays){
                System.out.println(sub);
            }
        }
    }
}

/*
Input:
    int[] array = {4, 2, -3, -1, 0, 2};
Output:
    Zero-sum subarrays:
    [0]
    [2, -3, -1, 0, 2]
 */