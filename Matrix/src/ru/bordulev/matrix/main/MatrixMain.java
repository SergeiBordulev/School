package ru.bordulev.matrix.main;

import ru.bordulev.matrix.Matrix;
import ru.bordulev.vector.Vector;
import java.util.Arrays;

public class MatrixMain {
    private static Matrix staticMatrixSubtract(Matrix matrix1, Matrix matrix2) {
        int[] sizeMatrix1 = matrix1.getSize();
        Matrix newMatrix = new Matrix(sizeMatrix1[0], sizeMatrix1[1]);

        for (int i = 0; i < sizeMatrix1[0]; i++) {
            double[] tmp1 = matrix1.getVectorRowByIndex(i);
            double[] tmp2 = matrix2.getVectorRowByIndex(i);

            for (int j = 0; j < tmp1.length; j++) {
                tmp1[j] -= tmp2[j];
            }

            Vector vector = new Vector(tmp1);
            newMatrix.setRowVectorByIndex(i, vector);
        }

        return newMatrix;
    }

    private static Matrix staticMatrixAddition(Matrix matrix1, Matrix matrix2) {
        int[] sizeMatrix1 = matrix1.getSize();
        Matrix newMatrix = new Matrix(sizeMatrix1[0], sizeMatrix1[1]);

        for (int i = 0; i < sizeMatrix1[0]; i++) {
            double[] tmp1 = matrix1.getVectorRowByIndex(i);
            double[] tmp2 = matrix2.getVectorRowByIndex(i);

            for (int j = 0; j < tmp1.length; j++) {
                tmp1[j] += tmp2[j];
            }

            Vector vector = new Vector(tmp1);
            newMatrix.setRowVectorByIndex(i, vector);
        }

        return newMatrix;
    }

    private static Matrix staticMatrixMultiplication(Matrix matrix1, Matrix matrix2) {
        int[] sizeMatrix1 = matrix1.getSize();
        Matrix newMatrix = new Matrix(sizeMatrix1[0], sizeMatrix1[1]);

        for (int i = 0; i < sizeMatrix1[0]; i++) {
            double[] tmp1 = matrix1.getVectorRowByIndex(i);
            double[] tmp2 = matrix2.getVectorRowByIndex(i);

            for (int j = 0; j < tmp1.length; j++) {
                tmp1[j] *= tmp2[j];
            }

            Vector vector = new Vector(tmp1);
            newMatrix.setRowVectorByIndex(i, vector);
        }

        return newMatrix;
    }

