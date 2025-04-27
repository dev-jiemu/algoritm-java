package src.Programmers.FullSearch;

public class VowelDictionary {
    private String[] vowels = new String[]{"A", "E", "I", "O", "U"};
    private int count = 0;
    private int answer = -1; // result

    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    private void dfs(String currentWord, String targetWord){
        if (answer != -1) { // -1이 아니면 찾았단 뜻임
            return;
        }

        if (currentWord.equals(targetWord)) { // 목표 단어를 찾았을 때
            answer = count;
            return;
        }

        if (currentWord.length() == 5) { // 5글자면 종료
            return;
        }

        for (int i = 0; i < 5; i++) {
            count++;
            dfs(currentWord + vowels[i], targetWord);
        }
    }
}
