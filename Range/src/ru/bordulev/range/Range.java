package ru.bordulev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public String toString() {
        return from + "; " + to;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range2) {
        if (from < range2.from && range2.from < to) {
            return new Range(range2.from, to);
        }

        return null;
    }

    public Range[] getUnion(Range range2) {
        if (from < range2.from && range2.from < to) {
            if (range2.to < to) {
                return new Range[]{new Range(from, to)};
            }

            return new Range[]{new Range(from, range2.to)};
        }

        return new Range[]{new Range(from, to), new Range(range2.from, range2.to)};
    }

    public Range[] getDifference(Range range2) {
        if (to == range2.from) {
            return new Range[]{new Range(from, to), new Range(range2.from, range2.to)};
        }

        if (from < range2.from && range2.from < to) {
            return new Range[]{new Range(from, range2.from)};
        }

        return new Range[]{};
    }
}
