package racingcar.domain;

import racingcar.constant.Error;

public class TryRound {
    private static final int MINIMUM_ROUND = 1;

    private final int tryRound;

    public TryRound(int tryRound) {
        validate(tryRound);
        this.tryRound = tryRound;
    }

    private void validate(int tryRound) {
        if (tryRound < MINIMUM_ROUND) {
            throw new IllegalArgumentException(Error.SHOULD_OVER_MINIMUM_ROUND.toString());
        }
    }

    public int get() {
        return this.tryRound;
    }

    public int getStartRound() {
        return TryRound.MINIMUM_ROUND;
    }
}
