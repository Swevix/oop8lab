import java.util.List;

public final class MatrixData {
    public static final List<IGenerator> GENERATORS = List.of(
            new ZeroGenerator(), new IdentityGenerator(), new DiagonalGenerator(),
            new RandomGenerator(), new BorderGenerator(), new CheckerboardGenerator());

    private MatrixData() { }
}
