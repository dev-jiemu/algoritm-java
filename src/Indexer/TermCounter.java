package src.Indexer;

import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import src.Crawling.WikiFetcher;
import src.Crawling.WikiNodeIterable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TermCounter {

    private Map<String, Integer> map;
    private String label;

    public TermCounter(String label) {
        this.label = label;
        this.map = new HashMap<>();
    }

    public int size() {
        // TODO: FILL THIS IN!
        return 0;
    }

    public void put(String term, int count) {
        map.put(term, count);
    }

    public Integer get(String term) {
        Integer count = map.get(term);
        return count == null ? 0 : count;
    }

    // 검색어를 인자로 받아와서 검색어와 관련된 횟수 증가시킴
    public void incrementTermCount(String term) {
        put(term, get(term) + 1);
    }

    // 웹페이지 인덱싱 처리
    public void processElements(Elements paragraphs) {
        for (Node node: paragraphs) {
            processTree(node);
        }
    }

    public void processTree(Node root) {
        for (Node node: new WikiNodeIterable(root)) {
            if (node instanceof TextNode) {
                processText(((TextNode) node).text());
            }
        }
    }

    public void processText(String text) {
        // 구두점은 공백으로 대체, 나머지 글자는 소문자로 변환, 텍스트를 단어로 나눔.
        String[] array = text.replaceAll("\\pP", " ").toLowerCase().split("\\s+");

        for (int i = 0; i<array.length; i++) {
            String term = array[i];
            incrementTermCount(term);
        }
    }

    public Set<String> keySet() {
        return map.keySet();
    }

    public void printCounts() {
        for (String key: keySet()) {
            Integer count = get(key);
            System.out.println(key + ", " + count);
        }
        System.out.println("Total of all counts = " + size());
    }


    public static void main(String[] args) throws IOException {
        String url = "http://en.wikipedia.org/wiki/Java_(programming_language)";
        WikiFetcher wf = new WikiFetcher();
        Elements paragraphs = wf.fetchWikipedia(url);

        TermCounter counter = new TermCounter(url);
        counter.processElements(paragraphs);
        counter.printCounts();
    }

}
