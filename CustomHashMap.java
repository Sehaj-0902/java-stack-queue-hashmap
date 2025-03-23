public class CustomHashMap {
    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int SIZE = 10;
    private Node[] buckets;

    public CustomHashMap() {
        buckets = new Node[SIZE];
    }

    // Method to calculate hash index of a key
    private int hash(int key) {
        return key % SIZE;
    }

    // Method to insert elements
    public void put(int key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        }
        else {
            Node current = buckets[index];
            while (current.next != null) {
                if(current.key == key){
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if(current.key == key){
                current.value = value;
                return;
            }
            current.next = newNode;
        }
    }

    // Method to retrieve elements
    public int get(int key) {
        int index = hash(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    // Method to remove elements
    public void remove(int key) {
        int index = hash(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next;
                }
                else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(12, 20);
        map.put(21, 30);

        System.out.println("Accessing elements inserted in hashmap:");
        System.out.println(map.get(1));
        System.out.println(map.get(12));
        System.out.println(map.get(21));

        map.remove(12);

        System.out.println("\nAccessing element after removing it from hashmap:");
        System.out.println(map.get(12));
    }
}

/*
Input:
    map.put(1, 10);
    map.put(12, 20);
    map.put(21, 30);
Output:
    Accessing elements inserted in hashmap:
    10
    20
    30

    Accessing element after removing it from hashmap:
    -1
 */