package racingcar.domain;

import racingcar.constant.Error;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int NAME_LIMIT = 5;
    private static final int MOVE_PIVOT_POINT = 4;
    private String name;
    private ArrayList<Boolean> distances = new ArrayList<>();

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
        Boolean moveResult = false;
        if (movePoint >= MOVE_PIVOT_POINT) {
            moveResult = true;
        }

        distances.add(moveResult);
    }

    private void validate(String name) {
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException(Error.TOO_LONG_NAME.toString());
        }
    }
}
