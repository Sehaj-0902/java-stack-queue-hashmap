import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> enQueueStack = new Stack<>();
    Stack<Integer> deQueueStack = new Stack<>();

    // Method to perform enqueue operation
    public void enQueue(int data) {
        while (!enQueueStack.isEmpty()) {
            deQueueStack.push(enQueueStack.pop());
        }
        enQueueStack.push(data);

        while (!deQueueStack.isEmpty()) {
            enQueueStack.push(deQueueStack.pop());
        }
    }

    // Method to perform dequeue operation
    public int deQueue() {
        if (enQueueStack.isEmpty()) {
            return -1;
        }

        int data = enQueueStack.peek();
        enQueueStack.pop();
        return data;
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack() ;
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        System.out.println("Queue Elements");
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

    }
}

/*
Output:
    Queue Elements
    1
    2
    3
 */