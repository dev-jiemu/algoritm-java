package src.Stack;

public class IntStack {
    private int[] stk;
    private int capacity;
    private int ptr; // 스택 포인터

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    public IntStack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[maxlen];
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            capacity = 0;
        }
    }

    // 메서드 반환값 : push한 값
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= capacity) {
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }

        return stk[--ptr];
    }

    // 맨 윗 스택 확인하는 method
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }

        return stk[ptr-1];
    }

    public void clear() {
        ptr = 0;
    }

    // 스택에서 검색하기
    public int indexOf(int x) {
        for (int i=ptr-1; i >= 0; i--) {
            if (stk[i] == x) {
                return i;
            }
        }

        return -1;
    }

    // 용량확인
    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= capacity;
    }

    // 스택 안의 모든 데이터를 바닥에서 꼭대기 순으로 출력함
    public void dump() {
        if (ptr <= 0) {
            System.out.println("스택이 비어있습니다.");
        } else {
            for (int i = 0; i < ptr; i++) {
                System.out.println(stk[i] + " ");
            }
            System.out.println();
        }
    }
}
