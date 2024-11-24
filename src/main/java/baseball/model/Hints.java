package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public record Hints (TreeMap<Hint, Integer> hints) {

    public static Hints getHints(Balls userBalls, Balls computerBalls) {
        TreeMap<Hint, Integer> hints = new TreeMap<>();
        for (int i = 0; i < 3; i++) {
            boolean containsComputerBall = computerBalls.containsUserBall(userBalls.getAt(i));
            Hint hint = Hint.getHint(userBalls.getAt(i), computerBalls.getAt(i), containsComputerBall);
            hints.put(hint, hints.getOrDefault(hint, 0) + 1);
        }
        return new Hints(hints);
    }

    @Override
    public String toString() {
        int strikeCount = hints.getOrDefault(Hint.STRIKE, 0);
        int ballCount = hints.getOrDefault(Hint.BALL, 0);
        if (strikeCount == 0 && ballCount == 0) {
            return Hint.NOTHING.toString();
        }
        List<String> strings = new ArrayList<>();
        if (ballCount != 0) {
            strings.add(ballCount + Hint.BALL.toString());
        }
        if (strikeCount != 0) {
            strings.add(strikeCount + Hint.STRIKE.toString());
        }
        return String.join(" ", strings);
    }

    public boolean isClear() {
        if (hints.isEmpty()) {
            return false;
        }
        return hints.getOrDefault(Hint.STRIKE, 0) == 3;
    }
}
