package ru.bordulev.list.main;

import ru.bordulev.list.SingleLinkedList;

public class SingleLinkedListMain {
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
        int index = 2;
        System.out.println("3. Index value by (" + index + ") : " + list.getValueByIndex(index));
        System.out.println("Возвращаемое (старое значение) значение: " + list.changeValueByIndex(2, 7));
        System.out.print("List after change: ");
        list.print();

        // 4. Удаление элемента по индексу, пусть выдает значение элемента
        System.out.println("4. Удаление элемента по индексу, пусть выдает значение элемента");
        System.out.print("Before remove: ");
        list.print();
        System.out.println(list.removeByIndex(1));
        System.out.print("After remove: ");
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

        // 7. Удаление узла по значению, пусть выдает true, если элемент был удален
        System.out.println("7. Удаление узла по значению, пусть выдает true, если элемент был удален");
        System.out.print("Before remove: ");
        list.print();
        System.out.println("Remove by key: " + list.removeByKey(5));
        System.out.print("After remove: ");
        list.print();

        // 8. Удаление первого элемента, пусть выдает значение элемента
        System.out.println("8. Удаление первого элемента, пусть выдает значение элемента");
        System.out.print("Before remove: ");
        list.print();
        System.out.println("Remote first item: " + list.removeFirstItem());
        System.out.print("After remove: ");
        list.print();

        // 9. Разворот списка за линейное время
        System.out.print("9. Before reverse: ");
        list.print();
        list.reverse();
        System.out.print("9. After reverse: ");
        list.print();

        // 10. Copy
        SingleLinkedList<Integer> newList = new SingleLinkedList<>();

        System.out.print("10. Before copy: ");
        list.print();
        list.copy(newList);
        System.out.print("10. After copy, new list: ");
        newList.print();
    }
}
