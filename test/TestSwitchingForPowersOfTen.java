import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TestSwitchingForPowersOfTen extends AbstractBenchmark {
	private static final int TESTS_PER_ITER = 10000;
	private static final int NUM_ITER = 1000;
	private static final int MAX_POWER = 10;
	private static final Random RANDOM_INT = new Random(System.currentTimeMillis());
	private static final int randomInt(final int n) {
		return RANDOM_INT.nextInt(n);
	}
//  	private static final AtomicPsuedoRandom RANDOM_INT = new AtomicPsuedoRandom((int) System.currentTimeMillis());
//	private static final int randomInt(final int n) {
//		return RANDOM_INT.nextInt(n) - 1;
//	}
	private static final Random RANDOM_LONG = new Random(System.currentTimeMillis());
	private static final int[] RANDOM_INTS = new int[TESTS_PER_ITER];
	private static final double[] RANDOM_DOUBLES = new double[TESTS_PER_ITER];
	private static final int MAX_NUM_CASES = 32;
	private static final long RESULT[] = new long[MAX_NUM_CASES + 1];
	static {
		for (int i = 0; i < MAX_NUM_CASES; i++)
			RESULT[i] = 0;
	}

	public TestSwitchingForPowersOfTen() {

	}

	@BeforeClass
	public static void setup() {
		fillRandomInts();
		fillRandomDoubles();
//		System.out.print("First 20 random ints: ");
//		for (int i = 0; i < 20; i++) {
//			if (i == 19)
//				System.out.println(RANDOM_INTS[i]);
//			else
//				System.out.print(RANDOM_INTS[i] + ", ");
//		}

//		System.out.print("First 20 random doubles: ");
//		for (int i = 0; i < 20; i++) {
//			if (i == 19)
//				System.out.println(RANDOM_DOUBLES[i]);
//			else
//				System.out.print(RANDOM_DOUBLES[i] + ", ");
//		}
//
//		System.out.println("Starting tests.");
	}

	private static void fillRandomInts() {
		for (int i = 0; i < TESTS_PER_ITER; i++) {
			RANDOM_INTS[i] = randomInt(MAX_POWER);
		}
	}

	private static void fillRandomDoubles() {
		for (int i = 0; i < TESTS_PER_ITER; i++) {
			final long randomLong = RANDOM_LONG.nextLong();
			RANDOM_DOUBLES[i] = Double.longBitsToDouble(randomLong);
		}
	}

	@AfterClass
	public static void printResultToPreventOptimization() {
		System.out.println("Tests finished.");
		for (int i = 0; i <= MAX_NUM_CASES; i++) {
			System.out.print(i + "=" + RESULT[i] + ", ");
		}
		System.out.println();

		final long result = RESULT[MAX_NUM_CASES];
		for (int i = MAX_NUM_CASES; i >= MAX_POWER; i--) {
			Assert.assertEquals(result, RESULT[i]);
		}
	}

	// cf. JCIP 12.1.3 by Goetz et al
	private static final class AtomicPsuedoRandom {
		private final AtomicInteger seed;

		private AtomicPsuedoRandom(final int seed) {
			this.seed = new AtomicInteger(seed);
		}

		public final int nextInt(final int n) {
			while (true) {
				final int s = seed.get();
				final int nextSeed = xorShift(s);
				if (seed.compareAndSet(s, nextSeed)) {
					final int remainder = s % n;
					return remainder > 0 ? remainder : remainder + n;
				}
			}
		}
	}

	// cf. JCIP 12.1.3 by Goetz et al
	private static int xorShift(int y) {
		y ^= (y << 6);
		y ^= (y >>> 21);
		y ^= (y << 7);

		return y;
	}

	@Test
	public void test32CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 32;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case32RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case32RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			case 19:
				return val * 15;
			case 20:
				return val * 2;
			case 21:
				return val * 3;
			case 22:
				return val * 4;
			case 23:
				return val * 5;
			case 24:
				return val * 6;
			case 25:
				return val * 7;
			case 26:
				return val * 8;
			case 27:
				return val * 9;
			case 28:
				return val * 11;
			case 29:
				return val * 12;
			case 30:
				return val * 13;
			case 31:
				return val * 14;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test31CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 31;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case31RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case31RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			case 19:
				return val * 15;
			case 20:
				return val * 2;
			case 21:
				return val * 3;
			case 22:
				return val * 4;
			case 23:
				return val * 5;
			case 24:
				return val * 6;
			case 25:
				return val * 7;
			case 26:
				return val * 8;
			case 27:
				return val * 9;
			case 28:
				return val * 11;
			case 29:
				return val * 12;
			case 30:
				return val * 13;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test30CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 30;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case30RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case30RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			case 19:
				return val * 15;
			case 20:
				return val * 2;
			case 21:
				return val * 3;
			case 22:
				return val * 4;
			case 23:
				return val * 5;
			case 24:
				return val * 6;
			case 25:
				return val * 7;
			case 26:
				return val * 8;
			case 27:
				return val * 9;
			case 28:
				return val * 11;
			case 29:
				return val * 12;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test29CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 29;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case29RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case29RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			case 19:
				return val * 15;
			case 20:
				return val * 2;
			case 21:
				return val * 3;
			case 22:
				return val * 4;
			case 23:
				return val * 5;
			case 24:
				return val * 6;
			case 25:
				return val * 7;
			case 26:
				return val * 8;
			case 27:
				return val * 9;
			case 28:
				return val * 11;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test28CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 28;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case28RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case28RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			case 19:
				return val * 15;
			case 20:
				return val * 2;
			case 21:
				return val * 3;
			case 22:
				return val * 4;
			case 23:
				return val * 5;
			case 24:
				return val * 6;
			case 25:
				return val * 7;
			case 26:
				return val * 8;
			case 27:
				return val * 9;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test27CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 27;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case27RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static double case27RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			case 19:
				return val * 15;
			case 20:
				return val * 2;
			case 21:
				return val * 3;
			case 22:
				return val * 4;
			case 23:
				return val * 5;
			case 24:
				return val * 6;
			case 25:
				return val * 7;
			case 26:
				return val * 8;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test26CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 26;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case26RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case26RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			case 19:
				return val * 15;
			case 20:
				return val * 2;
			case 21:
				return val * 3;
			case 22:
				return val * 4;
			case 23:
				return val * 5;
			case 24:
				return val * 6;
			case 25:
				return val * 7;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test25CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 25;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case25RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case25RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			case 19:
				return val * 15;
			case 20:
				return val * 2;
			case 21:
				return val * 3;
			case 22:
				return val * 4;
			case 23:
				return val * 5;
			case 24:
				return val * 6;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test24CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 24;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case24RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case24RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			case 19:
				return val * 15;
			case 20:
				return val * 2;
			case 21:
				return val * 3;
			case 22:
				return val * 4;
			case 23:
				return val * 5;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test23CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 23;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case23RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case23RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			case 19:
				return val * 15;
			case 20:
				return val * 2;
			case 21:
				return val * 3;
			case 22:
				return val * 4;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test22CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 22;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case22RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case22RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			case 19:
				return val * 15;
			case 20:
				return val * 2;
			case 21:
				return val * 3;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test21CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 21;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case21RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case21RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			case 19:
				return val * 15;
			case 20:
				return val * 2;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test20CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 20;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case20RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case20RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			case 19:
				return val * 15;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test19CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 19;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case19RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case19RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			case 18:
				return val*1000000000000000000L;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test18CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 18;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case18RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case18RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			case 17:
				return val*100000000000000000L;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test17CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 17;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case17RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case17RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			case 16:
				return val*10000000000000000L;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test16CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 16;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case16RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case16RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			case 15:
				return val*1000000000000000L;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test15CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 15;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case15RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case15RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			case 14:
				return val*100000000000000L;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test14CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 14;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case14RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case14RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			case 13:
				return val*10000000000000L;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test13CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 13;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case13RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case13RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			case 12:
				return val*1000000000000L;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test12CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 12;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case12RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case12RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			case 11:
				return val*100000000000L;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test11CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 11;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case11RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case11RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			case 10:
				return val*10000000000L;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test10CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 10;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case10RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case10RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			case 9:
				return val*1000000000;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test9CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 9;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case9RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case9RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			case 8:
				return val*100000000;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test8CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 8;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case8RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case8RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			case 7:
				return val*10000000;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test7CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 7;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case7RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case7RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			case 6:
				return val*1000000;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test6CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 6;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case6RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case6RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			case 5:
				return val*100000;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test5CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 5;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case5RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case5RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			case 4:
				return val*10000;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test4CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 4;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case4RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case4RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			case 3:
				return val*1000;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test3CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 3;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case3RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case3RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			case 2:
				return val*100;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test2CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 2;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case2RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case2RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			case 1:
				return val*10;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test1CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 1;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case1RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case1RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			case 0:
				return val;
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}

	@Test
	public void test0CaseSwitchingRaiseToPowersOfTen() {
		final int numCases = 0;
		if (MAX_POWER > numCases)
			return;

		try
		{
			for (int i = 0; i < NUM_ITER; i++) {
				for (int j = 0; j < TESTS_PER_ITER; j++) {
					final double d = RANDOM_DOUBLES[j];
					final double raised = case0RaiseToPowerOfTen(d, RANDOM_INTS[j]);
					final long cast = (long) raised;
					RESULT[numCases] += cast;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double case0RaiseToPowerOfTen(double val, int power) throws ParseException {
		switch (power)
		{
			default:
				throw new ParseException("Unhandled power of ten: " + power, 0);
		}
	}
}
