package ru.bordulev.shapes;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
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