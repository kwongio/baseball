package baseball.model;

import java.util.List;

public class Balls {

    private final List<Integer> balls;

    public Balls(List<Integer> balls) {
        this.balls = balls;
    }

    public int getAt(int index) {
        return balls.get(index);
    }

    public boolean containsUserBall(int userBall) {
        return balls.contains(userBall);
    }
}
