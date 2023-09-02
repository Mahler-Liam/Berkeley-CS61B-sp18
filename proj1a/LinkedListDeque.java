public class LinkedListDeque<T> {

    private class Node {
        private Node prev;
        private Node next;
        private T item;
        
        public Node(T item, Node prev, Node next) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
        public Node(Node prev, Node next) {
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null);
        size = 0;
    }
    // public LinkedListDeque(T item) {
    //     sentinel = new Node(null, null);
    //     sentinel.next = new Node(item, sentinel, null);
    //     size = 1;
    // }

    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        size += 1;
        
    }

    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        size += 1;
        
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            if (sentinel.next == null) {
                return;
            }
            System.out.print(sentinel.next.item + " ");
            sentinel.next = sentinel.next.next;
        }
    }

    public T removeFirst() {
        
        if (sentinel.next == null) {
            return null;
        }
        T removalFirst = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return removalFirst;
    }

    public T removeLast() {
        if (sentinel.prev == null) {
            return null;
        }
        T removalLast = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return removalLast;
    }

    public T get(int index) {
        for (int i = 0; i <= size; i++) {
            if (i == index) {
                break;
            }
            sentinel.next = sentinel.next.next;
        }
        return sentinel.next.item;
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }
    private T getRecursiveHelper(Node current, int index) {
        if (current == null) {
            return null;
        }
        if (index == 0) {
            return current.item;
        }
        return getRecursiveHelper(current.next, index - 1);
    }

    // public static void main(String[] args) {
    //     LinkedListDeque<Integer> test = new LinkedListDeque<>();
    //     test.addFirst(1);
    //     test.addFirst(3);
    //     test.addLast(5);
    //     test.printDeque();
    //     test.removeFirst();
    //     test.removeLast();
    //     test.printDeque();
    // }
}
