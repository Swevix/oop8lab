public final class CalculateMaxListener extends AbstractTextMatrixListener {
    private long max;
    protected void initialization(Matrix matrix) { max = matrix.getValue(0, 0); }
    protected void nextStep(Matrix matrix, int row, int column) {
        max = Math.max(max, matrix.getValue(row, column));
    }
    protected void finalization(Matrix matrix) { setText(Long.toString(max)); }
}
