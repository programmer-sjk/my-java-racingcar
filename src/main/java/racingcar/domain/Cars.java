package racingcar.domain;

import racingcar.constant.ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateName(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateDuplicateName(List<Car> cars) {
        Set<String> carName = new HashSet<>();

        for (Car car : cars) {
            carName.add(uniqueName(carName, car.getName()));
        }
    }

    private String uniqueName(Set<String> carName, String name) {
        if (carName.add(name) == false) {
            throw new IllegalArgumentException(ERROR_MESSAGE.DUPLICATE_NAME.toString());
        }

        return name;
    }
}
