package racingcar.view;

import racingcar.domain.CarDistance;

import java.util.List;

public class Screen {
    public static void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
    }

    public static void showRaceResult(int tryCount, CarDistance carDistance) {
        System.out.println("실행결과");

        for (int i = 0; i < tryCount; i++) {
            showRaceRoundResult(i, carDistance);
            printEmptyLine();
        }
    }

    private static void showRaceRoundResult(int currentCount, CarDistance carDistance) {
        for (String carName : carDistance.getCarNames()) {
            printCarName(carName);
            printDistances(currentCount, carDistance.distancesByName(carName));
            printEmptyLine();
        }
    }

    private static void printCarName(String carName) {
        System.out.print(carName + " : ");
    }

    private static void printDistances(int currentCount, List<Boolean> distances) {
        for (int i = 0; i <= currentCount; i++) {
            printDistance(i, distances);
        }
    }

    private static void printDistance(int round, List<Boolean> distances) {
        if (distances.get(round) == true) {
            System.out.print("-");
        }
    }

    private static void printEmptyLine() {
        System.out.println("");
    }

}
