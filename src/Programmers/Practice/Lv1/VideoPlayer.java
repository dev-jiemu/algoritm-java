package src.Programmers.Practice.Lv1;

// 동영상 재생기
// https://school.programmers.co.kr/learn/courses/30/lessons/340213
public class VideoPlayer {

    // mm:ss 형태로 리턴
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int currentPosition = convertToSeconds(pos);
        int opStart = convertToSeconds(op_start);
        int opEnd = convertToSeconds(op_end);
        int videoLength = convertToSeconds(video_len);

        // 오프닝 구간 처리
        if (opStart <= currentPosition && currentPosition < opEnd) {
            currentPosition = opEnd;
        }

        for (String command : commands) {
            if (command.equals("next")) {
                currentPosition = currentPosition + 10;

                // 비디오 길이 초과 확인
                if (currentPosition > videoLength) {
                    currentPosition = videoLength;
                }
            } else if (command.equals("prev")) {
                currentPosition = currentPosition - 10;

                // 음수 보정
                if (currentPosition < 0) {
                    currentPosition = 0;
                }
            }

            // 명령어 실행 후 오프닝 구간 체크
            if (opStart <= currentPosition && currentPosition < opEnd) {
                currentPosition = opEnd;

                // 비디오 길이 초과 확인
                if (currentPosition > videoLength) {
                    currentPosition = videoLength;
                }
            }
        }

        return convertToTimeFormat(currentPosition);
    }

    // mm:ss 형태의 시간 문자열을 초 단위로 변환
    public int convertToSeconds(String timeString) {
        String[] parts = timeString.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);

        return minutes * 60 + seconds;
    }

    // 초 단위 시간을 다시 mm:ss 형태로 변환
    public String convertToTimeFormat(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }
}
