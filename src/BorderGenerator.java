import java.util.concurrent.ThreadLocalRandom;

public final class BorderGenerator implements IGenerator {
    public String getName() { return "Случайные числа по краям"; }
    public long getElement(int row, int column, int size) {
        return row == 0 || column == 0 || row == size - 1 || column == size - 1
                ? ThreadLocalRandom.current().nextInt(100) : 0;
    }
}
