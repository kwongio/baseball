package baseball.service;

import baseball.model.Balls;
import baseball.model.Hints;
import baseball.util.NumberGenerator;

import java.util.List;

public class BaseballService {
    private final NumberGenerator randomNumberGenerator;

    public BaseballService(NumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Balls getComputerBalls() {
        List<Integer> balls = randomNumberGenerator.generate();
        return new Balls(balls);
    }

    public Hints getHints(Balls userBalls, Balls computerBalls) {
        return Hints.getHints(userBalls, computerBalls);
    }
}
