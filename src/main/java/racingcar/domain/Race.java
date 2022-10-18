package racingcar.domain;

import java.util.List;

public class Race {
    private final Cars racingCars;

    public Race(Cars cars) {
        racingCars = cars;
    }

    public Cars getRacingCars() {
        return racingCars;
    }

    public void start() {
        racingCars.move();
    }

    public List<String> winner() {
        return racingCars.winner();
    }
}
