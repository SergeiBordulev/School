package ru.bordulev.list;

public class SingleLinkedList<T> {
    private ListItem<T> head;
    private ListItem<T> tail;
    private int count;

    public SingleLinkedList() {
        head = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    // --- 1 ---
    public int getListSize() {
        return count;
    }

    // --- 2 ---
    public T getFirstElement() {
        ListItem<T> temp = head;

        return temp.data;
    }

    // --- 3 --- GetValueByIndex
    public T getValueByIndex(int index) {
        ListItem<T> current = head;
        int count = 0;

        while (count != index) {
            if (isEmpty()) {
                System.out.println("List is empty.");
            } else {
                current = current.next;
            }

            count++;
        }

        return current.data;
    }

    // --- 3 --- Change
    public T changeValueByIndex(int index, T data) {
        ListItem<T> current = head;
        int count = 0;

        while (count != index) {
            if (isEmpty()) {
                System.out.println("List is empty.");
            } else {
                current = current.next;
            }

            count++;
        }

        T result = current.data;
        current.data = data;
        return result;
    }

    // --- 4 ---
    public T removeByIndex(int index) {
        ListItem<T> previous = head;
        ListItem<T> current = head;
        int count = 0;

        while (count != index) {
            if (isEmpty()) {
                System.out.println("List is empty.");
                return null;
            } else {
                previous = current;
                current = current.next;
            }

            count++;
        }

        previous.next = current.next;
        return current.data;
    }

    // --- 5 ---
    public void add(T data) {
        ListItem<T> temp = new ListItem<>(data);
        temp.next = head;

        head = temp;
        count++;
    }

    // --- 6 ---
    public void addByIndex(int index, T data) {
        ListItem<T> temp = new ListItem<>(data);
        ListItem<T> previous = head;
        ListItem<T> current = head;
        int count = 0;

        while (count != index) {
            if (isEmpty()) {
                System.out.println("List is empty.");
            } else {
                previous = current;
                current = current.next;
            }

            count++;
        }

        previous.next = temp;
        temp.next = current;
    }

    // --- 7 ---
    public boolean removeByKey(T key) {
        ListItem<T> previous = head;
        ListItem<T> current = head;

        if (isEmpty()) {
            return false;
        } else {
            while (current != null) {
                if (current.data == key) {
                    count--;

                    if (current == head) {
                        head = head.next;
                    } else {
                        previous.next = current.next;
                    }

                    return true;
                }

                previous = current;
                current = current.next;
            }
        }

        return false;
    }

    // --- 8 --- Remote First Element
    public T removeFirstItem() {
        head = head.next;
        count--;

        return head.data;
    }

    // -- 9 -- Reverse
    public void reverse() {
        ListItem<T> previous = head;
        ListItem<T> current = head.next;
        head.next = null;
        ListItem<T> nextElement = current.next;

        while (nextElement.next != null) {
            current.next = previous;
            previous = current;
            current = nextElement;
            nextElement = current.next;
        }

        current.next = previous;
        head = nextElement;
        nextElement.next = current;
    }

    // -- 10 -- Copy
    private void addToEnd(T data) {
        ListItem<T> newListItem = new ListItem<>(data);
        newListItem.data = data;

        if (isEmpty()) {
            head = newListItem;
            tail = newListItem;
        } else {
            tail.next = newListItem;
            tail = newListItem;
        }
    }

    public void copy(SingleLinkedList<T> destination) {
        ListItem<T> current = head;

        while (current != null) {
            T temp = current.data;
            destination.addToEnd(temp);
            current = current.next;
        }
    }

    public void print() {
        ListItem temp = head;

        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }

        System.out.println();
    }
}
