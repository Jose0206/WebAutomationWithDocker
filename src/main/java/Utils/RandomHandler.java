package Utils;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class RandomHandler {

    public static int getMatricula() {
        return ThreadLocalRandom.current().nextInt(100000, 999999);
    }

    public static String getNumeroChasis() {
        long value = ThreadLocalRandom.current().nextLong(10000000000L, 99999999999L);
        return Objects.toString(value);
    }
}
