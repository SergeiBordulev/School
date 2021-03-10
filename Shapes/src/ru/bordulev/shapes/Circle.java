package ru.bordulev.shapes;

public class Circle implements Shape {
    private double width;
    private double height;
    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return radius * 2;
    }

    public double getHeight() {
        return radius * 2;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
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
        return radius == (shape.getHeight() / 2);
    }
}
