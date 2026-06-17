package src.LeetCode.String;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

// 2810. Faulty Keyboard
// https://leetcode.com/problems/faulty-keyboard/description/
public class FaultyKeyboard {
    // 정말 단순하게 가면
//    public String finalString(String s) {
//        StringBuilder sb = new StringBuilder();
//
//        for (char c : s.toCharArray()) {
//            if (c == 'i') {
//                sb.reverse();
//            } else {
//                sb.append(c);
//            }
//        }
//
//        return sb.toString();
//    }

    // deque 로 푼다면? -> boolean
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();

        Deque<Character> dq = new ArrayDeque<>();
        boolean reversed = false;

        for (char c : s.toCharArray()) {
            if (c == 'i') {
                reversed = !reversed;
            } else if (reversed) { // 뒤집힌거면 앞에다
                dq.addFirst(c);
            } else {
                dq.addLast(c);
            }
        }

        if (reversed) {
            Iterator<Character> it = dq.descendingIterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
        } else {
            for (char c : dq) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
