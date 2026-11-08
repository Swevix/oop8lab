import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public final class DisplayMatrixListener extends JTextArea implements IMatrixListener {
    public DisplayMatrixListener() {
        setEditable(false);
        setFont(new Font(Font.MONOSPACED, Font.PLAIN, 19));
        setBorder(new EmptyBorder(16, 18, 16, 18));
        setForeground(MatrixView.INK);
        setBackground(java.awt.Color.WHITE);
    }

    public void matrixUpdated(Matrix matrix) {
        StringBuilder text = new StringBuilder();
        for (int row = 0; row < matrix.getSize(); row++) {
            for (int column = 0; column < matrix.getSize(); column++) {
                text.append(String.format("%4d", matrix.getValue(row, column)));
            }
            if (row < matrix.getSize() - 1) text.append('\n');
        }
        setText(text.toString());
        setCaretPosition(0);
    }
}
