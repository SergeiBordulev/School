package ru.bordulev;

public class Main {
    public static void main(String[] args) {
        Range range = new Range();

        range.setFrom(2.3);
        range.setTo(3.5);

        System.out.printf("From: %.2f To: %.2f Distance: %.2f\n", range.getFrom(), range.getTo(), range.getLength());

        for (double i = range.getFrom() - 0.2; i <= range.getTo() + 1.2; i += 1) {
            System.out.println("The Point (" + i + ") belongs to the line: " + range.isInside(i));
        }

        Range lineOne = new Range(2.3, 7.6);
        Range lineTwo = new Range(4.5, 6.7);

        try {
            System.out.println("Intersection range from: " + lineOne.intersectionRange(lineTwo.getFrom()).getFrom());
            System.out.println("Intersection range to: " + lineOne.intersectionRange(lineTwo.getFrom()).getTo());
            System.out.printf("Distance intersection: %.2f\n", lineOne.intersectionRange(lineTwo.getFrom()).getLength());
        } catch (NullPointerException e) {
            System.out.println("Null, no intersection");
        }

        try {
            Range[] array = lineOne.difference(lineTwo.getFrom(), lineTwo.getTo());
            for (int i = 0; i < array.length; i++) {
                System.out.println(i + 1 + " Difference range from: " + array[i].getFrom());
                System.out.println(i + 1 + " Difference range to: " + array[i].getTo());
            }
        } catch (NullPointerException e) {
            System.out.println("Null");
        }

        Range[] arrayUnion = lineOne.union(lineTwo.getFrom(), lineTwo.getTo());
        for (int i = 0; i < arrayUnion.length; i++) {
            System.out.println(i + 1 + " Range from: " + arrayUnion[i].getFrom());
            System.out.println(i + 1 + " Range to: " + arrayUnion[i].getTo());
        }
    }
}
