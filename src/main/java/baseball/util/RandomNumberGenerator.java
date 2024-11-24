package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public final class RandomNumberGenerator implements NumberGenerator {

    public static final int MIN = 1;
    public static final int MAX = 9;
    public static final int LENGTH = 3;

    public  List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
