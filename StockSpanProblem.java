import java.util.Stack;

public class StockSpanProblem {
    // Method to calculate stock span
    public static int[] calculateStockSpan(int[] stockPrices) {
        int[] span = new int[stockPrices.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < span.length; i++) {
            while (!stack.isEmpty() && stockPrices[i] >= stockPrices[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                span[i] = i+1;
            }
            else {
                span[i] = i - stack.peek();
            }

            stack.push(i);
        }
        return span;
    }
    public static void main(String[] args) {
        int[] stockPrices = {2, 10, 70, 36, 12, 143};

        int[] span = calculateStockSpan(stockPrices);

        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}

/*
Input:
    {2, 10, 70, 36, 12, 143}
Output:
    1 2 3 1 1 6
*/