package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.TryRound;
import racingcar.view.Common;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private static final String NAME_DELIMITER = ",";

    public void run() {
        Race race = new Race(getCars());
        TryRound tryRound = new TryRound(getTryRound());

        raceStart(race, tryRound);

        Output.printRaceWinner(race.winner());
    }

    private Cars getCars() {
        try {
            Output.askCarNames();
            return createCars();
        } catch (IllegalArgumentException e) {
            Common.printError(e.getMessage());
            return getCars();
        }
    }

    private Cars createCars() {
        List<Car> cars = new ArrayList<>();

        for (String name : Input.read().split(NAME_DELIMITER)) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }

    private int getTryRound() {
        try {
            Output.askTryRound();
            return Integer.parseInt(Input.read());
        } catch (IllegalArgumentException e) {
            Common.printError(e.getMessage());
            return getTryRound();
        }
    }

    private void raceStart(Race race, TryRound tryRound) {
        Output.printResultComment();

        for (int i = tryRound.getStartRound(); i <= tryRound.get(); i++) {
            race.start();
            Output.showRaceRoundResult(race.getRacingCars());
        }
    }
}
