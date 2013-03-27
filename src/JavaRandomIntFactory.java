import java.util.Random;

final class JavaRandomIntFactory implements RandomIntFactory {
	private final Random randomIntGenerator;

	JavaRandomIntFactory(final Random randomIntGenerator) {
		this.randomIntGenerator = randomIntGenerator;
	}

	public final int randomInt(final int n) {
		return randomIntGenerator.nextInt(n);
	}
}
