package ru.bordulev.shapes.main;

import ru.bordulev.shapes.*;

import java.util.Arrays;

public class ShapeMain {
    private static Shape getShapeFirstLargestArea(Shape[] shapesArray) {
        Arrays.sort(shapesArray, new AreaComparator());
        return shapesArray[shapesArray.length - 1];
    }

    private static Shape getShapeSecondLargestPerimeter(Shape[] shapesArray) {
        Arrays.sort(shapesArray, new PerimeterComparator());
        return shapesArray[shapesArray.length - 2];
    }

    public static void main(String[] args) {
        System.out.println("----- Square -----");

        Square square = new Square(10);
        System.out.println(square);

        System.out.println("----- Triangle -----");

        Triangle triangle = new Triangle(2, -3, 1, 1, -6, 5);
        System.out.println(triangle);

        Triangle triangle2 = new Triangle(2, -5, -6, 1, 6, -2);
        System.out.println(triangle2);

        Triangle triangle3 = new Triangle(1, -3, 2, 5, -2, -2);
        System.out.println(triangle3);

        System.out.println("----- Rectangle -----");

        Rectangle rectangle = new Rectangle(10, 14);
        System.out.println("Rectangle " + rectangle);

        System.out.println("----- Circle -----");

        Circle circle = new Circle(15);
        System.out.println("circle " + circle);

        Circle circle2 = new Circle(15);
        System.out.println("circle2 " + circle2);

        Circle circle3 = new Circle(2.5);
        System.out.println("circle3 " + circle3);

        System.out.println("----- Find -----");

        Shape[] shapes = {
                new Square(6),
                new Triangle(3, 4, 8, 2, 9, 1),
                new Square(10),
                new Rectangle(2, 3),
                new Circle(1),
                new Triangle(1, 2, 6, 2, 1, 4)
        };

        if (shapes.length == 0) {
            System.out.println("The shape array is empty. You can't search for shapes.");
        } else {
            System.out.println("Max shape area: " + getShapeFirstLargestArea(shapes).getArea());
            System.out.println("Two max shape perimeter: " + getShapeSecondLargestPerimeter(shapes).getPerimeter());
        }

        System.out.println("----- Equals -----");

        System.out.println("circle = circle3: " + circle.equals(circle3));
        System.out.println("circle = circle2: " + circle.equals(circle2));
        System.out.println("circle = circle: " + circle.equals(circle));
    }
}
