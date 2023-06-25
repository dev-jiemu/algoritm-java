package src.Queue;

// 링버퍼로 큐 구현하기
public class IntQueue {
    private int[] que;
    private int capacity;
    private int front; //맨 앞 커서
    private int rear; //맨 뒤 커서
    private int num; //현재 데이터 개수

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public IntQueue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;

        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            capacity = 0;
        }
    }

    // enque : 데이터 인큐 후 인큐한 데이터를 리턴함
    // num >= capacity == OverflowException
    public int enque(int x) throws OverflowIntQueueException {
        if (num >= capacity) {
            throw new OverflowIntQueueException();
        }

        que[rear++] = x; // 마지막 인덱스 값 증가
        num++; // 현재 개수 증가

        if (rear == capacity) { // 총 크기가 달라지면 rear 커서를 맨 앞으로 변경함
            rear = 0;
        }

        return x;
    }

    // deque : 데이터 디큐 후 데이터 리턴
    // num <= 0 발생시 EmptyException
    public int deque() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }

        int x = que[front++];
        num--;

        if (front == capacity) { // 총 크기와 같아지면 front 위치를 맨 앞 커서로 변경함
            front = 0;
        }

        return x;
    }

    // peek
    public int peek() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }

        return que[front];
    }

    // clear
    public void clear() {
        num = front = rear = 0;
    }

    // indexOf
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            // 스캔은 큐의 논리적 첫 요소인 front 에서 부터 시작되기 때문
            int idx = (i + front) % capacity;
            if (que[idx] == x) {
                return idx;
            }
        }

        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= capacity;
    }

    public void dump() {
        if (num <= 0) {
            System.out.println("큐가 비어 있습니다.");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[(i + front) % capacity] + " ");
            }
            System.out.println();
        }
    }
}
