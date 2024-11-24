package baseball.service;

import baseball.util.NumberGenerator;

import java.util.List;

public class TestNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate() {
        return List.of(1, 2, 3);
    }
}
