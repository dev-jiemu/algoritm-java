package src.Books.KakaoBlind;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/92341
public class ParkingFeeCalculation {

    private static class Fee {
        private final int baseTime;
        private final int baseFee;
        private final int unitTime;
        private final int unitFee;

        public Fee(int baseTime, int baseFee, int unitTime, int unitFee) {
            this.baseTime = baseTime;
            this.baseFee = baseFee;
            this.unitTime = unitTime;
            this.unitFee = unitFee;
        }

        public int cost(int time) {
            int fee = this.baseFee;
            time -= baseTime;

            while (time > 0) {
                fee += unitFee;
                time -= unitTime;
            }

            return fee;
        }
    }

    private static class Car {
        public final String number;
        public final Fee fee;
        private int inTime = -1;
        private int totalTime = 0;

        public Car(String number, Fee fee) {
            this.number = number;
            this.fee = fee;
        }

        public void in(int time) {
            this.inTime = time;
        }

        public void out(int time) {
            if (this.inTime != -1) {
                totalTime += time - this.inTime;
                this.inTime = -1;
            }
        }

        public int cost() {
            return fee.cost(totalTime);
        }
    }

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        // fees : 기본시간/기본요금/단위시간/단위요금 순
        Fee fee = new Fee(fees[0], fees[1], fees[2], fees[3]);

        // recodes : 시간 차량뒷번호 IN/OUT " " split 처리
        Map<String, Car> cars = new HashMap<>();
        for (String record : records) {
            String[] tokens = record.split(" ");
            int time = parseTime(tokens[0]);
            String number = tokens[1];
            boolean isIn = tokens[2].equals("IN");

            // 차량 객체가 없으면 생성
            if (!cars.containsKey(number)) {
                cars.put(number, new Car(number, fee));
            }

            Car car = cars.get(number);
            if (isIn) {
                car.in(time);
            } else {
                car.out(time);
            }
        }

        // 아직 입차중인 차는 23:59분에 출차했다고 가정함
        int endTime = parseTime("23:59");
        for (Car car : cars.values()) {
            car.out(endTime);
        }

        answer = cars.values().stream().sorted(Comparator.comparing(car -> car.number)).mapToInt(Car::cost).toArray();

        return answer;
    }

    private int parseTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));

        return hour * 60 + minute;
    }
}

