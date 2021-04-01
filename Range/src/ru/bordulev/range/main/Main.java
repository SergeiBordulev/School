package ru.bordulev.range.main;

import ru.bordulev.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(2.3, 3.5);

        System.out.printf("From: %.2f To: %.2f Distance: %.2f%n", range.getFrom(), range.getTo(), range.getLength());

        for (double i = range.getFrom() - 0.2; i <= range.getTo() + 1.2; i += 1) {
            System.out.println("The Point (" + i + ") belongs to the line: " + range.isInside(i));
        }

        Range range1 = new Range(2.3, 5.6);
        Range range2 = new Range(4.5, 6.7);

        System.out.println("Intersection range: " + range1.getIntersection(range2));
        System.out.printf("Length intersection: %.2f%n", range1.getIntersection(range2).getLength());

        Range[] union = range1.getUnion(range2);
        for (int i = 0; i < union.length; i++) {
            System.out.println(i + 1 + " United range: " + union[i]);
        }

        Range[] difference = range1.getDifference(range2);
        for (int i = 0; i < difference.length; i++) {
            System.out.println(i + 1 + " Difference range: " + difference[i]);
        }
    }
}
