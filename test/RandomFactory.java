import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

enum RandomFactory {
	@SuppressWarnings("UnusedDeclaration")INSTANCE; // Enum Singleton

	private RandomFactory() {

	}

	private static final boolean USE_THREAD_SAFE_RANDOM = false;
	private static final AtomicPsuedoRandom THREAD_SAFE_RANDOM = new AtomicPsuedoRandom((int) System.currentTimeMillis());
	private static final Random RANDOM_INT = new Random(System.currentTimeMillis());
	private static final Random RANDOM_LONG = new Random(System.currentTimeMillis());

	@SuppressWarnings("FinalStaticMethod")
	public static final int randomInt(final int n) {
		if (USE_THREAD_SAFE_RANDOM) {
			return THREAD_SAFE_RANDOM.nextInt(n) - 1;
		} else {
			return RANDOM_INT.nextInt(n);
		}
	}

	@SuppressWarnings("FinalStaticMethod")
	public static final double randomDouble() {
		final long randomLong = RANDOM_LONG.nextLong();
		return Double.longBitsToDouble(randomLong);
	}

	// cf. Java: Concurrency In Practice 12.1.3 by Goetz et al
	private static final class AtomicPsuedoRandom {
		private final AtomicInteger seed;

		private AtomicPsuedoRandom(final int seed) {
			this.seed = new AtomicInteger(seed);
		}

		public final int nextInt(final int n) {
			while (true) {
				final int s = seed.get();
				final int nextSeed = xorShift(s);
				if (seed.compareAndSet(s, nextSeed)) {
					final int remainder = s % n;
					return remainder > 0 ? remainder : remainder + n;
				}
			}
		}
	}

	private static int xorShift(int y) {
		y ^= (y << 6);
		y ^= (y >>> 21);
		y ^= (y << 7);

		return y;
	}


}
