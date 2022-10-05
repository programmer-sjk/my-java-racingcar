package racingcar.domain;

public class Car {
    private static final int NAME_LIMIT = 5;
    private String name;
    public Car(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validate(String name) {
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다");
        }
    }
}
