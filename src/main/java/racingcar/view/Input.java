package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public static String read() {
        try {
            return readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
