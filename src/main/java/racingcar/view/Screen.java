package racingcar.view;

import racingcar.constant.CarStatus;
import racingcar.domain.CarDistance;

import java.util.List;

public class Screen {
    private static final String ASK_CAR_STRING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_TRY_ROUND_STRING = "시도할 회수는 몇 회인가요?";
    private static final String RACE_RESULT_STRING = "실행결과";
    private static final String WINNER_STRING = "최종 우승자 : ";
    private static final String GO_FORWARD_STRING = "-";
    private static final String COMMA_JOIN_STRING = ", ";
    private static final String EMPTY_STRING = "";

    public static void askCarNames() {
        System.out.println(ASK_CAR_STRING);
    }

    public static void askTryRound() {
        System.out.println(ASK_TRY_ROUND_STRING);
    }

    public static void showRaceResult(int tryRound, CarDistance carDistance) {
        System.out.println(RACE_RESULT_STRING);

        for (int i = 0; i < tryRound; i++) {
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
        if (distances.get(round) == CarStatus.MOVE) {
            System.out.print(GO_FORWARD_STRING);
        }
    }

    private static void printEmptyLine() {
        System.out.println(EMPTY_STRING);
    }

    public static void printRaceWinner(CarDistance carDistance) {
        System.out.println(WINNER_STRING + String.join(COMMA_JOIN_STRING, carDistance.winner()));
    }

    public static void printError(String message) {
        System.out.print(message);
    }

}
