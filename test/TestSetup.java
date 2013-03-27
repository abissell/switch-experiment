import java.util.EnumSet;
import java.util.Random;
import java.util.Set;

enum TestSetup {
	MOST_CASES_TO_LEAST(5000, 1000, 9, false),
	LEAST_CASES_TO_MOST(5000, 1000, 9, false);

	private final Set<SwitcherStatementType> statementTypesToTest = EnumSet.of(SwitcherStatementType.INT_SWITCH,
																			   SwitcherStatementType.ARRAY);
	private final int testsPerIteration;
	private final int numIterations;
	private final int maxPower;
	private final boolean throwExceptionsFromDefault;
	private final RandomIntFactory randomIntFactory;
	private final RandomDoubleFactory randomDoubleFactory;

	private TestSetup(int testsPerIteration, int numIterations, int maxPower, boolean throwExceptionsFromDefault) {
		if (testsPerIteration < maxPower + 5)
			throw new IllegalArgumentException();

		this.testsPerIteration = testsPerIteration;
		this.numIterations = numIterations;
		this.maxPower = maxPower;
		this.throwExceptionsFromDefault = throwExceptionsFromDefault;

		this.randomIntFactory = new JavaRandomIntFactory(new Random(System.currentTimeMillis()));
		this.randomDoubleFactory = new JavaRandomDoubleFactory(new Random(System.currentTimeMillis() + 99999999L));
	}

	final Set<SwitcherStatementType> statementTypesToTest() {
		return statementTypesToTest;
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
}
