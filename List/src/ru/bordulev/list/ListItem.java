package ru.bordulev.list;

public class ListItem<T> {
    T data;
    ListItem<T> next;

    public ListItem(T data) {
        this.data = data;
    }

    public ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }
}
