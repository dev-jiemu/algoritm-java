package src.Programmers.Hash;

import java.util.*;

public class BestAlbum {

    // 내가푼거 : 시간복잡도가 너무 큰게 문제임
    public static int[] solutionOld(String[] genres, int[] plays) {
        int[] answer = {};
        int maxReturn = 2; //최대 2개만 추출

        // total plays
        HashMap<String, Integer> maps = new HashMap<>();

        // genie - play maps
        HashMap<String, List<Integer>> marge = new HashMap<>();

        for (int i = 0; i<genres.length; i++) {
            maps.put(genres[i], maps.getOrDefault(genres[i], 0) + plays[i]);

            if(marge.containsKey(genres[i])) {
                List<Integer> values = marge.get(genres[i]);
                values.add(plays[i]);
            } else {
                List<Integer> values = new ArrayList<>();
                values.add(plays[i]);
                marge.put(genres[i], values);
            }
        }

        // 총 재생수 정렬
        List<Map.Entry<String, Integer>> list = new ArrayList<>(maps.entrySet());
        Collections.sort(list, (obj1, obj2) -> obj2.getValue().compareTo(obj1.getValue()));

        List<Integer> resultList = new ArrayList<>(); // 결과를 담을 동적 배열

        for (int j = 0; j < list.size(); j++) {
            String map = list.get(j).getKey();
            List<Integer> value = marge.get(map);
            Collections.sort(value, Collections.reverseOrder());

            int maxSize = Math.min(value.size(), maxReturn);
            for (int i = 0; i < maxSize; i++) {
                for (int k = 0; k < plays.length; k++) {
                    if (plays[k] == value.get(i)) {
                        resultList.add(k); // 결과를 동적 배열에 추가
                    }
                }
            }
        }

        // 동적 배열을 int[] 배열로 변환
        answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }

    // chatgpt 한테 리팩토링 맡김
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreTotalPlays = new HashMap<>();
        HashMap<String, PriorityQueue<Song>> genreTopSongs = new HashMap<>();

        int maxLength = 2;

        for (int i = 0; i < genres.length; i++) {
            genreTotalPlays.put(genres[i], genreTotalPlays.getOrDefault(genres[i], 0) + plays[i]);

            // putIfAbsent : key 값이 존재하면 value 리턴, 아닐 경우 key-value 생성(null 리턴)
            genreTopSongs.putIfAbsent(genres[i], new PriorityQueue<>((s1, s2) -> {
                if (s1.playCount != s2.playCount) {
                    return Integer.compare(s2.playCount, s1.playCount); // 내림차순 정렬
                }
                return Integer.compare(s1.index, s2.index); // playCount가 같을 경우 index로 오름차순 정렬
            }));

            genreTopSongs.get(genres[i]).add(new Song(i, plays[i]));
        }

        // 최대 재생수 정렬
        List<String> genreOrder = new ArrayList<>(genreTotalPlays.keySet());
        genreOrder.sort((g1, g2) -> Integer.compare(genreTotalPlays.get(g2), genreTotalPlays.get(g1)));

        List<Integer> resultList = new ArrayList<>();
        for (String genre : genreOrder) {
            PriorityQueue<Song> topSongs = genreTopSongs.get(genre);
            int songsToAdd = Math.min(topSongs.size(), maxLength);

            for (int i = 0; i < songsToAdd; i++) {
                resultList.add(topSongs.poll().index);
            }
        }

        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }

    static class Song {
        int index;
        int playCount;

        Song(int index, int playCount) {
            this.index = index;
            this.playCount = playCount;
        }
    }


    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        int[] result = solution(genres, plays);

        for(int value : result) {
            System.out.println(value);
        }
    }
}
