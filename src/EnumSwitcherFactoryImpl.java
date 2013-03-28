import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("NumericOverflow")
final class EnumSwitcherFactoryImpl implements EnumSwitcherFactory {

	private static final Map<Integer, SwitcherType> SWITCHER_TYPES = new HashMap<>();
	private static final SwitcherStatementType SWITCHER_STATEMENT_TYPE = SwitcherStatementType.ENUM_SWITCH;
	private static final SwitcherContiguity SWITCHER_CONTIGUITY = SwitcherContiguity.CONTIGUOUS_ASCENDING;
	static {
		for (int i = 0; i <= 32; i++) {
			final int finalizedIndex = i;
			final SwitcherType newType = new SwitcherType() {
				private final int numCases = finalizedIndex;

				@Override
				public final SwitcherStatementType type() {
					return SWITCHER_STATEMENT_TYPE;
				}

				@Override
				public SwitcherContiguity contiguity() {
					return SWITCHER_CONTIGUITY;
				}

				@Override
				public final int numCases() {
					return numCases;
				}
			};
			SWITCHER_TYPES.put(i, newType);
		}
	}

	private BigEnumDefaultHandler bigDefaultHandler;
	private MiddleEnumDefaultHandler middleDefaultHandler;
	private SmallEnumDefaultHandler smallDefaultHandler;

	EnumSwitcherFactoryImpl(final boolean throwExceptionFromDefault) {
		if (throwExceptionFromDefault) {
			bigDefaultHandler = new BigEnumDefaultHandler() {
				@Override
				public final long handleDefault(final BigIntegerEnum intEnum) throws ParseException {
					throw new ParseException("Couldn't parse case " + intEnum, 0);
				}
			};

			middleDefaultHandler = new MiddleEnumDefaultHandler() {
				@Override
				public final long handleDefault(final MiddleIntegerEnum intEnum) throws ParseException {
					throw new ParseException("Couldn't parse case " + intEnum, 0);
				}
			};

			smallDefaultHandler = new SmallEnumDefaultHandler() {
				@Override
				public final long handleDefault(final SmallIntegerEnum intEnum) {
					return intEnum.ordinal();
				}
			};
		} else {
			bigDefaultHandler = new BigEnumDefaultHandler() {
				@Override
				public final long handleDefault(final BigIntegerEnum intEnum) {
					return intEnum.ordinal();
				}
			};

			middleDefaultHandler = new MiddleEnumDefaultHandler() {
				@Override
				public final long handleDefault(final MiddleIntegerEnum intEnum) {
					return intEnum.ordinal();
				}
			};

			smallDefaultHandler = new SmallEnumDefaultHandler() {
				@Override
				public final long handleDefault(final SmallIntegerEnum intEnum) {
					return intEnum.ordinal();
				}
			};
		}
	}

	private interface BigEnumDefaultHandler {
		long handleDefault(BigIntegerEnum intEnum) throws ParseException;
	}

	private interface MiddleEnumDefaultHandler {
		long handleDefault(MiddleIntegerEnum intEnum) throws ParseException;
	}

	private interface SmallEnumDefaultHandler {
		long handleDefault(SmallIntegerEnum intEnum) throws ParseException;
	}

