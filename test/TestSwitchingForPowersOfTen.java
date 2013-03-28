import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.util.*;

public class TestSwitchingForPowersOfTen extends AbstractBenchmark {
	private static final TestSetup SETUP_TYPE = TestSetup.MOST_CASES_TO_LEAST;
	private static final TestConfiguration CONFIG = new TestConfiguration(TestSetup.MOST_CASES_TO_LEAST);
	private static final int NUM_ITERS = SETUP_TYPE.numIterations();
	private static final int TESTS_PER_ITER = SETUP_TYPE.testsPerIteration();
	private static final int MAX_POWER = SETUP_TYPE.maxPower();
	private static final boolean THROW_EXCEPTIONS_FROM_DEFAULT = SETUP_TYPE.throwExceptionsFromDefault();
	private static final int MAX_NUM_CASES = 32;
	private static final int NUM_SWITCHERS = MAX_NUM_CASES + 1; // Additional space for the empty switcher

	private static final Map<SwitcherStatementType, IntSwitcher[]> INT_SWITCHERS = new EnumMap<>(SwitcherStatementType.class);
	static {
		for (SwitcherStatementType type : CONFIG.testSetup().intSwitchTypesToTest()) {
			final IntSwitcher[] intSwitchers = new IntSwitcher[NUM_SWITCHERS];
			INT_SWITCHERS.put(type, intSwitchers);
			final IntSwitcherFactory intSwitcherFactory;
			switch (type) {
				case INT_SWITCH:
					intSwitcherFactory = new IntSwitcherFactoryImpl(THROW_EXCEPTIONS_FROM_DEFAULT);
					break;
				case ARRAY:
					intSwitcherFactory = new ArraySwitcherFactory();
					break;
				default:
					throw new IllegalArgumentException("No IntSwitcherFactory defined for statement type " + type);
			}

			ArraysHelper.fill(intSwitchers, new ArrayFillFunction<IntSwitcher>() {
				@Override
				public IntSwitcher getElementForIndex(int index) {
					return intSwitcherFactory.getNewSwitcher(index);
				}
			});
		}
	}

	private static final Map<EnumSize, EnumSwitcher[]> ENUM_SWITCHERS = new HashMap<>();
	static {
		final EnumSwitcherFactory enumFactory = new EnumSwitcherFactoryImpl(THROW_EXCEPTIONS_FROM_DEFAULT);

		for (EnumSize size : EnumSize.values()) {
			final EnumSwitcher[] enumSwitchers = new EnumSwitcher[NUM_SWITCHERS];
			ENUM_SWITCHERS.put(size, enumSwitchers);
			final ArrayFillFunction<EnumSwitcher> fillFunction;
			if (size == EnumSize.BIG) {
				fillFunction = new ArrayFillFunction<EnumSwitcher>() {
					@Override
					public EnumSwitcher getElementForIndex(int index) {
						if (index < EnumSize.BIG.maxNumCases())
							return enumFactory.getNewBigEnumSwitcher(index);
						else
							return null;
					}
				};
			} else if (size == EnumSize.MIDDLE) {
				fillFunction = new ArrayFillFunction<EnumSwitcher>() {
					@Override
					public EnumSwitcher getElementForIndex(int index) {
						if (index < EnumSize.MIDDLE.maxNumCases())
							return enumFactory.getNewMiddleEnumSwitcher(index);
						else
							return null;
					}
				};
			} else if (size == EnumSize.SMALL) {
				fillFunction = new ArrayFillFunction<EnumSwitcher>() {
					@Override
					public EnumSwitcher getElementForIndex(int index) {
						if (index < EnumSize.SMALL.maxNumCases())
							return enumFactory.getNewSmallEnumSwitcher(index);
						else
							return null;
					}
				};
			} else {
				throw new IllegalArgumentException();
			}

			ArraysHelper.fill(enumSwitchers, fillFunction);
		}
	}

	private static final Map<SwitcherStatementType, long[]> INT_SWITCHER_RESULTS = new EnumMap<>(SwitcherStatementType.class);
	static {
		for (SwitcherStatementType type : CONFIG.testSetup().intSwitchTypesToTest()) {
			final long[] resultsForSwitchers = new long[NUM_SWITCHERS];
			Arrays.fill(resultsForSwitchers, 0L);
			INT_SWITCHER_RESULTS.put(type, new long[NUM_SWITCHERS]);
		}
	}

