package racingcar.domain;

import java.util.*;

public class CarDistance {
    private static final String EMPTY = "";
    private final int maxDistance;

    private Map<String, Integer> carToDistance;

    public CarDistance(Cars cars) {
        this.carToDistance = convertCarToDistance(cars);
        this.maxDistance = getMaxDistance();
    }

    private Map<String, Integer> convertCarToDistance(Cars cars) {
        Map<String, Integer> result = new HashMap<>();
        for (Car car : cars.getCars()) {
            result.put(car.getName(), car.getDistance());
        }

        return result;
    }

    public List<String> winner() {
        List<String> winnerNames = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : carToDistance.entrySet()) {
            addWinner(winnerNames, entry);
        }

        return winnerNames;
    }

    private int getMaxDistance() {
        int maxDistance = -1;
        for (Map.Entry<String, Integer> entry : carToDistance.entrySet()) {
            maxDistance = getMaxDistance(entry.getValue(), maxDistance);
        }

        return maxDistance;
    }

    private int getMaxDistance(int carMoveDistance, int maxDistance) {
        if (carMoveDistance > maxDistance) {
            return carMoveDistance;
        }

        return maxDistance;
    }

    private void addWinner(List<String> winnerNames, Map.Entry<String, Integer> entry) {
        if (entry.getValue() == this.maxDistance) {
            winnerNames.add(entry.getKey());
        }
    }
}
