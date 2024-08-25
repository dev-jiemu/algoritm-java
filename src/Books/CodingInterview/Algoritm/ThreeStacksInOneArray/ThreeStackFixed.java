package src.Books.CodingInterview.Algoritm.ThreeStacksInOneArray;

// 충돌 방지를 위해 스택을 적절히 배치해줘야 함 (fix version)
public class ThreeStackFixed {
    private static final int NO_OF_STACKS = 3;    // 고정된 영역의 수

    // 스택 크기
    private final int stackCapacity;

    // 고정된 영역에 있는 노드
    private final int[] values;

    // 고정된 영역
    private final int[] stacks;

    public ThreeStackFixed(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * NO_OF_STACKS];
        stacks = new int[NO_OF_STACKS];
    }

    public void push(int stackNumber, int value) throws Exception {
        if (isFull(stackNumber)) {
            throw new Exception("Stack Overflow");
        }

        stacks[stackNumber]++;
        values[fetchTopIndex(stackNumber)] = value;
    }

    public int pop(int stackNumber) throws Exception {
        if (isEmpty(stackNumber)) {
            throw new Exception("Stack Underflow");
        }

        int topIndex = fetchTopIndex(stackNumber);
        int value = values[topIndex];

        values[topIndex] = 0;
        stacks[stackNumber]--;

        return value;
    }

    public int peek(int stackNumber) throws Exception {
        if (isEmpty(stackNumber)) {
            throw new Exception("Stack Underflow");
        }

        return values[fetchTopIndex(stackNumber)];
    }

    public boolean isEmpty(int stackNumber) {
        return stacks[stackNumber] == 0;
    }

    public boolean isFull(int stackNumber) {
        return stacks[stackNumber] == stackCapacity;
    }

    private int fetchTopIndex(int stackNumber) {
        int offset = stackNumber * stackCapacity;
        int size = stacks[stackNumber];

        return offset + size - 1;
    }

}
