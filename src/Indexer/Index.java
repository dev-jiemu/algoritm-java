package src.Indexer;

import org.jsoup.select.Elements;
import src.Crawling.WikiFetcher;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Index {
    private Map<String, Set<TermCounter>> index = new HashMap<>();

    public void add(String term, TermCounter tc) {
        Set<TermCounter> set = get(term);

        // 어떤 검색어를 처음 찾으면 새로운 set을 만듬
        if (set == null) {
            set = new HashSet<>();
            index.put(term, set);
        }
        set.add(tc);
    }

    public Set<TermCounter> get(String term) {
        return index.get(term);
    }

    public void printIndex(){
        for(String term: index.keySet()) {
            System.out.println(term);
            Set<TermCounter> tcs = get(term);
            for (TermCounter tc: tcs) {
                Integer count = tc.get(term);
                System.out.println(" " + tc.getLabel() + " " + count);
            }
        }
    }

    public void indexPage(String url, Elements paragraphs) {
        //TermCounter 객체를 만들고 단락에 있는 단어 카운팅
        TermCounter tc = new TermCounter(url);
        tc.processElements(paragraphs);

        //TermCounter 에 있는 각 검색어에 대해 TermCounter 객체를 인덱스에 추가
        for (String term: tc.keySet()) {
            add(term, tc);
        }
    }

    public static void main(String[] args) throws IOException {

        WikiFetcher wf = new WikiFetcher();
        Index indexer = new Index();

        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
        Elements paragraphs = wf.fetchWikipedia(url);
        indexer.indexPage(url, paragraphs);

        url = "https://en.wikipedia.org/wiki/Programming_language";
        paragraphs = wf.fetchWikipedia(url);
        indexer.indexPage(url, paragraphs);

        indexer.printIndex();
    }
}
