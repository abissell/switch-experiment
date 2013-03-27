final class StoredRandomDoublesImpl implements StoredRandomDoubles {
	private final double[] storedRandomDoubles;

	StoredRandomDoublesImpl(final int numDoublesToStore, final RandomDoubleFactory randomDoubleFactory) {
		this.storedRandomDoubles = new double[numDoublesToStore];
		for (int i = 0; i < storedRandomDoubles.length; i++) {
			storedRandomDoubles[i] = randomDoubleFactory.randomDouble();
		}
	}

	public final double storedRandomDouble(final int i) {
		return storedRandomDoubles[i];
	}
}
