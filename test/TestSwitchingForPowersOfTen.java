import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class TestSwitchingForPowersOfTen extends AbstractBenchmark {
	private static final TestSetup SETUP_TYPE = TestSetup.MOST_CASES_TO_LEAST;
	private static final TestConfiguration CONFIG = new TestConfiguration(TestSetup.MOST_CASES_TO_LEAST);
	private static final int NUM_ITERS = SETUP_TYPE.numIterations();
	private static final int TESTS_PER_ITER = SETUP_TYPE.testsPerIteration();
	private static final int MAX_POWER = SETUP_TYPE.maxPower();
	private static final boolean THROW_EXCEPTIONS_FROM_DEFAULT = SETUP_TYPE.throwExceptionsFromDefault();
	private static final int MAX_NUM_CASES = 32;
	private static final int NUM_SWITCHERS = MAX_NUM_CASES + 1; // Additional space for the empty switcher

	private static final Map<SwitcherStatementType, Switcher[]> SWITCHERS = new EnumMap<>(SwitcherStatementType.class);
	static {
		for (SwitcherStatementType type : CONFIG.testSetup().statementTypesToTest()) {
			final Switcher[] switchers = new Switcher[NUM_SWITCHERS];
			SWITCHERS.put(type, switchers);
			final SwitcherFactory switcherFactory;
			switch (type) {
				case INT_SWITCH:
					switcherFactory = new IntSwitcherFactory(THROW_EXCEPTIONS_FROM_DEFAULT);
					break;
				case ARRAY:
					switcherFactory = new ArraySwitcherFactory();
					break;
				default:
					throw new IllegalArgumentException("No SwitcherFactory defined for statement type " + type);
			}

			ArraysHelper.fill(switchers, new ArrayFillFunction<Switcher>() {
				@Override
				public Switcher getElementForIndex(int index) {
					return switcherFactory.getNewSwitcher(index);
				}
			});
		}
	}

	private static final Map<SwitcherStatementType, long[]> results = new EnumMap<>(SwitcherStatementType.class);
	static {
		for (SwitcherStatementType type : CONFIG.testSetup().statementTypesToTest()) {
			final long[] resultsForSwitchers = new long[NUM_SWITCHERS];
			Arrays.fill(resultsForSwitchers, 0L);
			results.put(type, new long[NUM_SWITCHERS]);
		}
	}

	private static final int[] RANDOM_INTS = new int[SETUP_TYPE.testsPerIteration()];
	private static final double[] RANDOM_DOUBLES = new double[SETUP_TYPE.testsPerIteration()];
	static {
		ArraysHelper.fillIntArray(RANDOM_INTS, new ArrayFillFunction<Integer>() {
			@Override
			public Integer getElementForIndex(int index) {
				return CONFIG.getRandomIntForTest(index);
			}
		});

		ArraysHelper.fillDoubleArray(RANDOM_DOUBLES, new ArrayFillFunction<Double>() {
			@Override
			public Double getElementForIndex(int index) {
				return CONFIG.getRandomDoubleForTest(index);
			}
		});
	}

	public TestSwitchingForPowersOfTen() {

	}

	@BeforeClass
	public static void setup() {
		printCheckRandoms();
		System.out.println("Starting tests.");
	}

	@SuppressWarnings("UnusedDeclaration")
	private static void printCheckRandoms() {
		System.out.print("First 20 random ints: ");
		for (int i = 0; i < 20; i++) {
			if (i == 19)
				System.out.println(RANDOM_INTS[i]);
			else
				System.out.print(RANDOM_INTS[i] + ", ");
		}

		System.out.print("First 20 random doubles: ");
		for (int i = 0; i < 20; i++) {
			if (i == 19)
				System.out.println(RANDOM_DOUBLES[i]);
			else
				System.out.print(RANDOM_DOUBLES[i] + ", ");
		}
	}

	private long runTest(final Switcher switcher, final int iterationCount) throws ParseException {
		final double d = RANDOM_DOUBLES[iterationCount];
		final double mult = d * switcher.switchForCase(RANDOM_INTS[iterationCount]);

		return Double.doubleToLongBits(mult);
	}

	private void runTestsForSwitcher(final SwitcherStatementType type, final int numCases) throws ParseException {
		final Switcher switcher = SWITCHERS.get(type)[numCases];
		final long[] resultsBucket = results.get(type);

		long result = resultsBucket[numCases];
		for (int i = 0; i < NUM_ITERS; i++) {
			for (int j = 0; j < TESTS_PER_ITER; j++) {
				result += runTest(switcher, j);
			}
		}

		resultsBucket[numCases] = result;
	}

	private void switchCasesOnType(final SwitcherStatementType type, final int numCases) {
		if (numCases < MAX_POWER)
			return;

		try {
			runTestsForSwitcher(type, numCases);
		} catch (ParseException e) {
			System.out.println("ParseException" + e.getMessage());
		}
	}

	private void intSwitchCases(final int numCases) {
		switchCasesOnType(SwitcherStatementType.INT_SWITCH, numCases);
	}

	private void arraySwitchCases(final int numCases) {
		switchCasesOnType(SwitcherStatementType.ARRAY, numCases);
	}

	@AfterClass
	public static void printResultToPreventOptimization() {
		System.out.println("Tests finished.");
		for (SwitcherStatementType type : results.keySet()) {
			System.out.print("RESULTS FOR TYPE: " + type + ": ");
			final long[] resultsForType = results.get(type);
			ArraysHelper.forEach(resultsForType, new ArrayFunctionOnLongIndexedElements() {
				@Override
				public final void f(int index, long e) {
					System.out.print(index + "=" + e +", ");
				}
			});
		}
		System.out.println();

		for (SwitcherStatementType type : results.keySet()) {
			final long[] resultsByNumCases = results.get(type);
			final long baseResult = resultsByNumCases[MAX_NUM_CASES];
			ArraysHelper.forEach(resultsByNumCases, new ArrayFunctionOnLongIndexedElements() {
				@Override
				public final void f(int index, long e) {
					try {
						if (index >= MAX_POWER)
							Assert.assertEquals(e, baseResult);
					} catch (AssertionFailedError error) {
						System.out.println("Bad result at index = " + index + " with result=" + e + " != baseResult=" + baseResult);
						throw error;
					}
				}
			});
		}
	}

	@Test
	public void intSwitch32cases() {
		intSwitchCases(32);
	}

	@Test
	public void intSwitch31cases() {
		intSwitchCases(31);
	}

	@Test
	public void intSwitch30cases() {
		intSwitchCases(30);
	}

	@Test
	public void intSwitch29cases() {
		intSwitchCases(29);
	}

	@Test
	public void intSwitch28cases() {
		intSwitchCases(28);
	}

	@Test
	public void intSwitch27cases() {
		intSwitchCases(27);
	}

	@Test
	public void intSwitch26cases() {
		intSwitchCases(26);
	}

	@Test
	public void intSwitch25cases() {
		intSwitchCases(25);
	}

	@Test
	public void intSwitch24cases() {
		intSwitchCases(24);
	}

	@Test
	public void intSwitch23cases() {
		intSwitchCases(23);
	}

	@Test
	public void intSwitch22cases() {
		intSwitchCases(22);
	}

	@Test
	public void intSwitch21cases() {
		intSwitchCases(21);
	}

	@Test
	public void intSwitch20cases() {
		intSwitchCases(20);
	}

	@Test
	public void intSwitch19cases() {
		intSwitchCases(19);
	}

	@Test
	public void intSwitch18cases() {
		intSwitchCases(18);
	}

	@Test
	public void intSwitch17cases() {
		intSwitchCases(17);
	}

	@Test
	public void intSwitch16cases() {
		intSwitchCases(16);
	}

	@Test
	public void intSwitch15cases() {
		intSwitchCases(15);
	}

	@Test
	public void intSwitch14cases() {
		intSwitchCases(14);
	}

	@Test
	public void intSwitch13cases() {
		intSwitchCases(13);
	}

	@Test
	public void intSwitch12cases() {
		intSwitchCases(12);
	}

	@Test
	public void intSwitch11cases() {
		intSwitchCases(11);
	}

	@Test
	public void intSwitch10cases() {
		intSwitchCases(10);
	}

	@Test
	public void intSwitch9cases() {
		intSwitchCases(9);
	}

	@Test
	public void intSwitch8cases() {
		intSwitchCases(8);
	}

	@Test
	public void intSwitch7cases() {
		intSwitchCases(7);
	}

	@Test
	public void intSwitch6cases() {
		intSwitchCases(6);
	}

	@Test
	public void intSwitch5cases() {
		intSwitchCases(5);
	}

	@Test
	public void intSwitch4cases() {
		intSwitchCases(4);
	}

	@Test
	public void intSwitch3cases() {
		intSwitchCases(3);
	}

	@Test
	public void intSwitch2cases() {
		intSwitchCases(2);
	}

	@Test
	public void intSwitch1cases() {
		intSwitchCases(1);
	}

	@Test
	public void intSwitch0cases() {
		intSwitchCases(0);
	}

	@Test
	public void arraySwitch32cases() {
		arraySwitchCases(32);
	}

	@Test
	public void arraySwitch31cases() {
		arraySwitchCases(31);
	}

	@Test
	public void arraySwitch30cases() {
		arraySwitchCases(30);
	}

	@Test
	public void arraySwitch29cases() {
		arraySwitchCases(29);
	}

	@Test
	public void arraySwitch28cases() {
		arraySwitchCases(28);
	}

	@Test
	public void arraySwitch27cases() {
		arraySwitchCases(27);
	}

	@Test
	public void arraySwitch26cases() {
		arraySwitchCases(26);
	}

	@Test
	public void arraySwitch25cases() {
		arraySwitchCases(25);
	}

	@Test
	public void arraySwitch24cases() {
		arraySwitchCases(24);
	}

	@Test
	public void arraySwitch23cases() {
		arraySwitchCases(23);
	}

	@Test
	public void arraySwitch22cases() {
		arraySwitchCases(22);
	}

	@Test
	public void arraySwitch21cases() {
		arraySwitchCases(21);
	}

	@Test
	public void arraySwitch20cases() {
		arraySwitchCases(20);
	}

	@Test
	public void arraySwitch19cases() {
		arraySwitchCases(19);
	}

	@Test
	public void arraySwitch18cases() {
		arraySwitchCases(18);
	}

	@Test
	public void arraySwitch17cases() {
		arraySwitchCases(17);
	}

	@Test
	public void arraySwitch16cases() {
		arraySwitchCases(16);
	}

	@Test
	public void arraySwitch15cases() {
		arraySwitchCases(15);
	}

	@Test
	public void arraySwitch14cases() {
		arraySwitchCases(14);
	}

	@Test
	public void arraySwitch13cases() {
		arraySwitchCases(13);
	}

	@Test
	public void arraySwitch12cases() {
		arraySwitchCases(12);
	}

	@Test
	public void arraySwitch11cases() {
		arraySwitchCases(11);
	}

	@Test
	public void arraySwitch10cases() {
		arraySwitchCases(10);
	}

	@Test
	public void arraySwitch9cases() {
		arraySwitchCases(9);
	}

	@Test
	public void arraySwitch8cases() {
		arraySwitchCases(8);
	}

	@Test
	public void arraySwitch7cases() {
		arraySwitchCases(7);
	}

	@Test
	public void arraySwitch6cases() {
		arraySwitchCases(6);
	}

	@Test
	public void arraySwitch5cases() {
		arraySwitchCases(5);
	}

	@Test
	public void arraySwitch4cases() {
		arraySwitchCases(4);
	}

	@Test
	public void arraySwitch3cases() {
		arraySwitchCases(3);
	}

	@Test
	public void arraySwitch2cases() {
		arraySwitchCases(2);
	}

	@Test
	public void arraySwitch1cases() {
		arraySwitchCases(1);
	}

	@Test
	public void arraySwitch0cases() {
		arraySwitchCases(0);
	}
}
