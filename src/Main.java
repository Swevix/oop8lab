import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public final class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException exception) {
                System.err.println("Используется стандартное оформление Swing");
            }
            MatrixView view = new MatrixView();
            new MatrixController(new Matrix(10, MatrixData.GENERATORS.get(0)), view);
            view.setVisible(true);
        });
    }
}
