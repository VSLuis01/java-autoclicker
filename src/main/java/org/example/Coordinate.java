package org.example;

public record Coordinate(int x, int y) {

    static Coordinate of(int x, int y) {
        return new Coordinate(x, y);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