	public final BigEnumSwitcher getNewBigEnumSwitcher(final int numCases) {
		switch (numCases) {
			case 0:
				return new BigCase0Switcher(bigDefaultHandler);
			case 1:
				return new BigCase1Switcher(bigDefaultHandler);
			case 2:
				return new BigCase2Switcher(bigDefaultHandler);
			case 3:
				return new BigCase3Switcher(bigDefaultHandler);
			case 4:
				return new BigCase4Switcher(bigDefaultHandler);
			case 5:
				return new BigCase5Switcher(bigDefaultHandler);
			case 6:
				return new BigCase6Switcher(bigDefaultHandler);
			case 7:
				return new BigCase7Switcher(bigDefaultHandler);
			case 8:
				return new BigCase8Switcher(bigDefaultHandler);
			case 9:
				return new BigCase9Switcher(bigDefaultHandler);
			case 10:
				return new BigCase10Switcher(bigDefaultHandler);
			case 11:
				return new BigCase11Switcher(bigDefaultHandler);
			case 12:
				return new BigCase12Switcher(bigDefaultHandler);
			case 13:
				return new BigCase13Switcher(bigDefaultHandler);
			case 14:
				return new BigCase14Switcher(bigDefaultHandler);
			case 15:
				return new BigCase15Switcher(bigDefaultHandler);
			case 16:
				return new BigCase16Switcher(bigDefaultHandler);
			case 17:
				return new BigCase17Switcher(bigDefaultHandler);
			case 18:
				return new BigCase18Switcher(bigDefaultHandler);
			case 19:
				return new BigCase19Switcher(bigDefaultHandler);
			case 20:
				return new BigCase20Switcher(bigDefaultHandler);
			case 21:
				return new BigCase21Switcher(bigDefaultHandler);
			case 22:
				return new BigCase22Switcher(bigDefaultHandler);
			case 23:
				return new BigCase23Switcher(bigDefaultHandler);
			case 24:
				return new BigCase24Switcher(bigDefaultHandler);
			case 25:
				return new BigCase25Switcher(bigDefaultHandler);
			case 26:
				return new BigCase26Switcher(bigDefaultHandler);
			case 27:
				return new BigCase27Switcher(bigDefaultHandler);
			case 28:
				return new BigCase28Switcher(bigDefaultHandler);
			case 29:
				return new BigCase29Switcher(bigDefaultHandler);
			case 30:
				return new BigCase30Switcher(bigDefaultHandler);
			case 31:
				return new BigCase31Switcher(bigDefaultHandler);
			case 32:
				return new BigCase32Switcher(bigDefaultHandler);
			default:
				throw new IllegalArgumentException("Couldn't build IntSwitcher for numCases=" + numCases);
		}
	}

	public final MiddleEnumSwitcher getNewMiddleEnumSwitcher(final int numCases) {
		switch (numCases) {
			case 0:
				return new MiddleCase0Switcher(middleDefaultHandler);
			case 1:
				return new MiddleCase1Switcher(middleDefaultHandler);
			case 2:
				return new MiddleCase2Switcher(middleDefaultHandler);
			case 3:
				return new MiddleCase3Switcher(middleDefaultHandler);
			case 4:
				return new MiddleCase4Switcher(middleDefaultHandler);
			case 5:
				return new MiddleCase5Switcher(middleDefaultHandler);
			case 6:
				return new MiddleCase6Switcher(middleDefaultHandler);
			case 7:
				return new MiddleCase7Switcher(middleDefaultHandler);
			case 8:
				return new MiddleCase8Switcher(middleDefaultHandler);
			case 9:
				return new MiddleCase9Switcher(middleDefaultHandler);
			case 10:
				return new MiddleCase10Switcher(middleDefaultHandler);
			case 11:
				return new MiddleCase11Switcher(middleDefaultHandler);
			case 12:
				return new MiddleCase12Switcher(middleDefaultHandler);
			case 13:
				return new MiddleCase13Switcher(middleDefaultHandler);
			case 14:
				return new MiddleCase14Switcher(middleDefaultHandler);
			case 15:
				return new MiddleCase15Switcher(middleDefaultHandler);
			case 16:
				return new MiddleCase16Switcher(middleDefaultHandler);
			case 17:
				return new MiddleCase17Switcher(middleDefaultHandler);
			case 18:
				return new MiddleCase18Switcher(middleDefaultHandler);
			case 19:
				return new MiddleCase19Switcher(middleDefaultHandler);
			case 20:
				return new MiddleCase20Switcher(middleDefaultHandler);
			default:
				throw new IllegalArgumentException("Couldn't build IntSwitcher for numCases=" + numCases);
		}
	}

