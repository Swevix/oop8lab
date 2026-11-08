public final class ZeroGenerator implements IGenerator {
    public String getName() { return "Нулевая"; }
    public long getElement(int row, int column, int size) { return 0; }
}