	private static final Map<EnumSize, long[]> ENUM_SWITCHER_RESULTS = new EnumMap<>(EnumSize.class);
	static {
		for (EnumSize type : CONFIG.testSetup().intEnumTypesToTest()) {
			final long[] resultsForSwitchers = new long[NUM_SWITCHERS];
			Arrays.fill(resultsForSwitchers, 0L);
			ENUM_SWITCHER_RESULTS.put(type, new long[NUM_SWITCHERS]);
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

	private static final BigIntegerEnum[] RANDOM_BIG_INT_ENUMS = new BigIntegerEnum[SETUP_TYPE.testsPerIteration()];
	private static final MiddleIntegerEnum[] RANDOM_MIDDLE_INT_ENUMS = new MiddleIntegerEnum[SETUP_TYPE.testsPerIteration()];
	private static final SmallIntegerEnum[] RANDOM_SMALL_INT_ENUMS = new SmallIntegerEnum[SETUP_TYPE.testsPerIteration()];
	static {
		for (EnumSize type : CONFIG.testSetup().intEnumTypesToTest()) {
			if (type == EnumSize.BIG) {
				ArraysHelper.fill(RANDOM_BIG_INT_ENUMS, new ArrayFillFunction<BigIntegerEnum>() {
					@Override
					public BigIntegerEnum getElementForIndex(int index) {
						return CONFIG.getRandomBigIntEnumForTest(index);
					}
				});
			} else if (type == EnumSize.MIDDLE) {
				ArraysHelper.fill(RANDOM_MIDDLE_INT_ENUMS, new ArrayFillFunction<MiddleIntegerEnum>() {
					@Override
					public MiddleIntegerEnum getElementForIndex(int index) {
						return CONFIG.getRandomMiddleIntEnumForTest(index);
					}
				});
			} else if (type == EnumSize.SMALL) {
				ArraysHelper.fill(RANDOM_SMALL_INT_ENUMS, new ArrayFillFunction<SmallIntegerEnum>() {
					@Override
					public SmallIntegerEnum getElementForIndex(int index) {
						return CONFIG.getRandomSmallIntEnumForTest(index);
					}
				});
			}
		}
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

	private long runIntTest(final IntSwitcher intSwitcher, final int iterationCount) throws ParseException {
		final double d = RANDOM_DOUBLES[iterationCount];
		final double mult = d * intSwitcher.switchForCase(RANDOM_INTS[iterationCount]);

		return Double.doubleToLongBits(mult);
	}

	private long runBigIntEnumTest(final BigEnumSwitcher enumSwitcher, final BigIntegerEnum[] randomEnums, final int iterationCount) throws ParseException {
		final double d = RANDOM_DOUBLES[iterationCount];
		final double mult = d * enumSwitcher.switchForCase(randomEnums[iterationCount]);

		return Double.doubleToLongBits(mult);
	}

	private long runMiddleIntEnumTest(final MiddleEnumSwitcher enumSwitcher, final MiddleIntegerEnum[] randomEnums, final int iterationCount) throws ParseException {
		final double d = RANDOM_DOUBLES[iterationCount];
		final double mult = d * enumSwitcher.switchForCase(randomEnums[iterationCount]);

		return Double.doubleToLongBits(mult);
	}

	private long runSmallIntEnumTest(final SmallEnumSwitcher enumSwitcher, final SmallIntegerEnum[] randomEnums, final int iterationCount) throws ParseException {
		final double d = RANDOM_DOUBLES[iterationCount];
		final double mult = d * enumSwitcher.switchForCase(randomEnums[iterationCount]);

		return Double.doubleToLongBits(mult);
	}

	private void runIntTestsForSwitcher(final SwitcherStatementType type, final int numCases) throws ParseException {
		final IntSwitcher intSwitcher = INT_SWITCHERS.get(type)[numCases];
		final long[] resultsBucket = INT_SWITCHER_RESULTS.get(type);

		long result = resultsBucket[numCases];
		for (int i = 0; i < NUM_ITERS; i++) {
			for (int j = 0; j < TESTS_PER_ITER; j++) {
				result += runIntTest(intSwitcher, j);
			}
		}

		resultsBucket[numCases] = result;
	}

	private void runIntEnumTestsForEnumSize(final EnumSize enumSize, final int numCases) throws ParseException {
		if (numCases > (enumSize.maxNumCases() - 1))
			return;

		if (enumSize == EnumSize.BIG) {

			BigEnumSwitcher bigEnumSwitcher = (BigEnumSwitcher) ENUM_SWITCHERS.get(enumSize)[numCases];
			final long[] resultsBucket = ENUM_SWITCHER_RESULTS.get(enumSize);

			long result = resultsBucket[numCases];
			for (int i = 0; i < NUM_ITERS; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					result += runBigIntEnumTest(bigEnumSwitcher, RANDOM_BIG_INT_ENUMS, j);
				}
			}

			resultsBucket[numCases] = result;
		} else if (enumSize == EnumSize.MIDDLE) {
			MiddleEnumSwitcher middleEnumSwitcher = (MiddleEnumSwitcher) ENUM_SWITCHERS.get(enumSize)[numCases];
			final long[] resultsBucket = ENUM_SWITCHER_RESULTS.get(enumSize);

			long result = resultsBucket[numCases];
			for (int i = 0; i < NUM_ITERS; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					result += runMiddleIntEnumTest(middleEnumSwitcher, RANDOM_MIDDLE_INT_ENUMS, j);
				}
			}

			resultsBucket[numCases] = result;
		} else if (enumSize == EnumSize.SMALL) {
			SmallEnumSwitcher smallEnumSwitcher = (SmallEnumSwitcher) ENUM_SWITCHERS.get(enumSize)[numCases];
			final long[] resultsBucket = ENUM_SWITCHER_RESULTS.get(enumSize);

			long result = resultsBucket[numCases];
			for (int i = 0; i < NUM_ITERS; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					result += runSmallIntEnumTest(smallEnumSwitcher, RANDOM_SMALL_INT_ENUMS, j);
				}
			}

			resultsBucket[numCases] = result;
		}
	}

