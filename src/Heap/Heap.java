package src.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

// https://st-lab.tistory.com/205
// 힙 만들어보기
public class Heap<E> {
    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10; // 최대 용적 크기

    private int size;
    private Object[] array;

    public Heap(Comparator<? super E> comparator) {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    public Heap(int capacity, Comparator<? super E> comparator) {
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    // 받은 인덱스의 부모 노드 인덱스를 반환
    private int getParent(int index) {
        return index / 2;
    }

    // 받은 인덱스의 왼쪽 자식 노드 인덱스를 반환
    private int getLeftChild(int index) {
        return index * 2;
    }

    // 받은 인덱스의 오른쪽 자식 노드 인덱스를 반환
    private int getRightChild(int index) {
        return index * 2 + 1;
    }

    // resize
    private void resize(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        for (int i = 1; i <= size; i++) {
            newArray[i] = array[i];
        }

        this.array = null;
        this.array = newArray;
    }

    /*
        Heap의 삽입은 아래 두가지 케이스로 나뉨
        1. 사용자가 Comparator을 사용해서 정렬 방법을 Heap 생성 단계에서 넘겨받은 경우 (Comparator is not null)
        2. 클래시 내에 정렬 방식을 Comparable로 구현했거나 기본 정렬 방식을 따를때 (Comparator is null)

        배열의 마짐가 부분에 원소를 넣고, 부모노드를 찾아가면서 부모노드가 자식노드보다 작을때 요소를 교환함. (sift-up)
     */
    public void add(E value) {
        if (size + 1 == array.length) {
            resize(array.length * 2); // 배열이 꽉차있으면 2배로 확대함
        }

        siftUp(size + 1, value);
        size++;
    }

    private void siftUp(int idx, E target) {
        if (comparator != null) {
            siftUpComparator(idx, target, comparator);
        } else {
            siftUpComparable(idx, target);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {

        // root 노드가 클때까지만 검색함
        while (idx > 1) {
            int parent = getParent(idx);
            Object parentVal = array[parent];

            // 타겟 노드 값이 부모노드보다 크면 반복문 종료
            if (comp.compare(target, (E) parentVal) >= 0) {
                break;
            }

            array[idx] = parentVal;
            idx = parent;
        }

        array[idx] = target;
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int idx, E target) {

        Comparable<? super E> comp = (Comparable<? super E>) target;

        while(idx > 1) {
            int parent = getParent(idx);
            Object parentVal = array[parent];

            if(comp.compareTo((E)parentVal) >= 0) {
                break;
            }
            array[idx] = parentVal;
            idx = parent;
        }
        array[idx] = comp;
    }

    @SuppressWarnings("unchecked")
    public E remove() {
        if(array[1] == null) {	// root이 null일때
            throw new NoSuchElementException();
        }

        E result = (E) array[1];
        E target;
        if(size == 1) {
            target = null;
        }
        else {
            target = (E) array[size];
        }
        array[size] = null;	// 타겟 노드 삭제

        siftDown(1, target);

        return result;
    }

    private void siftDown(int idx, E target) {
        if(comparator != null) {
            siftDownComparator(idx, target, comparator);
        }
        else {
            siftDownComparable(idx, target);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparator(int idx, E target, Comparator<? super E> comp) {

        array[idx] = null;
        size--;

        int parent = idx;
        int child;

        // 왼쪽 자식 노드의 인덱스가 요소의 개수보다 작을 때 까지 반복
        while((child = getLeftChild(parent)) <= size) {

            int right = getRightChild(parent);	// 오른쪽 자식 인덱스

            Object childVal = array[child];	// 왼쪽 자식의 값 (교환 될 값)

            /*
             *  오른쪽 자식 인덱스가 size를 넘지 않으면서
             *  왼쪽 자식이 오른쪽 자식보다 큰 경우
             *  재배치 할 노드는 작은 자식과 비교해야하므로 child와 childVal을
             *  오른쪽 자식으로 바꿔준다.
             */
            if(right <= size && comp.compare((E) childVal, (E) array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            // 재배치 할 노드가 자식 노드보다 작을경우 종료
            if(comp.compare(target ,(E) childVal) <= 0){
                break;
            }

            array[parent] = childVal;
            parent = child;
        }

        array[parent] = target;

        // 용적의 사이즈가 최소 용적보다는 크면서 요소의 개수가 전체 용적의 1/4이면 용적을 반으로 줄임(단, 최소용적보단 커야함)
        if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int idx, E target) {

        Comparable<? super E> comp = (Comparable<? super E>) target;

        array[idx] = null;
        size--;

        int parent = idx;
        int child;

        while((child = getLeftChild(parent)) <= size) {

            int right = getRightChild(parent);

            Object childVal = array[child];

            if(right <= size && ((Comparable<? super E>)childVal).compareTo((E)array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            if(comp.compareTo((E) childVal) <= 0){
                break;
            }
            array[parent] = childVal;
            parent = child;

        }
        array[parent] = comp;

        if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

    }

    public int size() {
        return this.size;
    }

    // 삭제는 안할건데 현재 요소가 뭔지 확인하고 싶을때
    @SuppressWarnings("unchecked")
    public E peek() {
        if(array[1] == null) {
            throw new NoSuchElementException();
        }
        return (E)array[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size + 1);
    }

}

