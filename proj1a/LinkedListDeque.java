public class LinkedListDeque<T> {

    public class Node {
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
    public LinkedListDeque(T item) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(item, sentinel, null);
        size = 1;
    }

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
        size -= 1;
        if (sentinel.next == null) {
            return null;
        }
        return sentinel.next.item;
    }

    public T removeLast() {
        size -= 1;
        if (sentinel.prev == null) {
            return null;
        }
        return sentinel.prev.item;
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
        if (isEmpty()) {
            return null;
        }
        if (index == 0) {
            return sentinel.next.item;
        }
        sentinel.next = sentinel.next.next;
        return getRecursive(index - 1);
    }
}
