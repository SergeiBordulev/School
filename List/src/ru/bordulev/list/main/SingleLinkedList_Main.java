package ru.bordulev.list.main;

import ru.bordulev.list.SingleLinkedList;

public class SingleLinkedList_Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(6);

        System.out.print("List: ");
        list.print();

        // 1. ------ Size ------ // Полечение размера списка
        System.out.println("1. Size: " + list.getListSize());

        // 2. ------ getFirstElement ------ // Получение значения первого элемента
        System.out.println("2. First element: " + list.getFirstElement());

        // 3. Получение/Изменение значения п указанногому индексу. Изменение значения по индексу пусть выдает старое значение.
        list.print();
        int index = 2;
        System.out.println("3. Index value by (" + index + ") : " + list.getValueByIndex(index));
        System.out.println("Возвращаемое (старое значение) значение: " + list.changeValueByIndex(2, 7));
        System.out.print("Список после изменениея: ");
        list.print();

        // 4. Удаление элемента по индексу, пусть выдает значение элемента
        System.out.println("4. Удаление элемента по индексу, пусть выдает значение элемента");
        System.out.print("Before remote: ");
        list.print();
        System.out.println(list.remote(1));
        System.out.print("After remote: ");
        list.print();

        // 5. Вставка элемента в начало
        System.out.println("5. Вставка элемента в начало");
        System.out.print("Before insert: ");
        list.print();
        list.add(99);
        System.out.print("After insert: ");
        list.print();

        // 6. Вставка элемента по индексу
        System.out.println("6. Вставка элемента по индексу");
        System.out.print("Before insert: ");
        list.print();
        list.addByIndex(3, 8);
        System.out.print("After insert: ");
        list.print();

        // 7. Удаление узла по значению, пусть выдает true, если элемент был удален // TODO Доработать чтобы выдавало false
        System.out.println("7. Удаление узла по значению, пусть выдает true, если элемент был удален");
        System.out.print("Before remote: ");
        list.print();
        System.out.println("Удаление по ключу: " + list.remoteByKey(7));
        System.out.print("After remote: ");
        list.print();

        // 8. Удаление первого элемента, пусть выдает значение элемента
        System.out.println("8. Удаление первого элемента, пусть выдает значение элемента");
        System.out.print("Before remote: ");
        list.print();

        System.out.println("Удаление первого элемента: " + list.remoteFirst());

        System.out.print("After remote: ");
        list.print();

        // 9. Разворот списка за ленейное время
        // TODO просто менять ссылки местами
        System.out.print("Before reverse: ");
        list.print();
        // list.reverse();
        System.out.print("After reverse: ");
        list.print();

        // 10. Копирование списка
        SingleLinkedList<Integer> listNew = new SingleLinkedList<>();

        System.out.print("Before copy: ");
        list.print();
        list.copy();
        System.out.print("After copy: ");
        listNew.print();

        // ------ Print list
        // System.out.println("Print list: " + list.toString());

        /*
        // ------ Add -----
       // ListItem<Integer> head;
        ListItem<Integer> p = new ListItem<>(3, head);
        head = p;

        // ------ Delete ------
        // head = head.getNext();

        // ------ Print ------
        for (ListItem<Integer> p = head; p != null; p = p.getNext()) {
            System.out.println(p.getData());
        }*/


        // ------ Generics ------
       /* List<Integer> list = new ArrayList<>();
        list.add(5);
        Integer x = list.get(0);
        System.out.println("x: " + x);
        System.out.println("Print list:");
        System.out.println(list);*/


    }
}
