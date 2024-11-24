package baseball.model;

import baseball.util.ExceptionMessage;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BallsInputTest {

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @AfterEach
    void clear() {
        Console.close();
    }

    @ParameterizedTest
    @MethodSource("inputBallsAndExceptionMessage")
    void test(String inputBalls, ExceptionMessage message) {
        InputStream readLine = setReadLine(inputBalls);
        System.setIn(readLine);
        InputView inputView = new InputView();
//        try {
//            inputView.getUserBalls();
//        } catch (IllegalArgumentException e) {
//            assertEquals(message.toString(), e.getMessage());
//        }

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> inputView.getUserBalls());
        assertEquals(message.toString(), exception.getMessage());
    }

    static Stream<Arguments> inputBallsAndExceptionMessage() {
        return Stream.of(
                Arguments.arguments("\n", ExceptionMessage.LENGTH),
                Arguments.arguments("aa1", ExceptionMessage.NOT_DIGIT),
                Arguments.arguments("023", ExceptionMessage.NOT_DIGIT),
                Arguments.arguments("1234", ExceptionMessage.LENGTH),
                Arguments.arguments("111", ExceptionMessage.DUPLICATE)
        );
    }

}
