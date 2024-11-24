package baseball;

import baseball.config.BaseballGameFactory;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = BaseballGameFactory.baseballGame();
        baseballGame.start();
    }
}
