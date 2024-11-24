package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    @Test
    void getAt() {
        Balls balls = new Balls(List.of(4, 5, 6));
        assertThat(balls.getAt(0)).isEqualTo(4);;
        assertThat(balls.getAt(1)).isEqualTo(5);;
        assertThat(balls.getAt(2)).isEqualTo(6);;
    }

    @Test
    void containsUserBall() {
        Balls balls = new Balls(List.of(4, 5, 6));
        assertThat(balls.containsUserBall(4)).isTrue();
        assertThat(balls.containsUserBall(5)).isTrue();
        assertThat(balls.containsUserBall(6)).isTrue();
        assertThat(balls.containsUserBall(1)).isFalse();
        assertThat(balls.containsUserBall(2)).isFalse();
    }
}