final class StoredRandomMiddleIntEnumsImpl implements StoredRandomMiddleIntEnums {
	private final MiddleIntegerEnum[] storedRandomEnums;

	StoredRandomMiddleIntEnumsImpl(final int numIntsToStore, final RandomEnumFactory randomEnumFactory, final int n) {
		this.storedRandomEnums = new MiddleIntegerEnum[numIntsToStore];
		for (int i = 0; i < storedRandomEnums.length; i++) {
			storedRandomEnums[i] = randomEnumFactory.randomMiddleIntEnum(n);
		}
	}

	public final MiddleIntegerEnum storedRandomMiddleIntEnum(final int i) {
		return storedRandomEnums[i];
	}
}
