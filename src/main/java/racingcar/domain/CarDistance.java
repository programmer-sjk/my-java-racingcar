package racingcar.domain;

import java.util.*;

public class CarDistance {
    private static final String EMPTY = "";
    private static final int HIGHEST_MOVE_INDEX = 0;
    private static final int MOVE = 1;
    private static final int STOP = 0;
    private Map<String, List<Boolean>> carDistance;

    public CarDistance(Map<String, List<Boolean>> carDistance) {
        this.carDistance = carDistance;
    }

    public List<String> getCarNames() {
        return new ArrayList<>(carDistance.keySet());
    }

    public List<Boolean> distancesByName(String name) {
        return this.carDistance.get(name);
    }

    public List<String> winner() {
        Map<String, Integer> carMove = new HashMap<>();
        for (String name : carDistance.keySet()) {
            carMove.put(name, moveCountByName(name));
        }

        return allWinner(sortByDistanceDesc(carMove));
    }

    private static List<Map.Entry<String, Integer>> sortByDistanceDesc(Map<String, Integer> carMove) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(carMove.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        return entryList;
    }

    private int moveCountByName(String name) {
        int moveCount = 0;
        List<Boolean> carDistance = this.carDistance.get(name);

        for (Boolean distance : carDistance) {
            moveCount += countIfMove(distance);
        }

        return moveCount;
    }

    private int countIfMove(Boolean isMove) {
        return isMove ? MOVE : STOP;
    }

    private List<String> allWinner(List<Map.Entry<String, Integer>> entryList) {
        int highestDistance = entryList.get(HIGHEST_MOVE_INDEX).getValue();
        List<String> winnerNames = new ArrayList<>();

        for (Map.Entry<String, Integer> list : entryList) {
            winnerNames.add(winnerName(highestDistance, list));
        }

        winnerNames.removeIf(String::isEmpty);
        return winnerNames;
    }

    private String winnerName(int highestDistance, Map.Entry<String, Integer> list) {
        if (list.getValue() != highestDistance) {
            return EMPTY;
        }

        return list.getKey();
    }
}
