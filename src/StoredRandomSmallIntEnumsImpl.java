final class StoredRandomSmallIntEnumsImpl implements StoredRandomSmallIntEnums {
	private final SmallIntegerEnum[] storedRandomEnums;

	StoredRandomSmallIntEnumsImpl(final int numIntsToStore, final RandomEnumFactory randomEnumFactory, final int n) {
		this.storedRandomEnums = new SmallIntegerEnum[numIntsToStore];
		for (int i = 0; i < storedRandomEnums.length; i++) {
			storedRandomEnums[i] = randomEnumFactory.randomSmallIntEnum(n);
		}
	}

	public final SmallIntegerEnum storedRandomSmallIntEnum(final int i) {
		return storedRandomEnums[i];
	}
}