	private void switchIntCasesOnType(final SwitcherStatementType type, final int numCases) {
		if (numCases < MAX_POWER)
			return;

		try {
			runIntTestsForSwitcher(type, numCases);
		} catch (ParseException e) {
			System.out.println("ParseException" + e.getMessage());
		}
	}

	private void intSwitchCases(final int numCases) {
		switchIntCasesOnType(SwitcherStatementType.INT_SWITCH, numCases);
	}

	private void arraySwitchCases(final int numCases) {
		switchIntCasesOnType(SwitcherStatementType.ARRAY, numCases);
	}

	private void bigIntEnumSwitchCases(final int numCases) {
		if (numCases < MAX_POWER)
			return;

		try {
			runIntEnumTestsForEnumSize(EnumSize.BIG, numCases);
		} catch (ParseException e) {
			System.out.println("ParseException" + e.getMessage());
		}
	}

	private void middleIntEnumSwitchCases(final int numCases) {
		if (numCases < MAX_POWER)
			return;

		try {
			runIntEnumTestsForEnumSize(EnumSize.MIDDLE, numCases);
		} catch (ParseException e) {
			System.out.println("ParseException" + e.getMessage());
		}
	}

	private void smallIntEnumSwitchCases(final int numCases) {
		if (numCases < MAX_POWER)
			return;

		try {
			runIntEnumTestsForEnumSize(EnumSize.SMALL, numCases);
		} catch (ParseException e) {
			System.out.println("ParseException" + e.getMessage());
		}
	}

