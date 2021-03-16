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

    @Override
    public String toString() {
        return "(" + from + "; " + to + ")";
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        if (range.from > to) {
            return null;
        }

        return new Range(Math.max(from, range.from), Math.min(range.to, to));
    }

    public Range[] getUnion(Range range) {
        if (range.from < to) {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(range.to, to))};
        }

        return new Range[]{new Range(from, to), new Range(range.from, range.to)};
    }

    public Range[] getDifference(Range range) {
        if (from < range.from && range.to < to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        if (range.from < to) {
            return new Range[]{new Range(from, range.from)};
        }

        return new Range[]{};
    }
}
