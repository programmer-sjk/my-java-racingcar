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

    public void start(TryRound tryRound) {
        for (int i = tryRound.getStartRound(); i <= tryRound.get(); i++) {
            roundStart();
        }
    }

    private void roundStart() {
        racingCars.move();
    }

    public List<String> winner() {
        return racingCars.winner();
    }
}
