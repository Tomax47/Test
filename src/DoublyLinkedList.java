import java.io.*;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public static class Node<T> {
        public T data;
        private Node<T> previous;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void fromArray(T[] array) {
        clear();
        if (array == null || array.length == 0) {
            return;
        }
        for (T item : array) {
            add(item);
        }
    }

    public void add(T item) {
        Node<T> newNode = new Node<>(item);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertAfter(T existingItem, T newItem) {
        Node<T> currentNode = head;

        while (currentNode != null && !currentNode.data.equals(existingItem)) {
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            throw new IllegalArgumentException("Couldn't find the item!");
        }

        Node<T> newNode = new Node<>(newItem);
        newNode.previous = currentNode;
        newNode.next = currentNode.next;

        if (currentNode.next != null) {
            currentNode.next.previous = newNode;
        }

        currentNode.next = newNode;

        if (currentNode == tail) {
            tail = newNode;
        }
    }

    public void remove(T item) {
        Node<T> currentNode = head;

        while (currentNode != null && !currentNode.data.equals(item)) {
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            throw new IllegalArgumentException("Item not found in the list");
        }

        if (currentNode.previous != null) {
            currentNode.previous.next = currentNode.next;
        } else {
            head = currentNode.next;
        }

        if (currentNode.next != null) {
            currentNode.next.previous = currentNode.previous;
        } else {
            tail = currentNode.previous;
        }
    }

    public void display() {
        Node<T> currentNode = head;

        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void sort() {
        if (head == null || head == tail) {
            return;
        }

        Node<T> currentNode = head.next;

        while (currentNode != null) {
            Node<T> keyNode = currentNode;
            T key = keyNode.data;

            Node<T> prevNode = keyNode.previous;
            while (prevNode != null && keyNode.data instanceof Comparable &&
                    ((Comparable) prevNode.data).compareTo(key) > 0) {
                prevNode.next.data = prevNode.data;
                prevNode = prevNode.previous;
            }

            if (prevNode == null) {
                head.data = key;
            } else {
                prevNode.next.data = key;
            }

            currentNode = currentNode.next;
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }
}
