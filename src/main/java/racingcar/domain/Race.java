package racingcar.domain;

import java.util.ArrayList;

public class Race {
    private ArrayList<Car> racingCars = new ArrayList<>();

    public Race(String carNames) {
        for (String name : carNames.split(",")) {
            racingCars.add(new Car(name));
        }
    }
}
