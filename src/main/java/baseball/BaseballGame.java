package baseball;

import baseball.controller.BaseballController;
import baseball.model.Balls;
import baseball.model.Hints;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private final BaseballController controller;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGame(BaseballController controller, InputView inputView, OutputView outputView) {
        this.controller = controller;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        inputView.printGameStart();
        do {
            round();
        } while (continueGame());

    }

    private boolean continueGame() {
        return inputView.doesContinue();
    }

    private void round() {
        Balls computerBalls = controller.createComputerBalls();
        while (true) {
            Balls userBalls = inputView.getUserBalls();
            Hints hints = controller.getHints(userBalls, computerBalls);
            outputView.printHints(hints);
            if (hints.isClear()) {
                outputView.printClear();
                break;
            }
        }
    }
}
