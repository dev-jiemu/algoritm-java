package src.Books.CodingInterview.TreeAndGraph;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    public T element;
    public Node<T> left;
    public Node<T> right;

    public Node(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public Node(Node<T> left, Node<T> right, T element) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node<T> other) {
        return this.element.compareTo(other.element);
    }
}
