package ru.bordulev.vector;

public class Vector {
    public Vector vector;
    public double[] vectorComponents;

    public Vector(int n) {
        this.vectorComponents = new double[n];

        if (n <= 0) {
            throw new IllegalArgumentException("Argument must be > 0.");
        }
    }

    public Vector(Vector vector) {
        this.vectorComponents = new double[vector.vectorComponents.length];

        for (int i = 0; i < vector.vectorComponents.length; i++) {
            this.vectorComponents[i] = vector.vectorComponents[i];
        }
    }

    public Vector(double[] array) {
        vectorComponents = new double[array.length];

        for (int i = 0; i < vectorComponents.length; i++) {
            vectorComponents[i] = array[i];
        }
    }

    public Vector(int n, double[] array) {
        vectorComponents = new double[n];

        for (int i = 0; i < array.length; i++) {
            this.vectorComponents[i] = array[i];
        }
    }

    public int getSize() {
        return this.vectorComponents.length;
    }

    public void additionNonStaticMethod(Vector vector) {
        if (vector.vectorComponents.length > this.vectorComponents.length) {
            double[] newVectorComponents = new double[vector.vectorComponents.length];

            for (int i = 0; i < this.vectorComponents.length; i++) {
                newVectorComponents[i] = this.vectorComponents[i] + vector.vectorComponents[i];
            }

            this.vectorComponents = newVectorComponents;
        } else {
            for (int i = 0; i < vector.vectorComponents.length; i++) {
                this.vectorComponents[i] = this.vectorComponents[i] + vector.vectorComponents[i];
            }
        }
    }

    public void subtractionNonStaticMethod(Vector vector) {
        if (vector.vectorComponents.length > this.vectorComponents.length) {
            double[] newVectorComponents = new double[vector.vectorComponents.length];

            for (int i = 0; i < this.vectorComponents.length; i++) {
                newVectorComponents[i] = this.vectorComponents[i] - vector.vectorComponents[i];
            }

            this.vectorComponents = newVectorComponents;
        } else {
            for (int i = 0; i < vector.vectorComponents.length; i++) {
                this.vectorComponents[i] = this.vectorComponents[i] - vector.vectorComponents[i];
            }
        }
    }

    public void multiplication(double scalarValue) {
        for (int i = 0; i < this.vectorComponents.length; i++) {
            this.vectorComponents[i] = this.vectorComponents[i] * scalarValue;
        }
    }

    public void reverse() {
        for (int i = 0; i < this.vectorComponents.length; i++) {
            this.vectorComponents[i] = this.vectorComponents[i] * -1;
        }
    }

    public double getLength() {
        double length = 0;

        for (double vectorComponent : this.vectorComponents) {
            length += Math.pow(vectorComponent, 2);
        }

        return Math.sqrt(length);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{ ");

        for (double vectorComponent : vectorComponents) {
            string.append(vectorComponent).append(", ");
        }

        return string.substring(0, string.length() - 2) + " }";
    }

    public double getVectorComponent(int index) {
        return vectorComponents[index];
    }

    public void changeVectorComponent(int index, double value) {
        vectorComponents[index] = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Vector vector = (Vector) obj;

        for (int i = 0; i < this.vectorComponents.length; i++) {
            if (this.vectorComponents[i] != vector.vectorComponents[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;
        double components = 0;

        for (double vectorComponent : this.vectorComponents) {
            components += vectorComponent;
        }

        hash = prime * hash + Double.hashCode(components);

        return hash;
    }
}
