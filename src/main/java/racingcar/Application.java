package racingcar;

import racingcar.domain.Race;
import racingcar.view.Screen;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Screen.showCarNames();
        Race race = new Race(readLine());
    }
}
