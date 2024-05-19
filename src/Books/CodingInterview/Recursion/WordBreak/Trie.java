package src.Books.CodingInterview.Recursion.WordBreak;

// 3. 트라이 자료구조 기반 접근법
// Ref. https://velog.io/@kimdukbae/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%ED%8A%B8%EB%9D%BC%EC%9D%B4-Trie
public class Trie {
    private static final int CHAR_SIZE = 26; // a ~ z

    private final Node head;

    public Trie(Node head) {
        this.head = head;
    }

    private static class Node {

        private boolean leaf;
        private final Node[] next;

        private Node() {
            this.leaf = false;
            this.next = new Node[CHAR_SIZE];
        }
    };

    public void insertTrie(String str) {
        Node node = head;

        for (int i = 0; i < str.length(); i++) {
            if (node.next[str.charAt(i) - 'a'] == null) {
                node.next[str.charAt(i) - 'a'] = new Node();
            }

            node = node.next[str.charAt(i) - 'a'];
        }

        node.leaf = true;
    }

    public boolean breakIt(String str) {
        boolean[] table = new boolean[str.length() + 1];
        table[0] = true;

        for (int i = 0; i < str.length(); i++) {
            if(table[i]) {
                Node node = head;

                for(int j = i; j < str.length(); j++) {
                    if (node == null) {
                        break;
                    }

                    node = node.next[str.charAt(i) - 'a'];

                    if (node != null && node.leaf) {
                        table[i + j] = true;
                    }
                }
            }
        }

        // str에 있는 모든 문자가 사전 단위로 분리할수 있으면 table[n] 은 true가 됨
        return table[str.length()];
    }
}
