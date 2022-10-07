package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.Screen;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RaceController {
    public void raceStart() {
        Race race = new Race(getCars());
        getTryRound(race);

        start(race);
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

        for (String name : readLine().split(",")) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }

    private void getTryRound(Race race) {
        try {
            Screen.askTryRound();
            race.setTryRound(readLine());
        } catch (IllegalArgumentException e) {
            Screen.printError(e.getMessage());
            getTryRound(race);
        }
    }

    private void start(Race race) {
        race.start();
        Screen.showRaceResult(race.getTryRound(), race.result());
        Screen.showRaceWinner(race.result());
    }
}
