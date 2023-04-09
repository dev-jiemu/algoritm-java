package src.ListClass;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {

    int size;
    private T[] array;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    // n번 추가하면 요소 n개를 저장하고 n-2개를 복사함 = 총 연산 2n-2
    @Override
    public boolean add(T t) {
        if (size >= array.length) {
            T[] bigger = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }
        array[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    // 딱보기에 이차 같은데 아님. 항상 반복횟수가 n에 비례하다고 볼수 없기 때문.
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = false;
        for (Object obj: c) {
            flag |= remove(obj);
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    @Override
    public T set(int index, T element) {
        T old = get(index);
        array[index] = element;
        return old;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // 크기 조정을 통해 요소 추가
        add(element);

        //다른 요소를 옮김
        for (int i = size-1; i > index; i--) {
            array[i] = array[i-1];
        }

        array[index] = element;
    }

    @Override
    public T remove(int index) {
        T element = get(index);
        for (int i = index; i < size-1; i++) {
            array[i] = array[i+1];
        }
        size--;
        return element;
    }

    @Override
    public int indexOf(Object target) {
        for (int i = 0; i < size; i++) {
            if (equals(target, array[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
