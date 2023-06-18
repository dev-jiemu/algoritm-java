package src.BinarySearch;

import java.nio.file.FileSystemNotFoundException;

public class GenericClassTester {
    static class GenericClass<T> {
        private T xyz;
        GenericClass(T t) {
            this.xyz = t;
        }
        T getXyz() {
            return this.xyz;
        }
    }


    public static void main(String[] args) {
        GenericClass<String> s = new GenericClass<>("ABC");
        GenericClass<Integer> n = new GenericClass<>(15);

        System.out.println(s.getXyz());
        System.out.println(n.getXyz());
    }
}
