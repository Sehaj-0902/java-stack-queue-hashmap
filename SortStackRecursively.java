import java.util.Stack;

public class SortStackRecursively {
    // Method to sort stack elements
    static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();

        sortStack(stack);

        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty() && stack.peek() < top) {
            temp.push(stack.pop());
        }

        stack.push(top);

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(12);
        stack.push(-4);
        stack.push(20);
        stack.push(0);

        // Calling sortStack() method to sort stack elements
        sortStack(stack);

        System.out.print("Sorted Stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}

/*
Output:
    Sorted Stack: -4 0 1 12 20
 */