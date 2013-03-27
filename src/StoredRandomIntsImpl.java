final class StoredRandomIntsImpl implements StoredRandomInts {
	private final int[] storedRandomInts;

	StoredRandomIntsImpl(final int numIntsToStore, final RandomIntFactory randomIntFactory, final int n) {
		this.storedRandomInts = new int[numIntsToStore];
		for (int i = 0; i < storedRandomInts.length; i++) {
			storedRandomInts[i] = randomIntFactory.randomInt(n);
		}
	}

	public final int storedRandomInt(final int i) {
		return storedRandomInts[i];
	}
}
