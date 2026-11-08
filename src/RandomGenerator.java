import java.util.concurrent.ThreadLocalRandom;

public final class RandomGenerator implements IGenerator {
    public String getName() { return "Случайная"; }
    public long getElement(int row, int column, int size) {
        return ThreadLocalRandom.current().nextInt(100);
    }
}
