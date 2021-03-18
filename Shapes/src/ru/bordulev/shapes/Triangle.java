package ru.bordulev.shapes;

public class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    private static double getMax(double b1, double b2, double b3) {
        double max = b1;

        if (max < b2) {
            max = b2;
        }

        if (max < b3) {
            max = b3;
        }

        return max;
    }

    private static double getMin(double a1, double a2, double a3) {
        double min = a1;

        if (min > a2) {
            min = a2;
        }

        if (min > a3) {
            min = a3;
        }

        return min;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getX3() {
        return x3;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    public double getY3() {
        return y3;
    }

    @Override
    public double getWidth() {
        return getMax(x1, x2, x3) - getMin(x1, x2, x3);
    }

    @Override
    public double getHeight() {
        return getMax(y1, y2, y3) - getMin(y1, y2, y3);
    }

    private static double getLength(double a1, double b1, double a2, double b2) {
        return Math.sqrt((a2 - a1) * (a2 - a1) + (b2 - b1) * (b2 - b1));
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3));
    }

    @Override
    public double getPerimeter() {
        double abLength = getLength(x1, y1, x2, y2);
        double acLength = getLength(x1, y1, x3, y3);
        double bcLength = getLength(x2, y2, x3, y3);

        return abLength + acLength + bcLength;
    }

    @Override
    public String toString() {
        return "Triangle with coordinates X1: " + x1 + "; Y1: " + y1 + "; Y2: " + x2 + "; Y2: " + y2 + "; X3: " + x3 + "; Y3: " + y3;
    }

    @Override
    public int hashCode() {
        int prime = 7;
        int hash = 1;
        hash = prime * hash + (int) (x1 + y1 + x2 + y2 + x3 + y3);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) obj;
        return x1 == triangle.x1 && y1 == triangle.y1 && x2 == triangle.x2 && y2 == triangle.y2 && x3 == triangle.x3 && y3 == triangle.y3;
    }
}
