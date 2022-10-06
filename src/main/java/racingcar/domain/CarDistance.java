package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarDistance {
    private Map<String, List<Boolean>> carDistance;

    public CarDistance(Map<String, List<Boolean>> carDistance) {
        this.carDistance = carDistance;
    }

    public List<String> getCarNames() {
        return new ArrayList<>(carDistance.keySet());
    }

    public List<Boolean> distancesByName(String name) {
        return carDistance.get(name);
    }
}
