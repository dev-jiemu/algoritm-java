package src.Books.CodingInterview.TreeAndGraph;

public class Node<T> {
    public T element;
    public Node left;
    public Node right;

    public Node(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public Node(Node left, Node right, T element) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}