package ru.bordulev.shapes.main;

import ru.bordulev.shapes.*;
import java.util.Arrays;

public class Shape_Main {
    private static Shape getMaxArea(Shape[] shapesArray) {
        Arrays.sort(shapesArray);
        return shapesArray[shapesArray.length - 1];
    }

    private static Shape getMaxPerimeter(Shape[] shapesArray) {
        Arrays.sort(shapesArray);
        return shapesArray[shapesArray.length - 2];
    }

    public static void main(String[] args) {
        System.out.println("----- Square -----");

        Square square = new Square();
        square.setLength(10);

        System.out.println("Square " + square.toString());
        System.out.println("----- Triangle -----");

        Triangle triangle = new Triangle();
        triangle.setLength(2, -3, 1, 1, -6, 5);

        System.out.println("Triangle " + triangle.toString());

        Triangle triangle2 = new Triangle();
        triangle2.setLength(2, -5, -6, 1, 6, -2);

        System.out.println("Triangle2 " + triangle2.toString());

        Triangle triangle3 = new Triangle();
        triangle3.setLength(1, -3, 2, 5, -2, -2);

        System.out.println("Triangle3 " + triangle3.toString());
        System.out.println("----- Rectangle -----");

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(14);

        System.out.println("Rectangle " + rectangle.toString());
        System.out.println("----- Circle -----");

        Circle circle = new Circle();
        circle.setRadius(15);
        System.out.println("circle " + circle.toString());

        Circle circle2 = new Circle();
        circle2.setRadius(15);
        System.out.println("circle2 " + circle2.toString());

        Circle circle3 = new Circle();
        circle3.setRadius(2.5);
        System.out.println("circle3 " + circle3.toString());
        System.out.println("----- Find -----");

        Shape[] arrayShapes = new Shape[]{square, triangle, triangle2, triangle3, rectangle, circle, circle2, circle3};

        System.out.println("Max shape area: " + getMaxArea(arrayShapes).getArea());
        System.out.println("Two max shape perimeter: " + getMaxPerimeter(arrayShapes).getPerimeter());

        System.out.println("----- Equals -----");

        System.out.println("circle = circle3: " + circle.equals(circle3));
        System.out.println("circle = circle2: " + circle.equals(circle2));
        System.out.println("circle = circle: " + circle.equals(circle));
    }
}
