package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Error;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TryRoundTest {
    @DisplayName("시도 횟수는 0보다 커야 한다")
    @Test
    void 시도횟수_예외_테스트() {
        assertThatThrownBy(() -> {
            new TryRound(0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.SHOULD_OVER_MINIMUM_ROUND.toString());
    }

    @DisplayName("시도 횟수를 구할 수 있다")
    @Test
    void 시도횟수_테스트() {
        int expected = 3;
        TryRound tryRound = new TryRound(expected);
        assertThat(tryRound.get()).isEqualTo(expected);
    }

    @DisplayName("시작 라운드는 1이다")
    @Test
    void 시작_라운드_테스트() {
        TryRound tryRound = new TryRound(1);
        assertThat(tryRound.getStartRound()).isEqualTo(1);
    }
}
