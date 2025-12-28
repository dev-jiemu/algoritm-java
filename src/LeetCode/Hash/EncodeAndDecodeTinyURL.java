package src.LeetCode.Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// https://leetcode.com/problems/encode-and-decode-tinyurl/description/
public class EncodeAndDecodeTinyURL {
    private Map<String, String> map = new HashMap<>();
    private String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Random random = new Random();

    private String generateKey() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = generateKey();
        while (map.containsKey(key)) {
            key = generateKey();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace("http://tinyurl.com/", "");
        return map.get(key);
    }
}
