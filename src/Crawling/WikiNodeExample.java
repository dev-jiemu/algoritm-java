package src.Crawling;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WikiNodeExample {

    private void connectionWikiDoc(String url) throws IOException {
        Connection conn = Jsoup.connect(url);
        Document doc = conn.get();

        Element content = doc.getElementById("mw-content-text");
        Elements paragraphs = content.select("p");
        Element firstPara = paragraphs.get(0);

        Iterable<Node> it = new WikiNodeIterable(firstPara);
        for (Node node : it) {
            if(node instanceof TextNode) {
                System.out.println(node);
            }
        }
    }

    public static void main(String[] args) {
        String url = "http://en.wikipedia.org/wiki/java_(programming_language)";
        WikiNodeExample example = new WikiNodeExample();

        try {
            example.connectionWikiDoc(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
