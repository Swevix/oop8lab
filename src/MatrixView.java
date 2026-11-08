import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public final class MatrixView extends JFrame {
    public static final Color INK = new Color(29, 43, 67);
    final JComboBox<IGenerator> generators = new JComboBox<>(MatrixData.GENERATORS.toArray(new IGenerator[0]));
    final JSpinner size = new JSpinner(new SpinnerNumberModel(10, 1, 20, 1));
    final JButton regenerate = new JButton("Сгенерировать снова");
    final DisplayMatrixListener display = new DisplayMatrixListener();
    final CalculateMaxListener max = new CalculateMaxListener();
    final CalculateSumListener sum = new CalculateSumListener();
    final CalculateTraceListener trace = new CalculateTraceListener();
    final CalculateMinListener min = new CalculateMinListener();
    final JLabel status = new JLabel();

    public MatrixView() {
        super("ЛР8 · Матрицы и паттерны проектирования");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(920, 640);
        setMinimumSize(new Dimension(840, 560));
        setLocationRelativeTo(null);
        JPanel root = new JPanel(new BorderLayout(0, 18));
        root.setBackground(new Color(240, 244, 249));
        root.setBorder(new EmptyBorder(22, 24, 18, 24));
        setContentPane(root);

        JPanel top = new JPanel(new BorderLayout(0, 18));
        top.setOpaque(false);
        JPanel heading = new JPanel(new GridLayout(2, 1, 0, 5));
        heading.setOpaque(false);
        heading.add(label("Лаборатория матриц", 27, true));
        heading.add(label("ЛР8  /  Стратегия · Наблюдатель · Шаблонный метод", 14, false));
        top.add(heading, BorderLayout.NORTH);
        JPanel controls = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        controls.setOpaque(false);
        generators.setPreferredSize(new Dimension(270, 34));
        generators.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean selected, boolean focus) {
                return super.getListCellRendererComponent(list,
                        value instanceof IGenerator ? ((IGenerator) value).getName() : value,
                        index, selected, focus);
            }
        });
        size.setPreferredSize(new Dimension(65, 34));
        regenerate.setPreferredSize(new Dimension(200, 34));
        controls.add(label("Заполнение", 14, false));
        controls.add(generators);
        controls.add(label("Размер", 14, false));
        controls.add(size);
        controls.add(regenerate);
        top.add(controls, BorderLayout.CENTER);
        root.add(top, BorderLayout.NORTH);

        JPanel center = new JPanel(new BorderLayout(18, 0));
        center.setOpaque(false);
        JScrollPane scroll = new JScrollPane(display);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(216, 224, 235)));
        center.add(scroll, BorderLayout.CENTER);
        JPanel metrics = new JPanel(new GridLayout(4, 1, 0, 10));
        metrics.setOpaque(false);
        metrics.setPreferredSize(new Dimension(205, 0));
        metrics.add(card("Максимум · Max", max));
        metrics.add(card("Сумма · Sum", sum));
        metrics.add(card("След · Trace", trace));
        metrics.add(card("Минимум · Min", min));
        center.add(metrics, BorderLayout.EAST);
        root.add(center, BorderLayout.CENTER);
        status.setFont(new Font("SansSerif", Font.PLAIN, 13));
        status.setForeground(INK);
        root.add(status, BorderLayout.SOUTH);
    }

    private static JLabel label(String text, int size, boolean bold) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", bold ? Font.BOLD : Font.PLAIN, size));
        label.setForeground(INK);
        return label;
    }

    private static JPanel card(String title, AbstractTextMatrixListener value) {
        JPanel card = new JPanel(new BorderLayout(0, 5));
        card.setBackground(Color.WHITE);
        card.setBorder(new EmptyBorder(10, 16, 8, 16));
        card.add(label(title, 13, false), BorderLayout.NORTH);
        value.setFont(new Font("SansSerif", Font.BOLD, 27));
        value.setForeground(new Color(43, 96, 195));
        card.add(value, BorderLayout.CENTER);
        return card;
    }
}