	public final SmallEnumSwitcher getNewSmallEnumSwitcher(final int numCases) {
		switch (numCases) {
			case 0:
				return new SmallCase0Switcher(smallDefaultHandler);
			case 1:
				return new SmallCase1Switcher(smallDefaultHandler);
			case 2:
				return new SmallCase2Switcher(smallDefaultHandler);
			case 3:
				return new SmallCase3Switcher(smallDefaultHandler);
			case 4:
				return new SmallCase4Switcher(smallDefaultHandler);
			case 5:
				return new SmallCase5Switcher(smallDefaultHandler);
			case 6:
				return new SmallCase6Switcher(smallDefaultHandler);
			case 7:
				return new SmallCase7Switcher(smallDefaultHandler);
			case 8:
				return new SmallCase8Switcher(smallDefaultHandler);
			case 9:
				return new SmallCase9Switcher(smallDefaultHandler);
			case 10:
				return new SmallCase10Switcher(smallDefaultHandler);
			case 11:
				return new SmallCase11Switcher(smallDefaultHandler);
			default:
				throw new IllegalArgumentException("Couldn't build IntSwitcher for numCases=" + numCases);
		}
	}

	private static final class BigCase32Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(32);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase32Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase32GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase32GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return  1000000000000000000L * 10;
			case ENUM_20:
				return  1000000000000000000L * 100;
			case ENUM_21:
				return  1000000000000000000L * 1000;
			case ENUM_22:
				return  1000000000000000000L * 10000;
			case ENUM_23:
				return  1000000000000000000L * 100000;
			case ENUM_24:
				return  1000000000000000000L * 1000000;
			case ENUM_25:
				return  1000000000000000000L * 10000000;
			case ENUM_26:
				return  1000000000000000000L * 100000000;
			case ENUM_27:
				return  1000000000000000000L * 1000000000;
			case ENUM_28:
				return  1000000000000000000L * 10000000000L;
			case ENUM_29:
				return  1000000000000000000L * 100000000000L;
			case ENUM_30:
				return  1000000000000000000L * 1000000000000L;
			case ENUM_31:
				return  1000000000000000000L * 10000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}

	private static final class BigCase31Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(31);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase31Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase31GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase31GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return 1000000000000000000L * 10;
			case ENUM_20:
				return 1000000000000000000L * 100;
			case ENUM_21:
				return 1000000000000000000L * 1000;
			case ENUM_22:
				return 1000000000000000000L * 10000;
			case ENUM_23:
				return 1000000000000000000L * 100000;
			case ENUM_24:
				return 1000000000000000000L * 1000000;
			case ENUM_25:
				return 1000000000000000000L * 10000000;
			case ENUM_26:
				return 1000000000000000000L * 100000000;
			case ENUM_27:
				return 1000000000000000000L * 1000000000;
			case ENUM_28:
				return 1000000000000000000L * 10000000000L;
			case ENUM_29:
				return 1000000000000000000L * 100000000000L;
			case ENUM_30:
				return 1000000000000000000L * 1000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase30Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(30);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase30Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase30GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase30GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return 1000000000000000000L * 10;
			case ENUM_20:
				return 1000000000000000000L * 100;
			case ENUM_21:
				return 1000000000000000000L * 1000;
			case ENUM_22:
				return 1000000000000000000L * 10000;
			case ENUM_23:
				return 1000000000000000000L * 100000;
			case ENUM_24:
				return 1000000000000000000L * 1000000;
			case ENUM_25:
				return 1000000000000000000L * 10000000;
			case ENUM_26:
				return 1000000000000000000L * 100000000;
			case ENUM_27:
				return 1000000000000000000L * 1000000000;
			case ENUM_28:
				return 1000000000000000000L * 10000000000L;
			case ENUM_29:
				return 1000000000000000000L * 100000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase29Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(29);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase29Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase29GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase29GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return 1000000000000000000L * 10;
			case ENUM_20:
				return 1000000000000000000L * 100;
			case ENUM_21:
				return 1000000000000000000L * 1000;
			case ENUM_22:
				return 1000000000000000000L * 10000;
			case ENUM_23:
				return 1000000000000000000L * 100000;
			case ENUM_24:
				return 1000000000000000000L * 1000000;
			case ENUM_25:
				return 1000000000000000000L * 10000000;
			case ENUM_26:
				return 1000000000000000000L * 100000000;
			case ENUM_27:
				return 1000000000000000000L * 1000000000;
			case ENUM_28:
				return 1000000000000000000L * 10000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase28Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(28);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase28Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase28GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase28GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return 1000000000000000000L * 10;
			case ENUM_20:
				return 1000000000000000000L * 100;
			case ENUM_21:
				return 1000000000000000000L * 1000;
			case ENUM_22:
				return 1000000000000000000L * 10000;
			case ENUM_23:
				return 1000000000000000000L * 100000;
			case ENUM_24:
				return 1000000000000000000L * 1000000;
			case ENUM_25:
				return 1000000000000000000L * 10000000;
			case ENUM_26:
				return 1000000000000000000L * 100000000;
			case ENUM_27:
				return 1000000000000000000L * 1000000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}

	private static final class BigCase27Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(27);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase27Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase27GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase27GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return 1000000000000000000L * 10;
			case ENUM_20:
				return 1000000000000000000L * 100;
			case ENUM_21:
				return 1000000000000000000L * 1000;
			case ENUM_22:
				return 1000000000000000000L * 10000;
			case ENUM_23:
				return 1000000000000000000L * 100000;
			case ENUM_24:
				return 1000000000000000000L * 1000000;
			case ENUM_25:
				return 1000000000000000000L * 10000000;
			case ENUM_26:
				return 1000000000000000000L * 100000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase26Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(26);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase26Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase26GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase26GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return 1000000000000000000L * 10;
			case ENUM_20:
				return 1000000000000000000L * 100;
			case ENUM_21:
				return 1000000000000000000L * 1000;
			case ENUM_22:
				return 1000000000000000000L * 10000;
			case ENUM_23:
				return 1000000000000000000L * 100000;
			case ENUM_24:
				return 1000000000000000000L * 1000000;
			case ENUM_25:
				return 1000000000000000000L * 10000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase25Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(25);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase25Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase25GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase25GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return 1000000000000000000L * 10;
			case ENUM_20:
				return 1000000000000000000L * 100;
			case ENUM_21:
				return 1000000000000000000L * 1000;
			case ENUM_22:
				return 1000000000000000000L * 10000;
			case ENUM_23:
				return 1000000000000000000L * 100000;
			case ENUM_24:
				return 1000000000000000000L * 1000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase24Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(24);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase24Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase24GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase24GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return 1000000000000000000L * 10;
			case ENUM_20:
				return 1000000000000000000L * 100;
			case ENUM_21:
				return 1000000000000000000L * 1000;
			case ENUM_22:
				return 1000000000000000000L * 10000;
			case ENUM_23:
				return 1000000000000000000L * 100000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase23Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(23);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase23Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase23GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase23GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return 1000000000000000000L * 10;
			case ENUM_20:
				return 1000000000000000000L * 100;
			case ENUM_21:
				return 1000000000000000000L * 1000;
			case ENUM_22:
				return 1000000000000000000L * 10000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase22Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(22);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase22Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase22GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase22GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return 1000000000000000000L * 10;
			case ENUM_20:
				return 1000000000000000000L * 100;
			case ENUM_21:
				return 1000000000000000000L * 1000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase21Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(21);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase21Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase21GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase21GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return 1000000000000000000L * 10;
			case ENUM_20:
				return 1000000000000000000L * 100;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase20Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(20);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase20Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase20GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase20GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return 1000000000000000000L * 10;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase19Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(19);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase19Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase19GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase19GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase18Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(18);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase18Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase18GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase18GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase17Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(17);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase17Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase17GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase17GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase16Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(16);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase16Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase16GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase16GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase15Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(15);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase15Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase15GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase15GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase14Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(14);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase14Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase14GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase14GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase13Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(13);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase13Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase13GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase13GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase12Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(12);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase12Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase12GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase12GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase11Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(11);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase11Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase11GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase11GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase10Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(10);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase10Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase10GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase10GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase9Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(9);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase9Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase9GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase9GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase8Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(8);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase8Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase8GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase8GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase7Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(7);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase7Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase7GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase7GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase6Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(6);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase6Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase6GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase6GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase5Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(5);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase5Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase5GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase5GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase4Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(4);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase4Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase4GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase4GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase3Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(3);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase3Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase3GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase3GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase2Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(2);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase2Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase2GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase2GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase1Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(1);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase1Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase1GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase1GetPowerOfTen(BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class BigCase0Switcher implements BigEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(0);
		private final BigEnumDefaultHandler defaultHandler;

		private BigCase0Switcher(final BigEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final BigIntegerEnum intEnum) throws ParseException {
			return bigCase0GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long bigCase0GetPowerOfTen(@SuppressWarnings("UnusedParameters") BigIntegerEnum intEnum, BigEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}

	
	
	
	
	
	 // TODO: ENUM BREAK
	
	
	
	


	private static final class MiddleCase20Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(20);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase20Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase20GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase20GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			case ENUM_19:
				return 1000000000000000000L * 10;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase19Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(19);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase19Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase19GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase19GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			case ENUM_18:
				return 1000000000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase18Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(18);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase18Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase18GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase18GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			case ENUM_17:
				return 100000000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase17Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(17);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase17Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase17GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase17GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			case ENUM_16:
				return 10000000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase16Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(16);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase16Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase16GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase16GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			case ENUM_15:
				return 1000000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase15Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(15);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase15Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase15GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase15GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			case ENUM_14:
				return 100000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase14Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(14);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase14Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase14GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase14GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			case ENUM_13:
				return 10000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase13Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(13);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase13Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase13GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase13GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			case ENUM_12:
				return 1000000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase12Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(12);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase12Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase12GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase12GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			case ENUM_11:
				return 100000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase11Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(11);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase11Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase11GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase11GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase10Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(10);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase10Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase10GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase10GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase9Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(9);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase9Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase9GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase9GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase8Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(8);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase8Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase8GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase8GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase7Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(7);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase7Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase7GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase7GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase6Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(6);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase6Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase6GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase6GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase5Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(5);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase5Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase5GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase5GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase4Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(4);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase4Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase4GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase4GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase3Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(3);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase3Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase3GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase3GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase2Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(2);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase2Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase2GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase2GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase1Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(1);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase1Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase1GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase1GetPowerOfTen(MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class MiddleCase0Switcher implements MiddleEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(0);
		private final MiddleEnumDefaultHandler defaultHandler;

		private MiddleCase0Switcher(final MiddleEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final MiddleIntegerEnum intEnum) throws ParseException {
			return middleCase0GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long middleCase0GetPowerOfTen(@SuppressWarnings("UnusedParameters") MiddleIntegerEnum intEnum, MiddleEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


















	  // TODO: ENUM BREAK

















	private static final class SmallCase11Switcher implements SmallEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(11);
		private final SmallEnumDefaultHandler defaultHandler;

		private SmallCase11Switcher(final SmallEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final SmallIntegerEnum intEnum) throws ParseException {
			return smallCase11GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long smallCase11GetPowerOfTen(SmallIntegerEnum intEnum, SmallEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			case ENUM_10:
				return 10000000000L;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class SmallCase10Switcher implements SmallEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(10);
		private final SmallEnumDefaultHandler defaultHandler;

		private SmallCase10Switcher(final SmallEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final SmallIntegerEnum intEnum) throws ParseException {
			return smallCase10GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long smallCase10GetPowerOfTen(SmallIntegerEnum intEnum, SmallEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			case ENUM_9:
				return 1000000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class SmallCase9Switcher implements SmallEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(9);
		private final SmallEnumDefaultHandler defaultHandler;

		private SmallCase9Switcher(final SmallEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final SmallIntegerEnum intEnum) throws ParseException {
			return smallCase9GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long smallCase9GetPowerOfTen(SmallIntegerEnum intEnum, SmallEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			case ENUM_8:
				return 100000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class SmallCase8Switcher implements SmallEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(8);
		private final SmallEnumDefaultHandler defaultHandler;

		private SmallCase8Switcher(final SmallEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final SmallIntegerEnum intEnum) throws ParseException {
			return smallCase8GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long smallCase8GetPowerOfTen(SmallIntegerEnum intEnum, SmallEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			case ENUM_7:
				return 10000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class SmallCase7Switcher implements SmallEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(7);
		private final SmallEnumDefaultHandler defaultHandler;

		private SmallCase7Switcher(final SmallEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final SmallIntegerEnum intEnum) throws ParseException {
			return smallCase7GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long smallCase7GetPowerOfTen(SmallIntegerEnum intEnum, SmallEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			case ENUM_6:
				return 1000000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class SmallCase6Switcher implements SmallEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(6);
		private final SmallEnumDefaultHandler defaultHandler;

		private SmallCase6Switcher(final SmallEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final SmallIntegerEnum intEnum) throws ParseException {
			return smallCase6GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long smallCase6GetPowerOfTen(SmallIntegerEnum intEnum, SmallEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			case ENUM_5:
				return 100000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class SmallCase5Switcher implements SmallEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(5);
		private final SmallEnumDefaultHandler defaultHandler;

		private SmallCase5Switcher(final SmallEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final SmallIntegerEnum intEnum) throws ParseException {
			return smallCase5GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long smallCase5GetPowerOfTen(SmallIntegerEnum intEnum, SmallEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			case ENUM_4:
				return 10000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class SmallCase4Switcher implements SmallEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(4);
		private final SmallEnumDefaultHandler defaultHandler;

		private SmallCase4Switcher(final SmallEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final SmallIntegerEnum intEnum) throws ParseException {
			return smallCase4GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long smallCase4GetPowerOfTen(SmallIntegerEnum intEnum, SmallEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			case ENUM_3:
				return 1000;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class SmallCase3Switcher implements SmallEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(3);
		private final SmallEnumDefaultHandler defaultHandler;

		private SmallCase3Switcher(final SmallEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final SmallIntegerEnum intEnum) throws ParseException {
			return smallCase3GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long smallCase3GetPowerOfTen(SmallIntegerEnum intEnum, SmallEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			case ENUM_2:
				return 100;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class SmallCase2Switcher implements SmallEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(2);
		private final SmallEnumDefaultHandler defaultHandler;

		private SmallCase2Switcher(final SmallEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final SmallIntegerEnum intEnum) throws ParseException {
			return smallCase2GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long smallCase2GetPowerOfTen(SmallIntegerEnum intEnum, SmallEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			case ENUM_1:
				return 10;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class SmallCase1Switcher implements SmallEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(1);
		private final SmallEnumDefaultHandler defaultHandler;

		private SmallCase1Switcher(final SmallEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final SmallIntegerEnum intEnum) throws ParseException {
			return smallCase1GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long smallCase1GetPowerOfTen(SmallIntegerEnum intEnum, SmallEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			case ENUM_0:
				return 1;
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}


	private static final class SmallCase0Switcher implements SmallEnumSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(0);
		private final SmallEnumDefaultHandler defaultHandler;

		private SmallCase0Switcher(final SmallEnumDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final SmallIntegerEnum intEnum) throws ParseException {
			return smallCase0GetPowerOfTen(intEnum, defaultHandler);
		}
	}

	private static long smallCase0GetPowerOfTen(@SuppressWarnings("UnusedParameters") SmallIntegerEnum intEnum, SmallEnumDefaultHandler defaultHandler) throws ParseException {
		switch (intEnum)
		{
			default:
				return defaultHandler.handleDefault(intEnum);
		}
	}
}