	@AfterClass
	public static void printResultToPreventOptimization() {
		final ArrayFunctionOnLongIndexedElements printLong = new ArrayFunctionOnLongIndexedElements() {
			@Override
			public void f(int index, long e) {
				System.out.print(index + "=" + e +", ");
			}
		};

		System.out.println("Tests finished.");
		for (SwitcherStatementType type : INT_SWITCHER_RESULTS.keySet()) {
			System.out.print("INT_SWITCHER_RESULTS FOR TYPE: " + type + ": ");
			final long[] resultsForType = INT_SWITCHER_RESULTS.get(type);
			ArraysHelper.forEach(resultsForType, printLong);
		}

		System.out.println();

		for (EnumSize size : ENUM_SWITCHER_RESULTS.keySet()) {
			System.out.println("ENUM_SWITCHER_RESULTS FOR TYPE: " + size + ": ");
			final long[] resultsForType = ENUM_SWITCHER_RESULTS.get(size);
			ArraysHelper.forEach(resultsForType, printLong);
		}

		System.out.println();

		for (SwitcherStatementType type : INT_SWITCHER_RESULTS.keySet()) {
			final long[] resultsByNumCases = INT_SWITCHER_RESULTS.get(type);
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

		for (EnumSize type : ENUM_SWITCHER_RESULTS.keySet()) {
			final long[] resultsByNumCases = ENUM_SWITCHER_RESULTS.get(type);
			final long baseResult = resultsByNumCases[MAX_NUM_CASES];
			ArraysHelper.forEach(resultsByNumCases, new ArrayFunctionOnLongIndexedElements() {
				@Override
				public void f(int index, long e) {
					try {
						if (index >= MAX_POWER)
							Assert.assertEquals(e, baseResult);
					} catch (AssertionFailedError error) {
						System.out.println("Bad result at index = " + index + " with result=" + e + " != baseResult=" + baseResult);
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

	@Test
	public void bigIntEnumSwitch32cases() {
		bigIntEnumSwitchCases(32);
	}

	@Test
	public void bigIntEnumSwitch31cases() {
		bigIntEnumSwitchCases(31);
	}

	@Test
	public void bigIntEnumSwitch30cases() {
		bigIntEnumSwitchCases(30);
	}

	@Test
	public void bigIntEnumSwitch29cases() {
		bigIntEnumSwitchCases(29);
	}

	@Test
	public void bigIntEnumSwitch28cases() {
		bigIntEnumSwitchCases(28);
	}

	@Test
	public void bigIntEnumSwitch27cases() {
		bigIntEnumSwitchCases(27);
	}

	@Test
	public void bigIntEnumSwitch26cases() {
		bigIntEnumSwitchCases(26);
	}

	@Test
	public void bigIntEnumSwitch25cases() {
		bigIntEnumSwitchCases(25);
	}

	@Test
	public void bigIntEnumSwitch24cases() {
		bigIntEnumSwitchCases(24);
	}

	@Test
	public void bigIntEnumSwitch23cases() {
		bigIntEnumSwitchCases(23);
	}

	@Test
	public void bigIntEnumSwitch22cases() {
		bigIntEnumSwitchCases(22);
	}

	@Test
	public void bigIntEnumSwitch21cases() {
		bigIntEnumSwitchCases(21);
	}

	@Test
	public void bigIntEnumSwitch20cases() {
		bigIntEnumSwitchCases(20);
	}

	@Test
	public void bigIntEnumSwitch19cases() {
		bigIntEnumSwitchCases(19);
	}

	@Test
	public void bigIntEnumSwitch18cases() {
		bigIntEnumSwitchCases(18);
	}

	@Test
	public void bigIntEnumSwitch17cases() {
		bigIntEnumSwitchCases(17);
	}

	@Test
	public void bigIntEnumSwitch16cases() {
		bigIntEnumSwitchCases(16);
	}

	@Test
	public void bigIntEnumSwitch15cases() {
		bigIntEnumSwitchCases(15);
	}

	@Test
	public void bigIntEnumSwitch14cases() {
		bigIntEnumSwitchCases(14);
	}

	@Test
	public void bigIntEnumSwitch13cases() {
		bigIntEnumSwitchCases(13);
	}

	@Test
	public void bigIntEnumSwitch12cases() {
		bigIntEnumSwitchCases(12);
	}

	@Test
	public void bigIntEnumSwitch11cases() {
		bigIntEnumSwitchCases(11);
	}

	@Test
	public void bigIntEnumSwitch10cases() {
		bigIntEnumSwitchCases(10);
	}

	@Test
	public void bigIntEnumSwitch9cases() {
		bigIntEnumSwitchCases(9);
	}

	@Test
	public void bigIntEnumSwitch8cases() {
		bigIntEnumSwitchCases(8);
	}

	@Test
	public void bigIntEnumSwitch7cases() {
		bigIntEnumSwitchCases(7);
	}

	@Test
	public void bigIntEnumSwitch6cases() {
		bigIntEnumSwitchCases(6);
	}

	@Test
	public void bigIntEnumSwitch5cases() {
		bigIntEnumSwitchCases(5);
	}

	@Test
	public void bigIntEnumSwitch4cases() {
		bigIntEnumSwitchCases(4);
	}

	@Test
	public void bigIntEnumSwitch3cases() {
		bigIntEnumSwitchCases(3);
	}

	@Test
	public void bigIntEnumSwitch2cases() {
		bigIntEnumSwitchCases(2);
	}

	@Test
	public void bigIntEnumSwitch1cases() {
		bigIntEnumSwitchCases(1);
	}

	@Test
	public void bigIntEnumSwitch0cases() {
		bigIntEnumSwitchCases(0);
	}

	@Test
	public void middleIntEnumSwitch32cases() {
		middleIntEnumSwitchCases(32);
	}

	@Test
	public void middleIntEnumSwitch31cases() {
		middleIntEnumSwitchCases(31);
	}

	@Test
	public void middleIntEnumSwitch30cases() {
		middleIntEnumSwitchCases(30);
	}

	@Test
	public void middleIntEnumSwitch29cases() {
		middleIntEnumSwitchCases(29);
	}

	@Test
	public void middleIntEnumSwitch28cases() {
		middleIntEnumSwitchCases(28);
	}

	@Test
	public void middleIntEnumSwitch27cases() {
		middleIntEnumSwitchCases(27);
	}

	@Test
	public void middleIntEnumSwitch26cases() {
		middleIntEnumSwitchCases(26);
	}

	@Test
	public void middleIntEnumSwitch25cases() {
		middleIntEnumSwitchCases(25);
	}

	@Test
	public void middleIntEnumSwitch24cases() {
		middleIntEnumSwitchCases(24);
	}

	@Test
	public void middleIntEnumSwitch23cases() {
		middleIntEnumSwitchCases(23);
	}

	@Test
	public void middleIntEnumSwitch22cases() {
		middleIntEnumSwitchCases(22);
	}

	@Test
	public void middleIntEnumSwitch21cases() {
		middleIntEnumSwitchCases(21);
	}

	@Test
	public void middleIntEnumSwitch20cases() {
		middleIntEnumSwitchCases(20);
	}

	@Test
	public void middleIntEnumSwitch19cases() {
		middleIntEnumSwitchCases(19);
	}

	@Test
	public void middleIntEnumSwitch18cases() {
		middleIntEnumSwitchCases(18);
	}

	@Test
	public void middleIntEnumSwitch17cases() {
		middleIntEnumSwitchCases(17);
	}

	@Test
	public void middleIntEnumSwitch16cases() {
		middleIntEnumSwitchCases(16);
	}

	@Test
	public void middleIntEnumSwitch15cases() {
		middleIntEnumSwitchCases(15);
	}

	@Test
	public void middleIntEnumSwitch14cases() {
		middleIntEnumSwitchCases(14);
	}

	@Test
	public void middleIntEnumSwitch13cases() {
		middleIntEnumSwitchCases(13);
	}

	@Test
	public void middleIntEnumSwitch12cases() {
		middleIntEnumSwitchCases(12);
	}

	@Test
	public void middleIntEnumSwitch11cases() {
		middleIntEnumSwitchCases(11);
	}

	@Test
	public void middleIntEnumSwitch10cases() {
		middleIntEnumSwitchCases(10);
	}

	@Test
	public void middleIntEnumSwitch9cases() {
		middleIntEnumSwitchCases(9);
	}

	@Test
	public void middleIntEnumSwitch8cases() {
		middleIntEnumSwitchCases(8);
	}

	@Test
	public void middleIntEnumSwitch7cases() {
		middleIntEnumSwitchCases(7);
	}

	@Test
	public void middleIntEnumSwitch6cases() {
		middleIntEnumSwitchCases(6);
	}

	@Test
	public void middleIntEnumSwitch5cases() {
		middleIntEnumSwitchCases(5);
	}

	@Test
	public void middleIntEnumSwitch4cases() {
		middleIntEnumSwitchCases(4);
	}

	@Test
	public void middleIntEnumSwitch3cases() {
		middleIntEnumSwitchCases(3);
	}

	@Test
	public void middleIntEnumSwitch2cases() {
		middleIntEnumSwitchCases(2);
	}

	@Test
	public void middleIntEnumSwitch1cases() {
		middleIntEnumSwitchCases(1);
	}

	@Test
	public void middleIntEnumSwitch0cases() {
		middleIntEnumSwitchCases(0);
	}

	@Test
	public void smallIntEnumSwitch32cases() {
		smallIntEnumSwitchCases(32);
	}

	@Test
	public void smallIntEnumSwitch31cases() {
		smallIntEnumSwitchCases(31);
	}

	@Test
	public void smallIntEnumSwitch30cases() {
		smallIntEnumSwitchCases(30);
	}

	@Test
	public void smallIntEnumSwitch29cases() {
		smallIntEnumSwitchCases(29);
	}

	@Test
	public void smallIntEnumSwitch28cases() {
		smallIntEnumSwitchCases(28);
	}

	@Test
	public void smallIntEnumSwitch27cases() {
		smallIntEnumSwitchCases(27);
	}

	@Test
	public void smallIntEnumSwitch26cases() {
		smallIntEnumSwitchCases(26);
	}

	@Test
	public void smallIntEnumSwitch25cases() {
		smallIntEnumSwitchCases(25);
	}

	@Test
	public void smallIntEnumSwitch24cases() {
		smallIntEnumSwitchCases(24);
	}

	@Test
	public void smallIntEnumSwitch23cases() {
		smallIntEnumSwitchCases(23);
	}

	@Test
	public void smallIntEnumSwitch22cases() {
		smallIntEnumSwitchCases(22);
	}

	@Test
	public void smallIntEnumSwitch21cases() {
		smallIntEnumSwitchCases(21);
	}

	@Test
	public void smallIntEnumSwitch20cases() {
		smallIntEnumSwitchCases(20);
	}

	@Test
	public void smallIntEnumSwitch19cases() {
		smallIntEnumSwitchCases(19);
	}

	@Test
	public void smallIntEnumSwitch18cases() {
		smallIntEnumSwitchCases(18);
	}

	@Test
	public void smallIntEnumSwitch17cases() {
		smallIntEnumSwitchCases(17);
	}

	@Test
	public void smallIntEnumSwitch16cases() {
		smallIntEnumSwitchCases(16);
	}

	@Test
	public void smallIntEnumSwitch15cases() {
		smallIntEnumSwitchCases(15);
	}

	@Test
	public void smallIntEnumSwitch14cases() {
		smallIntEnumSwitchCases(14);
	}

	@Test
	public void smallIntEnumSwitch13cases() {
		smallIntEnumSwitchCases(13);
	}

	@Test
	public void smallIntEnumSwitch12cases() {
		smallIntEnumSwitchCases(12);
	}

	@Test
	public void smallIntEnumSwitch11cases() {
		smallIntEnumSwitchCases(11);
	}

	@Test
	public void smallIntEnumSwitch10cases() {
		smallIntEnumSwitchCases(10);
	}

	@Test
	public void smallIntEnumSwitch9cases() {
		smallIntEnumSwitchCases(9);
	}

	@Test
	public void smallIntEnumSwitch8cases() {
		smallIntEnumSwitchCases(8);
	}

	@Test
	public void smallIntEnumSwitch7cases() {
		smallIntEnumSwitchCases(7);
	}

	@Test
	public void smallIntEnumSwitch6cases() {
		smallIntEnumSwitchCases(6);
	}

	@Test
	public void smallIntEnumSwitch5cases() {
		smallIntEnumSwitchCases(5);
	}

	@Test
	public void smallIntEnumSwitch4cases() {
		smallIntEnumSwitchCases(4);
	}

	@Test
	public void smallIntEnumSwitch3cases() {
		smallIntEnumSwitchCases(3);
	}

	@Test
	public void smallIntEnumSwitch2cases() {
		smallIntEnumSwitchCases(2);
	}

	@Test
	public void smallIntEnumSwitch1cases() {
		smallIntEnumSwitchCases(1);
	}

	@Test
	public void smallIntEnumSwitch0cases() {
		smallIntEnumSwitchCases(0);
	}
}
