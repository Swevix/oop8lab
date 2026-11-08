public final class MatrixController {
    public MatrixController(Matrix matrix, MatrixView view) {
        matrix.addListener(view.display);
        matrix.addListener(view.max);
        matrix.addListener(view.sum);
        matrix.addListener(view.trace);
        matrix.addListener(view.min);
        matrix.addListener(changed -> view.status.setText(changed.getGenerator().getName()
                + "   •   " + changed.getSize() + " × " + changed.getSize()
                + "   •   Матрица и 4 характеристики обновлены"));
        view.generators.addActionListener(event ->
                matrix.setGenerator((IGenerator) view.generators.getSelectedItem()));
        view.size.addChangeListener(event -> matrix.setSize((Integer) view.size.getValue()));
        view.regenerate.addActionListener(event -> matrix.regenerate());
    }
}
