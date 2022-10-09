package racingcar.domain;

import racingcar.constant.Error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {
    private static final int FIRST_ROUND = 1;

    private final Cars racingCars;

    public Race(Cars cars) {
        racingCars = cars;
    }

    public void start(int tryRound) {
        validate(tryRound);

        for (int i = FIRST_ROUND; i <= tryRound; i++) {
            roundStart();
        }
    }

    private void validate(int tryRound) {
        if (tryRound < FIRST_ROUND) {
            throw new IllegalArgumentException(Error.SHOULD_OVER_MINIMUM_ROUND.toString());
        }
    }

    private void roundStart() {
        racingCars.move();
    }

    public CarDistance result() {
        Map<String, List<Boolean>> carDistance = new HashMap<>();

        for (Car car : racingCars.getCars()) {
            carDistance.put(car.getName(), car.getDistances());
        }

        return new CarDistance(carDistance);
    }
}
