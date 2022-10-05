package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @DisplayName("자동차 객체에 전달된 입력값이 이름이 된다")
    @Test
    void 자동차_이름_테스트() {
        Car car = new Car("자동차이름");
        assertThat(car.getName()).isEqualTo("자동차이름");
    }
}
