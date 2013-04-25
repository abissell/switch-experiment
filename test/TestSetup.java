import java.util.EnumSet;
import java.util.Random;
import java.util.Set;

enum TestSetup {
	MOST_CASES_TO_LEAST(5000, 1000, 9, false);

	private final int testsPerIteration;
	private final int numIterations;
	private final int maxPower;
	private final boolean throwExceptionsFromDefault;
	private final RandomIntFactory randomIntFactory;
	private final RandomDoubleFactory randomDoubleFactory;
	private final RandomEnumFactory randomEnumFactory;
	private final Set<SwitcherStatementType> intSwitchTypesToTest = EnumSet.of(SwitcherStatementType.INT_SWITCH, SwitcherStatementType.ARRAY);
	private final Set<EnumSize> intEnumTypesToTest = EnumSet.of(EnumSize.BIG, EnumSize.MIDDLE, EnumSize.SMALL);

	private TestSetup(int testsPerIteration, int numIterations, int maxPower, boolean throwExceptionsFromDefault) {
		if (testsPerIteration < maxPower + 5)
			throw new IllegalArgumentException();

		this.testsPerIteration = testsPerIteration;
		this.numIterations = numIterations;
		this.maxPower = maxPower;
		this.throwExceptionsFromDefault = throwExceptionsFromDefault;

		this.randomIntFactory = new JavaRandomIntFactory(new Random(System.currentTimeMillis()));
		this.randomDoubleFactory = new JavaRandomDoubleFactory(new Random(System.currentTimeMillis() + 99999999L));
		this.randomEnumFactory = new JavaRandomEnumFactory(new Random(System.currentTimeMillis() + 99999999999999L));

		for (EnumSize enumSize : intEnumTypesToTest) {
			if (enumSize.maxPower() < maxPower)
				throw new IllegalArgumentException();
		}
	}

	final Set<SwitcherStatementType> intSwitchTypesToTest() {
		return intSwitchTypesToTest;
	}

	final Set<EnumSize> intEnumTypesToTest() {
		return intEnumTypesToTest;
	}

	final int testsPerIteration() {
		return testsPerIteration;
	}

	final int numIterations() {
		return numIterations;
	}

	final int maxPower() {
		return maxPower;
	}

	final boolean throwExceptionsFromDefault() {
		return throwExceptionsFromDefault;
	}

	public RandomIntFactory randomIntFactory() {
		return randomIntFactory;
	}

	public RandomDoubleFactory randomDoubleFactory() {
		return randomDoubleFactory;
	}

	public RandomEnumFactory randomEnumFactory() {
		return randomEnumFactory;
	}
}
