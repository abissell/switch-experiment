final class TestConfiguration {
	private final TestSetup testSetup;
	private final StoredRandomInts storedRandomInts;
	private final StoredRandomDoubles storedRandomDoubles;

	TestConfiguration(final TestSetup testSetup) {
		this.testSetup = testSetup;
		this.storedRandomInts = new StoredRandomIntsImpl(testSetup.testsPerIteration(), testSetup.randomIntFactory(), testSetup.maxPower());
		this.storedRandomDoubles = new StoredRandomDoublesImpl(testSetup.testsPerIteration(), testSetup.randomDoubleFactory());
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
}
