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
        System.arraycopy(items, 0, a, 0, size);
        items = a;
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
            System.out.print(items[i] + " ");
            index = (index + 1) % items.length;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T removalFirst = items[front];
        front = (front + 1) % items.length;
        size -= 1;
        return removalFirst;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T removalLast = items[rear];
        rear = (rear - 1 + items.length) % items.length;
        size -= 1;
        return removalLast;
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        return items[index];
    }
}
