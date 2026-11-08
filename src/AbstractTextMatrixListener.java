import javax.swing.JTextArea;

public abstract class AbstractTextMatrixListener extends JTextArea implements IMatrixListener {
    protected AbstractTextMatrixListener() {
        setEditable(false);
        setFocusable(false);
        setOpaque(false);
    }

    @Override
    public final void matrixUpdated(Matrix matrix) {
        initialization(matrix);
        for (int row = 0; row < matrix.getSize(); row++) {
            for (int column = 0; column < matrix.getSize(); column++) {
                nextStep(matrix, row, column);
            }
        }
        finalization(matrix);
    }

    protected abstract void initialization(Matrix matrix);
    protected abstract void nextStep(Matrix matrix, int row, int column);
    protected abstract void finalization(Matrix matrix);
}
