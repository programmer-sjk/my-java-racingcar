package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.Error;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DistanceTest {
    @DisplayName("이동거리의 초기값은 0이다")
    @Test
    void 이동거리_초기값_테스트() {
        assertThat(new Distance().getDistance()).isEqualTo(0);
    }

    @DisplayName("이동거리는 1씩 증가한다")
    @Test
    void 이동거리_증가_테스트() {
        Distance distance = new Distance();
        distance.increaseDistance();
        assertThat(distance.getDistance()).isEqualTo(1);
    }
}
