public final class CalculateSumListener extends AbstractTextMatrixListener {
    private long sum;
    protected void initialization(Matrix matrix) { sum = 0; }
    protected void nextStep(Matrix matrix, int row, int column) { sum += matrix.getValue(row, column); }
    protected void finalization(Matrix matrix) { setText(Long.toString(sum)); }
}
