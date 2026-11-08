import java.util.concurrent.ThreadLocalRandom;

public final class DiagonalGenerator implements IGenerator {
    public String getName() { return "Диагональная"; }
    public long getElement(int row, int column, int size) {
        return row == column ? ThreadLocalRandom.current().nextInt(100) : 0;
    }
}
