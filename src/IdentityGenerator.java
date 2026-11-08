public final class IdentityGenerator implements IGenerator {
    public String getName() { return "Единичная"; }
    public long getElement(int row, int column, int size) { return row == column ? 1 : 0; }
}
