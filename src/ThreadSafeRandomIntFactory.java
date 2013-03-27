import java.util.concurrent.atomic.AtomicInteger;

final class ThreadSafeRandomIntFactory implements RandomIntFactory {
	private final AtomicPsuedoRandom psuedoRandom;

	ThreadSafeRandomIntFactory(final int seed) {
		this.psuedoRandom = new AtomicPsuedoRandom(seed);
	}

	public final int randomInt(final int n) {
		return psuedoRandom.nextInt(n) - 1;
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
