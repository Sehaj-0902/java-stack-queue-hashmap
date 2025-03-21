import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMaximum {
    // Method to find maximum element of each window
    static ArrayList<Integer> findMaximum(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        for (int i = k; i < arr.length; ++i) {
            result.add(arr[deque.peekFirst()]);

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        result.add(arr[deque.peekFirst()]);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 7, 3};
        int k = 3;

        ArrayList<Integer> res = findMaximum(arr, k);

        for (int maximum : res) {
            System.out.print(maximum + " ");
        }
    }
}

/*
Input:
    arr = {1, 3, 2, 1, 7, 3}
    k = 3
Output:
    3 3 7 7
 */