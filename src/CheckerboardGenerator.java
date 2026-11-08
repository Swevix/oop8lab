public final class CheckerboardGenerator implements IGenerator {
    public String getName() { return "Шахматная"; }
    public long getElement(int row, int column, int size) { return (row + column) % 2; }
}
