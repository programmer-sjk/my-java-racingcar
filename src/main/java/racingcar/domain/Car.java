package racingcar.domain;

import racingcar.constant.CarStatus;
import racingcar.constant.Error;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int MOVE_PIVOT_POINT = 4;
    private final String name;
    private final ArrayList<Boolean> distances = new ArrayList<>();

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<Boolean> getDistances() {
        return this.distances;
    }

    public void move(int movePoint) {
        Boolean moveResult = CarStatus.STOP;
        if (movePoint >= MOVE_PIVOT_POINT) {
            moveResult = CarStatus.MOVE;
        }

        distances.add(moveResult);
    }

    private void validate(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(Error.TOO_LONG_NAME.toString());
        }
    }
}
