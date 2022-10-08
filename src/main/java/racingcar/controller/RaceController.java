package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarDistance;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.Screen;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RaceController {
    private static final String COMMA_DELIMITER = ",";

    public void run() {
        Race race = new Race(getCars());
        int tryRound = getTryRound();

        start(race, tryRound);

        result(tryRound, race.result());
    }

    private Cars getCars() {
        try {
            Screen.askCarNames();
            return createCars();
        } catch (IllegalArgumentException e) {
            Screen.printError(e.getMessage());
            return getCars();
        }
    }

    private Cars createCars() {
        List<Car> cars = new ArrayList<>();

        for (String name : readLine().split(COMMA_DELIMITER)) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }

    private int getTryRound() {
        try {
            Screen.askTryRound();
            return Integer.parseInt(readLine());
        } catch (IllegalArgumentException e) {
            Screen.printError(e.getMessage());
            return getTryRound();
        }
    }

    private void start(Race race, int tryRound) {
        race.start(tryRound);
    }

    private void result(int tryRound, CarDistance carDistance) {
        Screen.showRaceResult(tryRound, carDistance);
        Screen.printRaceWinner(carDistance);
    }
}
