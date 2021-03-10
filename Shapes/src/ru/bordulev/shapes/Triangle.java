package ru.bordulev.shapes;

public class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;
    private double width = getMax(x1, x2, x3) - getMin(x1, x2, x3);
    private double height = getMax(y1, y2, y3) - getMin(y1, y2, y3);

    private double getMax(double b1, double b2, double b3) {
        double max = b1;

        if (max < b2) {
            max = b2;
        }

        if (max < b3) {
            max = b3;
        }

        return max;
    }

    private double getMin(double a1, double a2, double a3) {
        double min = a1;

        if (min > a2) {
            min = a2;
        }

        if (min > a3) {
            min = a3;
        }

        return min;
    }

    public void setLength(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return 0.5 * Math.abs((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3));
    }

    public double getPerimeter() {
        double abVector = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double acVector = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        double bcVector = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

        return abVector + acVector + bcVector;
    }

    @Override
    public int compareTo(Shape o) {
        return (int) (this.getArea() * 100) - (int) (o.getArea() * 100);
    }

    @Override
    public String toString() {
        return "area: " + getArea() + "; perimeter: " + getPerimeter();
    }

    @Override
    public int hashCode() {
        int prime = 7;
        int hash = 1;
        hash = prime * hash + (int) height;
        hash = prime * hash + (int) width;
        return hash;
    }

    @Override
    public boolean equals(Shape shape) {
        if (this == shape) return true;
        if (shape == null) return false;
        if (getClass() != shape.getClass()) return false;
        return height == shape.getHeight() && width == shape.getWidth();
    }
}
