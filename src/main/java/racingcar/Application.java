package racingcar;

import racingcar.domain.Race;
import racingcar.view.Screen;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Screen.askCarNames();
        Race race = new Race(readLine());

        Screen.askTryCount();
        race.setTryCount(readLine());

        race.start();
        Screen.showRaceResult(race.getTryCount(), race.result());
        Screen.showRaceWinner(race.result());
    }
}
