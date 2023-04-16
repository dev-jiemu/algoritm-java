package src.Crawling;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class WikiFetcher {
    private long lastRequestTime = -1;
    private long minInterval = 1000;

    // singleton pattern 으로 사용할 것.
    private static WikiFetcher instance;
    public static WikiFetcher getInstance() {
        if (instance == null) {
            instance = new WikiFetcher();
        }
        return instance;
    }

    public Elements fetchWikipedia(String url) throws IOException {
        sleepIfNeeded();

        Connection conn = Jsoup.connect(url);
        Document doc = conn.get();
        Element content = doc.getElementById("mw-content-text");
        Elements paras = content.select("p");
        return paras;
    }

    private void sleepIfNeeded() {
        if (lastRequestTime != -1) {
            long currentTime = System.currentTimeMillis();
            long nextRequestTime = lastRequestTime + minInterval;
            if (currentTime < nextRequestTime) {
                try {
                    Thread.sleep(nextRequestTime - currentTime);
                } catch (InterruptedException e) {
                    System.err.println("Warning : sleep interrupted in fetchWikipedia. ");
                }
            }
        }
    }
}
