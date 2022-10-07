package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Race {
    private final Cars racingCars;
    private int tryCount;

    public Race(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",")) {
            cars.add(new Car(name));
        }

        racingCars = new Cars(cars);
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public void setTryCount(String tryCount) {
        this.tryCount = Integer.parseInt(tryCount);
    }

    public CarDistance result() {
        Map<String, List<Boolean>> carDistance = new HashMap<>();

        for (Car car : racingCars.getCars()) {
            carDistance.put(car.getName(), car.getDistances());
        }

        return new CarDistance(carDistance);
    }

    public void start() {
        for (int i = 0; i < tryCount; i++) {
            roundStart();
        }
    }

    private void roundStart() {
        for (Car car : racingCars.getCars()) {
            car.move(pickNumberInRange(0, 9));
        }
    }
}
