import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSequence {
    // Method to find longest consecutive sequence
    static List<Integer> findLongestConsecutiveSequence(int[] array) {
        Map<Integer,Integer> map = new HashMap<>();

        List<Integer> longestSequence = new ArrayList<>();

        int maxLength = 0;

        for (int number : array) {
            map.put(number, 1);
        }

        for (int number : array) {
            if (!map.containsKey(number - 1)) {
                int currentNum = number;
                int currentLength = 1;
                List<Integer> currentSequence = new ArrayList<>();
                currentSequence.add(number);

                while (map.containsKey(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                    currentSequence.add(currentNum);
                }

                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    longestSequence = currentSequence;
                }
            }
        }

        if(longestSequence.size()>1){
            for (int i = 0; i < longestSequence.size() - 1; i++) {
                for (int j = 0; j < longestSequence.size() - i - 1; j++) {
                    if (longestSequence.get(j) > longestSequence.get(j + 1)) {
                        int temp = longestSequence.get(j);
                        longestSequence.set(j, longestSequence.get(j + 1));
                        longestSequence.set(j + 1, temp);
                    }
                }
            }
        }
        return longestSequence;
    }

    public static void main(String[] args) {
        int[] array = {7, 2, 3, 4, 5, 8, 9};

        System.out.println("Longest consecutive sequence: " + findLongestConsecutiveSequence(array));
    }
}

/*
Input:
    int[] array = {7, 2, 3, 4, 5, 8, 9};
Output:
    Longest consecutive sequence: [2, 3, 4, 5]
*/