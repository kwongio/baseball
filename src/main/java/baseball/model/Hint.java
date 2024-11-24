package baseball.model;

public enum Hint {
    BALL("볼", 1),
    STRIKE("스트라이크", 2),
    NOTHING("낫싱", 3);

    private final String name;

    private final int id;

    Hint(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static Hint getHint(int userBall, int computerBall, boolean containsBall) {
        if (userBall == computerBall) {
            return Hint.STRIKE;
        }
        if (containsBall) {
            return Hint.BALL;
        }
        return Hint.NOTHING;
    }

    @Override
    public String toString() {
        return name;
    }

}
