package racingcar.domain;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Race {
    private final ArrayList<Car> racingCars = new ArrayList<>();
    private int tryCount;

    public Race(String carNames) {
        for (String name : carNames.split(",")) {
            racingCars.add(new Car(name));
        }
    }

    public void setTryCount(String tryCount) {
        this.tryCount = Integer.parseInt(tryCount);
    }

    public void start() {
        for (int i = 0; i < tryCount; i++) {
            roundStart();
        }
    }

    private void roundStart() {
        for (Car car : racingCars) {
            car.move(pickNumberInRange(0, 9));
        }
    }
}
