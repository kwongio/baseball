package baseball.config;

import baseball.BaseballGame;
import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameFactory {

    public static BaseballGame baseballGame() {
        return new BaseballGame(baseballController(), inputView(), getOutputView());
    }

    private static BaseballController baseballController() {
        return new BaseballController(baseballService());
    }

    private static BaseballService baseballService() {
        return new BaseballService(new RandomNumberGenerator());
    }

    private static OutputView getOutputView() {
        return new OutputView();
    }

    private static InputView inputView() {
        return new InputView();
    }
}
