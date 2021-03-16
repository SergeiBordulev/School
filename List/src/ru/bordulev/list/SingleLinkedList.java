package ru.bordulev.list;

public class SingleLinkedList<T> {
    private ListItem<T> head;
    private ListItem<T> tail;
    int count;

    public SingleLinkedList() {
        head = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    // 1. ------ Size ------
    public int getListSize() {
        return count;
    }

    // 2. ------ getFirstElement ------
    public T getFirstElement() {
        ListItem<T> temp = head;

        return temp.data;
    }

    // 3. ------ GetValueByIndex ------
    public T getValueByIndex(int index) {
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

        return current.data;
    }

    // 3. ------ Change ------
    public T changeValueByIndex(int index, T data) {
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

        T result = current.data;
        current.data = data;
        return result; // TODO надо чтобы выдавала старое значение
    }

    // 4. ------
    public T remote(int index) {
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

    // 5 ------ add ------
    public void add(T data) {
        ListItem<T> temp = new ListItem<>(data);
        temp.next = head;

        head = temp;
        count++; // Надо понять что он вообще отражает, может он вообще не нужен
    }

    // 6. ------ addByIndex ------
    public void addByIndex(int index, T data) {
        ListItem<T> temp = new ListItem<>(data);

        ListItem previous = head;
        ListItem current = head;
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

        temp.next = current;
        previous.next = temp;
    }

    // 7. ------ remoteByKey
    // TODO вероятно зесь получается NPE, надо обработать выход за пределы списка
    public boolean remoteByKey(T key) {
        ListItem<T> previous = head;
        ListItem<T> current = head;

        while (current.data != key) {
            if (isEmpty()) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }

            if (current == head) {
                head = head.next;
            } else {
                previous.next = current.next;
            }

            count++;
        }

        return true;
    }

    // --- 8 --- Remote First Element
    public T remoteFirst() {
        head = head.next;

        return head.data;
    }

    // -- 9 -- Reverse
    // TODO просто менять ссылки местами
/*
    public void reverse() {
        int count;

        for() {
            temp.next = head;

            head = temp;
            count++;
        }
    }
*/


    // -- 10 -- Copy

    public void copy() {
        SingleLinkedList listNew = new SingleLinkedList();
        ListItem current = head;
        ListItem previous = head;

        while(head != null) {
            listNew.head = current;
            //listNew.data = current.data;

            previous = current;
            current = current.next;
        }

        /*ListItem temp = new ListItem(data);
        temp.next = head;

        head = temp;
        count++;*/
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
