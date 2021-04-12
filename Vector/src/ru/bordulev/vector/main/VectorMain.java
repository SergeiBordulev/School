package ru.bordulev.vector.main;

import ru.bordulev.vector.Vector;

public class VectorMain {
    private static Vector additionStaticMethod(Vector vector1, Vector vector2) {
        if (vector1.vectorComponents.length > vector2.vectorComponents.length) {
            double[] newVectorComponents = new double[vector1.vectorComponents.length];

            for (int i = 0; i < vector2.vectorComponents.length; i++) {
                newVectorComponents[i] = vector2.vectorComponents[i] + vector1.vectorComponents[i];
            }

            return new Vector(newVectorComponents);
        } else {
            double[] newVectorComponents = new double[vector2.vectorComponents.length];

            for (int i = 0; i < vector1.vectorComponents.length; i++) {
                newVectorComponents[i] = vector2.vectorComponents[i] + vector1.vectorComponents[i];
            }

            return new Vector(newVectorComponents);
        }
    }

    private static Vector subtractionStaticMethod(Vector vector1, Vector vector2) {
        if (vector1.vectorComponents.length > vector2.vectorComponents.length) {
            double[] newVectorComponents = new double[vector1.vectorComponents.length];

            for (int i = 0; i < vector2.vectorComponents.length; i++) {
                newVectorComponents[i] = vector2.vectorComponents[i] - vector1.vectorComponents[i];
            }

            return new Vector(newVectorComponents);
        } else {
            double[] newVectorComponents = new double[vector2.vectorComponents.length];

            for (int i = 0; i < vector1.vectorComponents.length; i++) {
                newVectorComponents[i] = vector2.vectorComponents[i] - vector1.vectorComponents[i];
            }

            return new Vector(newVectorComponents);
        }
    }

    private static double scalar(Vector vector1, Vector vector2) {
        double result = 0;

        for (int i = 0; i < vector2.vectorComponents.length; i++) {
            result += vector2.vectorComponents[i] * vector1.vectorComponents[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("------ Constructor Vector(n): ------");
        //Vector vector1 = new Vector(3);
        System.out.println("Vector(n): " + new Vector(3));

        System.out.println("------ Constructor Vector(double[]): ------");
        double[] array = {1.2, 3.4, 5.6};
        Vector vector2 = new Vector(array);
        System.out.println(vector2);

        System.out.println("------ Constructor Vector(n, double[]): ------");
        Vector vector3 = new Vector(5, array);
        System.out.println(vector3);

        System.out.println("------ Constructor Vector(Vector): ------");
        Vector vector11 = new Vector(vector2);
        System.out.println("Vector11: " + vector11);

        System.out.println("------ Hash Code ------");

        System.out.println("Vector11: " + vector11 + " hashCode vector11: " + vector11.hashCode());
        System.out.println("Vector2: " + vector2 + " hashCode vector2: " + vector2.hashCode());

        System.out.println("------ Equals ------");

        System.out.print("Equals vector11 & vector2 before change: ");
        System.out.println(vector11.equals(vector2));
        System.out.println("vector2: " + vector2);

        vector2.changeVectorComponent(1, 5.5);

        System.out.print("Equals vector11 & vector2 after change: ");
        System.out.println(vector11.equals(vector2));
        System.out.println("vector2: " + vector2);

        System.out.println("------ GetSize ------");
        System.out.print("GetSize: ");
        System.out.println(vector2.getSize());

        System.out.println("------ Get vector components by index: " + vector2.getVectorComponent(1));
        System.out.println("old components: " + vector2);
        vector2.changeVectorComponent(1, 4.3);
        System.out.println("new components: " + vector2);

        System.out.println("------ Addition ------");
        System.out.println("Vector before addition: " + vector2);

        double[] array2 = {9.8, 7.6, 5.4, 3.2, 1.0};
        Vector vector4 = new Vector(array2);
        vector2.additionNonStaticMethod(vector4);

        System.out.println("Vector after addition: " + vector2);

        System.out.println("------ Subtraction ------");
        System.out.println("Vector before subtraction: " + vector2);
        vector2.subtractionNonStaticMethod(vector4);
        System.out.println("Vector after subtraction: " + vector2);

        System.out.println("------ Multiplication ------");
        System.out.println("Vector before multiplication: " + vector2);
        vector2.multiplication(2.0);
        System.out.println("Vector after multiplication: " + vector2);

        System.out.println("------ Reverse ------");
        System.out.println("Vector before reverse: " + vector2);
        vector2.reverse();
        System.out.println("Vector after reverse: " + vector2);

        System.out.println("------ additionStaticMethod ------");
        System.out.println(additionStaticMethod(vector2, vector4));

        System.out.println("------ subtractionStaticMethod ------");
        System.out.println(subtractionStaticMethod(vector2, vector4));

        System.out.println("------ getLength ------");
        double[] array3 = new double[]{2.0, 4.0};
        Vector vector5 = new Vector(array3);
        System.out.println(vector5.getLength());

        System.out.println("------ scalar ------");
        double[] array4 = new double[]{3.0, 5.0};
        Vector vector6 = new Vector(array4);
        System.out.println(scalar(vector5, vector6));
    }
}
