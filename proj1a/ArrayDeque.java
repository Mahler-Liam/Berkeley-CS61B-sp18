public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int front;
    private int rear;
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        front = 0;
        rear = 0;
    }
    private void resize(int capacity) {
        T[] a = (T []) new Object[capacity];
        for (int i = 0; i < size; i++) {
            a[i] = items[(front + i) % items.length];
        }
        items = a;
        front = 0;
        rear = size - 1;
    }
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        front = (front - 1 + items.length) % items.length;
        items[front] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        rear = (rear + 1) % items.length;
        items[rear] = item;
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
        if (isEmpty()) {
            return;
        }
        int index = front;
        for (int i = 0; i < size; i++) {
            System.out.print(items[(index + i) % items.length] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T removalFirst = items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        size -= 1;
        if (size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return removalFirst;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T removalLast = items[rear];
        items[rear] = null;
        rear = (rear - 1 + items.length) % items.length;
        size -= 1;
        if (size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return removalLast;
    }

    public T get(int index) { 
        if (isEmpty()) {
            return null;
        }
        if (index >= size) {
            return null;
        }
        index = (front + index) % items.length;
        return items[index];
    }
}
