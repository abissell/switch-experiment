import java.util.Random;

final class JavaRandomEnumFactory implements RandomEnumFactory {
	private final Random randomIntGenerator;

	JavaRandomEnumFactory(final Random randomIntGenerator) {
		this.randomIntGenerator = randomIntGenerator;
	}

	public final BigIntegerEnum randomBigIntEnum(final int n) {
		return BigIntegerEnum.fromCode(randomIntGenerator.nextInt(n));
	}

	public final MiddleIntegerEnum randomMiddleIntEnum(final int n) {
		return MiddleIntegerEnum.fromCode(randomIntGenerator.nextInt(n));
	}

	public final SmallIntegerEnum randomSmallIntEnum(final int n) {
		return SmallIntegerEnum.fromCode(randomIntGenerator.nextInt(n));
	}
}
