package src.Books.CodingInterview.StackAndQueue;

public class Cell {
    public int r, c, distance; // 거리

    public Cell(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public Cell(int r, int c, int distance) {
        this.r = r;
        this.c = c;
        this.distance = distance;
    }
}