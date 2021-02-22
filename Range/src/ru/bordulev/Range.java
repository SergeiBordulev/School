package ru.bordulev;

class Range {
    private double from;
    private double to;

    Range() {
    }

    Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    double getFrom() {
        return from;
    }

    void setFrom(double from) {
        this.from = from;
    }

    double getTo() {
        return to;
    }

    void setTo(double to) {
        this.to = to;
    }

    double getLength() {
        return to - from;
    }

    boolean isInside(double number) {
        return number >= from && number <= to;
    }

    Range intersectionRange(double from) {
        if (isInside(from)) {
            return new Range(from, getTo());
        }

        return null;
    }

    Range[] union(double twoFrom, double twoTo) {
        if (isInside(twoFrom)) {
            return new Range[]{new Range(from, twoTo)};
        }

        return new Range[]{new Range(from, to), new Range(twoFrom, twoTo)};
    }

    Range[] difference(double twoFrom, double twoTo) {
        if (from < twoFrom && twoTo < to) {
            return new Range[]{new Range(from, twoFrom), new Range(twoTo, to)};
        }

        if (isInside(twoFrom)) {
            return new Range[]{new Range(from, twoFrom)};
        }

        return null;
    }
}
