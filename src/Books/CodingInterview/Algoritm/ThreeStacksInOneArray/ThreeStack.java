package src.Books.CodingInterview.Algoritm.ThreeStacksInOneArray;

public class ThreeStack {
    private static final int STACK_CAPACITY = 15; // 최대 15개

    private final StackNode[] theArray;

    // 스택 크기
    private int size;
    // 다음 빈 슬롯 표기
    private int nextFreeSlot;

    private final int[] backLinks = {-1, -1, -1}; // 부모노드 체크용

    public ThreeStack() {
        this.theArray = new StackNode[STACK_CAPACITY];
        this.initializeSlots();
    }

    private void initializeSlots() {
        for (int i = 0; i < STACK_CAPACITY; i++) {
            theArray[i] = new StackNode(0, i + 1);
        }
    }

    public void push(int stackNumber, int value) throws Exception {
        if (stackNumber < 1 || stackNumber > 3) {
            throw new Exception("Choose between stack number 1, 2 or 3");
        }

        int stack = stackNumber - 1;
        int free = fetchIndexOfFreeSlot();
        int top = backLinks[stack];

        StackNode node = theArray[free];

        node.value = value;
        node.backLink = top;

        backLinks[stack] = free;
    }

    private int fetchIndexOfFreeSlot() {
        int free = nextFreeSlot;

        nextFreeSlot = theArray[free].backLink; // 배열에 다음 빈슬롯 설정함
        size++;

        return free;
    }

    public StackNode pop(int stackNumber) throws Exception {
        if (stackNumber < 1 || stackNumber > 3) {
            throw new Exception("Choose between stack number 1, 2 or 3");
        }

        int stack = stackNumber - 1;
        int top = backLinks[stack];

        if (top == -1) {
            throw new Exception("Stack underflow");
        }

        StackNode node = theArray[top];
        backLinks[stack] = node.backLink;
        freeSlot(top);

        return node;
    }

    private void freeSlot(int index) {
        theArray[index].backLink = nextFreeSlot;
        nextFreeSlot = index;
        size--;
    }

}
