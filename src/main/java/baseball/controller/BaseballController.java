package baseball.controller;

import baseball.model.Balls;
import baseball.model.Hints;
import baseball.service.BaseballService;


public class BaseballController {

    private final BaseballService service;

    public BaseballController(BaseballService service) {
        this.service = service;
    }

    public Balls createComputerBalls() {
        return service.getComputerBalls();
    }

    public Hints getHints(Balls userBalls, Balls computerBalls) {
        return service.getHints(userBalls, computerBalls);
    }
}
