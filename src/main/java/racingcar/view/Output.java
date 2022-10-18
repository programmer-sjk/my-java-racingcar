package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class Output {
    private static final String ASK_CAR_STRING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_TRY_ROUND_STRING = "시도할 회수는 몇 회인가요?";
    private static final String RACE_RESULT_STRING = "실행결과";
    private static final String WINNER_STRING = "최종 우승자 : ";
    private static final String GO_FORWARD_STRING = "-";
    private static final String COMMA_JOIN_STRING = ", ";

    public static void askCarNames() {
        System.out.println(ASK_CAR_STRING);
    }

    public static void askTryRound() {
        System.out.println(ASK_TRY_ROUND_STRING);
    }

    public static void printResultComment() {
        System.out.println(RACE_RESULT_STRING);
    }

    public static void showRaceRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            printCarName(car.getName());
            printDistance(car.getDistance());
            Common.printEmptyLine();
        }
        Common.printEmptyLine();
    }

    private static void printCarName(String carName) {
        System.out.print(carName + " : ");
    }

    private static void printDistance(int distance) {
        for (int i = 0; i <= distance; i++) {
            System.out.print(GO_FORWARD_STRING);
        }
    }

    public static void printRaceWinner(List<String> winners) {
        System.out.println(WINNER_STRING + String.join(COMMA_JOIN_STRING, winners));
    }
}
