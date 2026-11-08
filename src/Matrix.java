import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Matrix {
    private final List<IMatrixListener> listeners = new ArrayList<>();
    private IGenerator generator;
    private long[][] values;

    public Matrix(int size, IGenerator generator) {
        checkSize(size);
        this.generator = Objects.requireNonNull(generator);
        values = new long[size][size];
        regenerate();
    }

    public int getSize() { return values.length; }
    public long getValue(int row, int column) { return values[row][column]; }
    public IGenerator getGenerator() { return generator; }

    public void setGenerator(IGenerator generator) {
        this.generator = Objects.requireNonNull(generator);
        regenerate();
    }

    public void setSize(int size) {
        checkSize(size);
        values = new long[size][size];
        regenerate();
    }

    public void addListener(IMatrixListener listener) {
        Objects.requireNonNull(listener);
        if (!listeners.contains(listener)) {
            listeners.add(listener);
            listener.matrixUpdated(this);
        }
    }

    public void removeListener(IMatrixListener listener) { listeners.remove(listener); }

    public void regenerate() {
        for (int row = 0; row < getSize(); row++) {
            for (int column = 0; column < getSize(); column++) {
                values[row][column] = generator.getElement(row, column, getSize());
            }
        }
        for (IMatrixListener listener : List.copyOf(listeners)) {
            listener.matrixUpdated(this);
        }
    }

    private static void checkSize(int size) {
        if (size < 1 || size > 20) throw new IllegalArgumentException("Размер должен быть от 1 до 20");
    }
}
