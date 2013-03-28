final class StoredRandomBigIntEnumsImpl implements StoredRandomBigIntEnums {
	private final BigIntegerEnum[] storedRandomEnums;

	StoredRandomBigIntEnumsImpl(final int numIntsToStore, final RandomEnumFactory randomEnumFactory, final int n) {
		this.storedRandomEnums = new BigIntegerEnum[numIntsToStore];
		for (int i = 0; i < storedRandomEnums.length; i++) {
			storedRandomEnums[i] = randomEnumFactory.randomBigIntEnum(n);
		}
	}

	public final BigIntegerEnum storedRandomBigIntEnum(final int i) {
		return storedRandomEnums[i];
	}
}
