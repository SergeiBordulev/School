package ru.bordulev.shapes;

public interface Shape extends Comparable<Shape> {
    double getWidth();

    double getHeight();

    double getArea();

    double getPerimeter();

    String toString();

    int hashCode();

    boolean equals(Shape shape);
}



