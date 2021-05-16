package ru.bordulev.matrix;

import ru.bordulev.vector.Vector;

public class Matrix {
    private int n;
    private int m;
    private double[][] array;
    private double sum;

    public Matrix(int n, int m) {
        if (n <= 0) {
            throw new IllegalArgumentException("Argument must be > 0.");
        }

        this.array = new double[n][m];
    }

    public Matrix(Matrix matrix) {
        this.n = matrix.n;
        this.m = matrix.m;
        this.array = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.array[i][j] = matrix.array[i][j];
            }
        }
    }

    public Matrix(double[][] array) {
        this.n = array.length;
        this.m = array[1].length;
        this.array = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.array[i][j] = array[i][j];
            }
        }
    }

    public Matrix(Vector[] vector) {
        this.n = vector[0].getSize();
        this.array = new double[vector.length][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < vector.length; j++) {
                this.array[j][i] = vector[j].getVectorComponent(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        if (array[1].length == 1) {
            string.append("{ ");

            for (double[] doubles : array) {
                string.append(doubles[0]).append(", ");
            }

            string.replace(string.length() - 2, string.length(), " ");
            string.append("}");
        } else {
            for (int i = 0; i < array.length; i++) {
                string.append("{ ");

                for (int j = 0; j < array[1].length; j++) {
                    string.append(array[i][j]).append(", ");
                }

                string.replace(string.length() - 2, string.length(), " ");
                string.append("}, ");
            }

            string.replace(string.length() - 2, string.length(), "");
        }

        return "{" + string + "}";
    }

    public int[] getSize() {
        int rows = array.length;
        int columns = array[1].length;

        return new int[]{rows, columns};
    }

    public double[] getVectorRowByIndex(int indexRow) {
        int columns = array[1].length;
        int rows = array.length;

        if (rows < indexRow) {
            throw new ArrayIndexOutOfBoundsException("Выход за границы матрицы!");
        }

        double[] result = new double[columns];

        for (int i = 0; i < columns; i++) {
            result[i] = array[indexRow][i];
        }

        return result;
    }

    public void setRowVectorByIndex(int indexRows, Vector vector) {
        if (array.length == vector.getSize() - 1) {
            for (int j = 0; j <= array.length; j++) {
                array[indexRows][j] = vector.getVectorComponent(j);
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public double[] getVectorColumnByIndex(int indexColumn) {
        int columns = array.length;
        int rows = array[0].length;

        if (rows < indexColumn) {
            throw new IllegalArgumentException();
        }

        double[] result = new double[columns];

        for (int i = 0; i < columns; i++) {
            result[i] = array[i][indexColumn];
        }

        return result;
    }

    public void getMatrixTranspose() {
        int columns = array.length;
        int rows = array[1].length;

        double[][] newArray = new double[rows][columns];

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                newArray[j][i] = array[i][j];
            }
        }

        this.array = newArray;
    }

    public void getMultiplicationByScalar(double scalar) {
        int columns = array.length;
        int rows = array[1].length;

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                array[i][j] = array[i][j] * scalar;
            }
        }
    }

    public double minor() {
        if (array.length == array[0].length) {
            getReduction(array, 1);

            return sum;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void getReduction(double[][] subMinor, double elemParentMinor) {
        if (subMinor.length > 1) {
            double[][] tmpMinor = new double[subMinor.length - 1][subMinor[0].length - 1];

            for (int c = 0; c < subMinor[0].length; c++) {
                for (int i = 1; i < subMinor.length; i++) {
                    for (int j = 0; j < subMinor[0].length; j++) {
                        if (j < c)
                            tmpMinor[i - 1][j] = subMinor[i][j];
                        else if (j > c)
                            tmpMinor[i - 1][j - 1] = subMinor[i][j];
                    }
                }

                double paramForSub = Math.pow(-1, c + 2) * subMinor[0][c] * elemParentMinor;
                getReduction(tmpMinor, paramForSub);
            }
        } else
            this.sum += elemParentMinor * subMinor[0][0];
    }

    public Matrix getMultiplyingOnVector(Vector vector) {
        int[] sizeThisMatrix = this.getSize();

        if (sizeThisMatrix[0] == vector.getSize()) {
            Matrix newMatrix = new Matrix(this);

            for (int i = 0; i < array.length; i++) {
                newMatrix.array[0][i] = array[0][i] * vector.getVectorComponent(i);
            }

            return newMatrix;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public Matrix matrixAddition(Matrix matrix2) {
        int[] sizeMatrix2 = matrix2.getSize();
        Matrix newMatrix = new Matrix(sizeMatrix2[0], sizeMatrix2[1]);

        for (int i = 0; i < sizeMatrix2[0]; i++) {
            for (int j = 0; j < sizeMatrix2[1]; j++) {
                newMatrix.array[i][j] = array[i][j] + matrix2.array[i][j];
            }
        }

        return newMatrix;
    }

    public Matrix matrixSubtract(Matrix matrix2) {
        int[] sizeMatrix2 = matrix2.getSize();
        Matrix newMatrix = new Matrix(sizeMatrix2[0], sizeMatrix2[1]);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                newMatrix.array[i][j] = array[i][j] - matrix2.array[i][j];
            }
        }

        return newMatrix;
    }
}
