final class TestConfiguration {
	private final TestSetup testSetup;
	private final StoredRandomInts storedRandomInts;
	private final StoredRandomDoubles storedRandomDoubles;
	private final StoredRandomBigIntEnums storedRandomBigIntEnums;
	private final StoredRandomMiddleIntEnums storedRandomMiddleIntEnums;
	private final StoredRandomSmallIntEnums storedRandomSmallIntEnums;

	TestConfiguration(final TestSetup testSetup) {
		this.testSetup = testSetup;
		this.storedRandomInts = new StoredRandomIntsImpl(testSetup.testsPerIteration(), testSetup.randomIntFactory(), testSetup.maxPower());
		this.storedRandomDoubles = new StoredRandomDoublesImpl(testSetup.testsPerIteration(), testSetup.randomDoubleFactory());
		this.storedRandomBigIntEnums = new StoredRandomBigIntEnumsImpl(testSetup.testsPerIteration(), testSetup.randomEnumFactory(), testSetup.maxPower());
		this.storedRandomMiddleIntEnums = new StoredRandomMiddleIntEnumsImpl(testSetup.testsPerIteration(), testSetup.randomEnumFactory(), testSetup.maxPower());
		this.storedRandomSmallIntEnums = new StoredRandomSmallIntEnumsImpl(testSetup.testsPerIteration(), testSetup.randomEnumFactory(), testSetup.maxPower());
	}

	final TestSetup testSetup() {
		return testSetup;
	}

	final int getRandomIntForTest(final int test) {
		return storedRandomInts.storedRandomInt(test);
	}

	final double getRandomDoubleForTest(final int test) {
		return storedRandomDoubles.storedRandomDouble(test);
	}

	final BigIntegerEnum getRandomBigIntEnumForTest(final int test) {
		return storedRandomBigIntEnums.storedRandomBigIntEnum(test);
	}

	final MiddleIntegerEnum getRandomMiddleIntEnumForTest(final int test) {
		return storedRandomMiddleIntEnums.storedRandomMiddleIntEnum(test);
	}

	final SmallIntegerEnum getRandomSmallIntEnumForTest(final int test) {
		return storedRandomSmallIntEnums.storedRandomSmallIntEnum(test);
	}
}
