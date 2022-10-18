package racingcar.domain;

public class Car {
    private static final int MOVE_STANDARD_POINT = 4;

    private final CarName name;
    private final Distance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new Distance();
    }

    public String getName() {
        return this.name.getName();
    }

    public int getDistance() {
        return this.distance.getDistance();
    }

    public void move(int movePoint) {
        if (movePoint >= MOVE_STANDARD_POINT) {
            distance.increaseDistance();
        }
    }
}