    public static void main(String[] args) {
        System.out.println("------ Matrix(n, m) ------");
        Matrix matrix1 = new Matrix(2, 2);
        System.out.println(matrix1);

        System.out.println("------ Matrix(double[][]) ------");
        double[][] array = {{1.2, 2.3, 3.4}, {9.8, 8.7, 7.6}};
        Matrix matrix2 = new Matrix(array);
        System.out.println(matrix2);

        System.out.println("------ Matrix(Matrix) ------");
        Matrix matrix3 = new Matrix(matrix2);
        System.out.println(matrix3);

        System.out.println("------ Matrix(Vector[]) ------");
        double[] array21 = {1.2, 3.4, 5.6, 7.8};
        double[] array22 = {2.2, 2.4, 2.6, 2.8};

        Vector vector21 = new Vector(array21);
        Vector vector22 = new Vector(array22);

        Vector[] vector = {vector21, vector22};
        Matrix matrix4 = new Matrix(vector);

        System.out.println(matrix4);

        System.out.println("------ a) Получение размера матрицы ------");
        System.out.println("Size matrix3: " + Arrays.toString(matrix3.getSize()));
        System.out.println("Size matrix4: " + Arrays.toString(matrix4.getSize()));

        System.out.println("------ b) Получение вектора-строки по индексу ------");
        try {
            System.out.println("getVectorRowByIndex: " + Arrays.toString(matrix4.getVectorRowByIndex(1)));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
        }

        System.out.println("------ b) Задание вектора-строки по индексу ------");
        double[] array3 = {1.2, 3.4, 5.6};
        Vector vector3 = new Vector(array3);
        System.out.println(matrix3);

        try {
            matrix3.setRowVectorByIndex(0, vector3);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
        }

        System.out.println(matrix3);

        System.out.println("------ c) Получение вектора-столбца по индексу ------");
        try {
            System.out.println("getVectorColumnByIndex: " + Arrays.toString(matrix4.getVectorColumnByIndex(0)));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
        }

        System.out.println("------ d) Транспонирование матрицы ------");
        matrix2.getMatrixTranspose();
        System.out.println("Matrix after transpose: " + matrix2);

        System.out.println("------ e) Умножение на скаляр ------");
        matrix2.getMultiplicationByScalar(2.0);
        System.out.println("Matrix after multiplicationByScalar: " + matrix2);

        System.out.println("------ f) Вычисление определеителя матрицы ------");

        double[][] array4 = {{1.1, 2.2, 3.3}, {4.4, 5.5, 6.6}, {7.7, 8.8, 9.9}};
        Matrix matrix6 = new Matrix(array4);

        double[][] array5 = {{23.0, 48.0, -52.0}, {-1, -2, -2}, {0, 3, 6}};
        Matrix matrix7 = new Matrix(array5);

        double[][] array8 = {{-1, 2, -3}, {1, 0, -2}, {5, 3, -7}};
        Matrix matrix10 = new Matrix(array8);

        double[][] array9 = {{5, 7, 1}, {-4, 1, 0}, {2, 0, 3}};
        Matrix matrix11 = new Matrix(array9);

        double[][] array10 = {{-2, -3, 0, 2}, {1, -1, 2, 2}, {3, -1, 5, -2}, {0, -2, 4, 1}};
        Matrix matrix12 = new Matrix(array10);

        double[][] array11 = {{-2, -3, 0, 2}, {1, -1, 2, 2}, {3, -1, 5, -2}};
        Matrix matrix13 = new Matrix(array11);

        Matrix[] arrayMatrix = {matrix6, matrix7, matrix10, matrix11, matrix12, matrix13};

        for (Matrix matrix : arrayMatrix) {
            try {
                System.out.println("Minor matrix: " + matrix.minor());
            } catch (IllegalArgumentException e) {
                System.out.println("The Matrix is not square");
            }
        }

        System.out.println("------ h) Умножение матрицы на вектор ------");

        double[] array12 = {1.2, 3.4, 5.6};
        Vector vector4 = new Vector(array12);

        try {
            System.out.println("Multiplying Matrix On Vector: " + matrix11.getMultiplyingOnVector(vector4));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The vector is not equal to the matrix");
        }

        double[][] array14 = {{-2, -3, 0, 2}, {1, -1, 2, 2}, {3, -1, 5, -2}, {3, -1, 5, -2}};
        Matrix matrix14 = new Matrix(array14);
        double[][] array15 = {{-2, -3, 0, 2}, {1, -1, 2, 2}, {3, -1, 5, -2}, {3, -1, 5, -2}};
        Matrix matrix15 = new Matrix(array15);

        System.out.println("------ i) Сложение матриц ------");

        try {
            System.out.println("Addition matrix14 and matrix15: " + matrix14.matrixAddition(matrix15));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
        }

        System.out.println("------ j) Вычитание матриц ------");

        try {
            System.out.println("Subtract matrix14 and matrix15: " + matrix14.matrixSubtract(matrix15));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
        }

        System.out.println("------ static a) Сложение матриц ------");

        try {
            System.out.println("Addition matrix14 and matrix15: " + staticMatrixAddition(matrix14, matrix15));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The Matrix have different sizes");
        }

        System.out.println("------ static b) Вычитание матриц ------");

        try {
            System.out.println("Subtract matrix14 and matrix15: " + staticMatrixSubtract(matrix14, matrix15));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The Matrix have different sizes");
        }

        System.out.println("------ static c) Умножение матриц ------");

        try {
            System.out.println("matrix14 and matrix15: " + staticMatrixMultiplication(matrix14, matrix15));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The Matrix have different sizes");
        }
    }
}
