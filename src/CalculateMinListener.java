public final class CalculateMinListener extends AbstractTextMatrixListener {
    private long min;
    protected void initialization(Matrix matrix) { min = matrix.getValue(0, 0); }
    protected void nextStep(Matrix matrix, int row, int column) {
        min = Math.min(min, matrix.getValue(row, column));
    }
    protected void finalization(Matrix matrix) { setText(Long.toString(min)); }
}
