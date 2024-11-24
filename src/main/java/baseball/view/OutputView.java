package baseball.view;

import baseball.model.Hints;

public class OutputView {

    public static String CLEAR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printHints(Hints hints) {
        System.out.println(hints);
    }

    public void printClear() {
        System.out.println(CLEAR);
    }
}
