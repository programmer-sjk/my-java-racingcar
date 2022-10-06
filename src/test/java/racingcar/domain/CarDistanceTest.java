package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class CarDistanceTest {
    private static final String WINNER_NAME = "winner";
    private static final String LOSER_NAME = "loser";
    private static CarDistance distances;

    @BeforeAll
    public static void setUp() {
        Map<String, List<Boolean>> carDistance = new HashMap<>();
        carDistance.put(WINNER_NAME, Arrays.asList(true));
        carDistance.put(LOSER_NAME, Arrays.asList(false));

        distances = new CarDistance(carDistance);
    }

    @DisplayName("자동차 이름을 구할 수 있다")
    @Test
    void 자동차_이름_테스트() {
        assertThat(distances.getCarNames()).containsExactly(WINNER_NAME, LOSER_NAME);
    }

    @DisplayName("자동차 이름으로 이동한 배열을 구할 수 있다")
    @Test
    void 자동차_이동거리_배열_테스트() {
        List<Boolean> winnerDistances = distances.distancesByName(WINNER_NAME);
        assertThat(winnerDistances.get(0)).isTrue();
    }

    @DisplayName("승자를 알 수 있다")
    @Test
    void 승자_테스트() {
        assertThat(distances.winner()).isEqualTo(WINNER_NAME);
    }
}
