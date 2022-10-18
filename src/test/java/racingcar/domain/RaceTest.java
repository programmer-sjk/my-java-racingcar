package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Error;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RaceTest {
    @DisplayName("레이스에 참여한 자동차를 구할 수 있다")
    @Test
    void 레이스_참여한_자동차_테스트() {
        Cars cars = new Cars(Arrays.asList(new Car("차1"), new Car("차2")));
        Race race = new Race(cars);
        assertThat(race.getRacingCars().equals(cars)).isTrue();
    }
}
