package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Race {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private final Cars racingCars;

    public Race(Cars cars) {
        racingCars = cars;
    }

    public CarDistance result() {
        Map<String, List<Boolean>> carDistance = new HashMap<>();

        for (Car car : racingCars.getCars()) {
            carDistance.put(car.getName(), car.getDistances());
        }

        return new CarDistance(carDistance);
    }

    public void start(int tryRound) {
        for (int i = 0; i < tryRound; i++) {
            roundStart();
        }
    }

    private void roundStart() {
        for (Car car : racingCars.getCars()) {
            car.move(pickNumberInRange(MIN, MAX));
        }
    }
}
