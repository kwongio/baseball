package baseball.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class HintsTest {


    @ParameterizedTest
    @MethodSource("userBallComputerBallsContainsAndHint")
    void test1(int userBall, int computerBall, boolean contains, Hint expectedHint) {
        Hint hint = Hint.getHint(userBall, computerBall, contains);
        assertThat(hint).isEqualTo(expectedHint);

    }

    static Stream<Arguments> userBallComputerBallsContainsAndHint() {
        return Stream.of(
                Arguments.arguments(1, 1, true, Hint.STRIKE),
                Arguments.arguments(1, 2, true, Hint.BALL),
                Arguments.arguments(1, 2, false, Hint.NOTHING)
        );
    }
}
