package src.Crawling;

import org.jsoup.nodes.Node;

import java.util.*;

public class WikiNodeIterator implements Iterator<Node> {

    Deque<Node> stack;

    public WikiNodeIterator(Node node) {
        stack = new ArrayDeque<Node>();
        stack.push(node);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Node next() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }

        Node node = stack.pop();
        List<Node> nodes = new ArrayList<>(node.childNodes());
        Collections.reverse(nodes);
        for (Node child: nodes) {
            stack.push(child);
        }

        return node;
    }
}
