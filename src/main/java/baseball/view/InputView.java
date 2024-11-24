package baseball.view;

import baseball.model.Balls;
import baseball.util.ExceptionMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class InputView {

    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";

    public static final String ENTER_BALLS = "숫자를 입력해주세요 : ";

    public static final String CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    public Balls getUserBalls() {
        System.out.println(ENTER_BALLS);
        String userBalls = Console.readLine();

        validateLength(userBalls);
        char[] balls = userBalls.toCharArray();

        for (char ball : balls) {
            if (isNotInBallRange(ball)) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_DIGIT.toString());
            }
        }

        Set<Integer> set = validateDuplication(balls);
        return new Balls(new ArrayList<>(set));
    }

    private static boolean isNotInBallRange(char ball) {
        return !Character.isDigit(ball) || ball == '0';
    }

    private static void validateLength(String userBall) {
        if (userBall.length() != 3) {
            throw new IllegalArgumentException(ExceptionMessage.LENGTH.toString());
        }
    }

    private static Set<Integer> validateDuplication(char[] balls) {
        Set<Integer> characters = new LinkedHashSet<>();
        for (char ball : balls) {
            characters.add(ball - '0');
        }
        if (characters.size() != 3) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE.toString());
        }
        return characters;
    }

    public boolean doesContinue() {
        System.out.println(CONTINUE);
        String userInput = Console.readLine();
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException();
        }
        return userInput.equals("1");
    }
}
