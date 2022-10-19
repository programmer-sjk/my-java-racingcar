package racingcar.domain;

import java.util.*;

public class CarDistance {
    private static final String EMPTY = "";

    private Map<String, Integer> carToDistance;

    public CarDistance(Cars cars) {
        this.carToDistance = convertCarToDistance(cars);
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
        int highestDistance = getHighestDistance(); // Todo max로 이름 변경

        for (Map.Entry<String, Integer> entry : carToDistance.entrySet()) {
            winnerNames.add(findMultiWinner(entry, highestDistance));
        }

        winnerNames.removeIf(String::isEmpty); // Todo remove를 안 쓰는 방향으로 수정가능한지 체크
        return winnerNames;
    }

    private int getHighestDistance() {
        int highestDistance = -1;
        for (Map.Entry<String, Integer> entry : carToDistance.entrySet()) {
            highestDistance = returnHighestDistance(entry.getValue(), highestDistance);
        }

        return highestDistance;
    }

    private int returnHighestDistance(int carMoveDistance, int highestDistance) {
        if (carMoveDistance > highestDistance) {
            return carMoveDistance;
        }

        return highestDistance;
    }

    private String findMultiWinner(Map.Entry<String, Integer> entry, int highestDistance) {
        if (entry.getValue() != highestDistance) {
            return EMPTY;
        }

        return entry.getKey();
    }
}
