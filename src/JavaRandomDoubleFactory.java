import java.util.Random;

final class JavaRandomDoubleFactory implements RandomDoubleFactory {
	private final Random randomLongGenerator;

	JavaRandomDoubleFactory(final Random randomLongGenerator) {
		this.randomLongGenerator = randomLongGenerator;
	}

	public final double randomDouble() {
		return Double.longBitsToDouble(randomLongGenerator.nextLong());
	}
}
