package racingcar.domain;

public class Distance {
    private int moveDistance;

    public Distance() {
        this.moveDistance = 0;
    }

    public int getDistance() {
        return this.moveDistance;
    }

    public void increaseDistance() {
        this.moveDistance += 1;
    }
}
