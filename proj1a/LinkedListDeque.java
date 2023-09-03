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
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    // public LinkedListDeque(T item) {
    //     sentinel = new Node(null, null);
    //     sentinel.next = new Node(item, sentinel, null);
    //     size = 1;
    // }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
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
        Node currentNode = sentinel.next;
        while (currentNode != sentinel) {
            System.out.println(currentNode.item + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node firstNode = sentinel.next;
        T removal = firstNode.item;
        sentinel.next = firstNode.next;
        firstNode.next.prev = sentinel;
        firstNode.prev = null;
        firstNode.next = null;
        size -= 1;
        return removal;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node lastNode = sentinel.prev;
        T removal = lastNode.item;
        sentinel.prev = lastNode.prev;
        lastNode.prev.next = sentinel;
        lastNode.prev = null;
        lastNode.next = null;
        size -= 1;
        return removal;
    }

    public T get(int index) {
        Node currentNode = sentinel.next;
        if (index >= size) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.item;
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

}
