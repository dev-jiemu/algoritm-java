package src.Hashing;

import com.sun.org.glassfish.gmbal.ManagedObject;

// 해시 함수의 근본적인 요구사항: 같은 객체는 매번 같은 해시코드를 생성해야 한다
// 불변객체 예시
public class SillyString {
    private final String innerString;

    public SillyString(String innerString) {
        this.innerString = innerString;
    }

    public String toString() {
        return innerString;
    }

    @Override
    public boolean equals(Object other) {
        return this.toString().equals(other.toString());
    }

    @Override
    public int hashCode() {
        int total = 0;
        for (int i = 0; i < innerString.length(); i++) {
            total += innerString.charAt(i);
        }

        return total;
    }

}

