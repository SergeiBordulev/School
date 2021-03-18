package ru.bordulev.shapes;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    public int compare(Shape a, Shape b) {
        return Double.compare(a.getArea(), b.getArea());
    }
}
