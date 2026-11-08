public final class CalculateTraceListener extends AbstractTextMatrixListener {
    private long trace;
    protected void initialization(Matrix matrix) { trace = 0; }
    protected void nextStep(Matrix matrix, int row, int column) {
        if (row == column) trace += matrix.getValue(row, column);
    }
    protected void finalization(Matrix matrix) { setText(Long.toString(trace)); }
}
