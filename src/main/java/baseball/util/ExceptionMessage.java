package baseball.util;

public enum ExceptionMessage {

    NOT_DIGIT("1~9 사이의 숫자를 입력하세요."),
    LENGTH("공은 3개로 이루어집니다."),
    DUPLICATE("공은 중복되면 안됩니다.");

    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }

}
