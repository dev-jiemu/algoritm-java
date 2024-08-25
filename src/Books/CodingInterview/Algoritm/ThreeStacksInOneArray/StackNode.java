package src.Books.CodingInterview.Algoritm.ThreeStacksInOneArray;

public class StackNode {
    int value;
    int backLink;

    public StackNode(int value, int backLink) {
        this.value = value;
        this.backLink = backLink;
    }

    @Override
    public String toString() {
        return value + "(back link: " + backLink + ")";
    }
}
