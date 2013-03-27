//import java.text.ParseException;
//import java.util.HashMap;
//import java.util.Map;
//
//@SuppressWarnings("NumericOverflow")
//final class EnumSwitcherFactory implements SwitcherFactory {
//	enum EnumSize {
//		BIG,
//		MIDDLE,
//		SMALL
//	}
//
//	private static final Map<Integer, SwitcherType> SWITCHER_TYPES = new HashMap<>();
//	private static final SwitcherStatementType SWITCHER_STATEMENT_TYPE = SwitcherStatementType.ENUM_SWITCH;
//	private static final SwitcherContiguity SWITCHER_CONTIGUITY = SwitcherContiguity.CONTIGUOUS_ASCENDING;
//	static {
//		for (int i = 0; i <= 32; i++) {
//			final int finalizedIndex = i;
//			final SwitcherType newType = new SwitcherType() {
//				private final int numCases = finalizedIndex;
//
//				@Override
//				public final SwitcherStatementType type() {
//					return SWITCHER_STATEMENT_TYPE;
//				}
//
//				@Override
//				public SwitcherContiguity contiguity() {
//					return SWITCHER_CONTIGUITY;
//				}
//
//				@Override
//				public final int numCases() {
//					return numCases;
//				}
//			};
//			SWITCHER_TYPES.put(i, newType);
//		}
//	}
//
//	private final EnumDefaultHandler defaultHandler;
//	private final EnumSize enumSize;
//
//	EnumSwitcherFactory(final boolean throwExceptionFromDefault, final EnumSize enumSize) {
//		if (throwExceptionFromDefault) {
//			defaultHandler = new EnumDefaultHandler() {
//				@Override
//				public final long handleDefault(final BigIntegerEnum intEnum) throws ParseException {
//					throw new ParseException("Couldn't parse case " + intEnum, 0);
//				}
//			};
//		} else {
//			defaultHandler = new EnumDefaultHandler() {
//				@Override
//				public final long handleDefault(final BigIntegerEnum intEnum) {
//					return intEnum.ordinal();
//				}
//			};
//		}
//
//		this.enumSize = enumSize;
//	}
//
//	private interface EnumDefaultHandler {
//		long handleDefault(BigIntegerEnum intEnum) throws ParseException;
//	}
//
//	public final Switcher getNewSwitcher(final int numCases) {
//		switch (numCases) {
//			case 0:
//				return new Case0Switcher(defaultHandler);
//			case 1:
//				return new Case1Switcher(defaultHandler);
//			case 2:
//				return new Case2Switcher(defaultHandler);
//			case 3:
//				return new Case3Switcher(defaultHandler);
//			case 4:
//				return new Case4Switcher(defaultHandler);
//			case 5:
//				return new Case5Switcher(defaultHandler);
//			case 6:
//				return new Case6Switcher(defaultHandler);
//			case 7:
//				return new Case7Switcher(defaultHandler);
//			case 8:
//				return new Case8Switcher(defaultHandler);
//			case 9:
//				return new Case9Switcher(defaultHandler);
//			case 10:
//				return new Case10Switcher(defaultHandler);
//			case 11:
//				return new Case11Switcher(defaultHandler);
//			case 12:
//				return new Case12Switcher(defaultHandler);
//			case 13:
//				return new Case13Switcher(defaultHandler);
//			case 14:
//				return new Case14Switcher(defaultHandler);
//			case 15:
//				return new Case15Switcher(defaultHandler);
//			case 16:
//				return new Case16Switcher(defaultHandler);
//			case 17:
//				return new Case17Switcher(defaultHandler);
//			case 18:
//				return new Case18Switcher(defaultHandler);
//			case 19:
//				return new Case19Switcher(defaultHandler);
//			case 20:
//				return new Case20Switcher(defaultHandler);
//			case 21:
//				return new Case21Switcher(defaultHandler);
//			case 22:
//				return new Case22Switcher(defaultHandler);
//			case 23:
//				return new Case23Switcher(defaultHandler);
//			case 24:
//				return new Case24Switcher(defaultHandler);
//			case 25:
//				return new Case25Switcher(defaultHandler);
//			case 26:
//				return new Case26Switcher(defaultHandler);
//			case 27:
//				return new Case27Switcher(defaultHandler);
//			case 28:
//				return new Case28Switcher(defaultHandler);
//			case 29:
//				return new Case29Switcher(defaultHandler);
//			case 30:
//				return new Case30Switcher(defaultHandler);
//			case 31:
//				return new Case31Switcher(defaultHandler);
//			case 32:
//				return new Case32Switcher(defaultHandler);
//			default:
//				throw new IllegalArgumentException("Couldn't build Switcher for numCases=" + numCases);
//		}
//	}
//
//	private enum SmallIntegerEnum {
//		ENUM_0,
//		ENUM_1,
//		ENUM_2,
//		ENUM_3,
//		ENUM_4,
//		ENUM_5,
//		ENUM_6,
//		ENUM_7,
//		ENUM_8,
//		ENUM_9,
//		ENUM_10,
//		ENUM_11,
//		ENUM_12,
//		ENUM_13,
//		ENUM_14,
//		ENUM_15,
//		ENUM_16,
//	}
//
//	private enum MiddleIntegerEnum {
//		ENUM_0,
//		ENUM_1,
//		ENUM_2,
//		ENUM_3,
//		ENUM_4,
//		ENUM_5,
//		ENUM_6,
//		ENUM_7,
//		ENUM_8,
//		ENUM_9,
//		ENUM_10,
//		ENUM_11,
//		ENUM_12,
//		ENUM_13,
//		ENUM_14,
//		ENUM_15,
//		ENUM_16,
//	}
//
//	private enum BigIntegerEnum {
//		ENUM_0,
//		ENUM_1,
//		ENUM_2,
//		ENUM_3,
//		ENUM_4,
//		ENUM_5,
//		ENUM_6,
//		ENUM_7,
//		ENUM_8,
//		ENUM_9,
//		ENUM_10,
//		ENUM_11,
//		ENUM_12,
//		ENUM_13,
//		ENUM_14,
//		ENUM_15,
//		ENUM_16,
//		ENUM_17,
//		ENUM_18,
//		ENUM_19,
//		ENUM_20,
//		ENUM_21,
//		ENUM_22,
//		ENUM_23,
//		ENUM_24,
//		ENUM_25,
//		ENUM_26,
//		ENUM_27,
//		ENUM_28,
//		ENUM_29,
//		ENUM_30,
//		ENUM_31,
//		ENUM_32
//	}
//
//	private final /* inner */ class Case32Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(32);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_32;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case32Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case32GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case32GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			case 19:
//				return  1000000000000000000L * 10;
//			case 20:
//				return  1000000000000000000L * 100;
//			case 21:
//				return  1000000000000000000L * 1000;
//			case 22:
//				return  1000000000000000000L * 10000;
//			case 23:
//				return  1000000000000000000L * 100000;
//			case 24:
//				return  1000000000000000000L * 1000000;
//			case 25:
//				return  1000000000000000000L * 10000000;
//			case 26:
//				return  1000000000000000000L * 100000000;
//			case 27:
//				return  1000000000000000000L * 1000000000;
//			case 28:
//				return  1000000000000000000L * 10000000000L;
//			case 29:
//				return  1000000000000000000L * 100000000000L;
//			case 30:
//				return  1000000000000000000L * 1000000000000L;
//			case 31:
//				return  1000000000000000000L * 10000000000000L;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//	private final /* inner */ class Case31Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(31);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_31;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case31Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case31GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case31GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			case 19:
//				return 1000000000000000000L * 10;
//			case 20:
//				return 1000000000000000000L * 100;
//			case 21:
//				return 1000000000000000000L * 1000;
//			case 22:
//				return 1000000000000000000L * 10000;
//			case 23:
//				return 1000000000000000000L * 100000;
//			case 24:
//				return 1000000000000000000L * 1000000;
//			case 25:
//				return 1000000000000000000L * 10000000;
//			case 26:
//				return 1000000000000000000L * 100000000;
//			case 27:
//				return 1000000000000000000L * 1000000000;
//			case 28:
//				return 1000000000000000000L * 10000000000L;
//			case 29:
//				return 1000000000000000000L * 100000000000L;
//			case 30:
//				return 1000000000000000000L * 1000000000000L;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case30Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(30);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_30;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case30Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case30GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case30GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			case 19:
//				return 1000000000000000000L * 10;
//			case 20:
//				return 1000000000000000000L * 100;
//			case 21:
//				return 1000000000000000000L * 1000;
//			case 22:
//				return 1000000000000000000L * 10000;
//			case 23:
//				return 1000000000000000000L * 100000;
//			case 24:
//				return 1000000000000000000L * 1000000;
//			case 25:
//				return 1000000000000000000L * 10000000;
//			case 26:
//				return 1000000000000000000L * 100000000;
//			case 27:
//				return 1000000000000000000L * 1000000000;
//			case 28:
//				return 1000000000000000000L * 10000000000L;
//			case 29:
//				return 1000000000000000000L * 100000000000L;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case29Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(29);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_29;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case29Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case29GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case29GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			case 19:
//				return 1000000000000000000L * 10;
//			case 20:
//				return 1000000000000000000L * 100;
//			case 21:
//				return 1000000000000000000L * 1000;
//			case 22:
//				return 1000000000000000000L * 10000;
//			case 23:
//				return 1000000000000000000L * 100000;
//			case 24:
//				return 1000000000000000000L * 1000000;
//			case 25:
//				return 1000000000000000000L * 10000000;
//			case 26:
//				return 1000000000000000000L * 100000000;
//			case 27:
//				return 1000000000000000000L * 1000000000;
//			case 28:
//				return 1000000000000000000L * 10000000000L;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case28Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(28);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_28;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case28Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case28GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case28GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			case 19:
//				return 1000000000000000000L * 10;
//			case 20:
//				return 1000000000000000000L * 100;
//			case 21:
//				return 1000000000000000000L * 1000;
//			case 22:
//				return 1000000000000000000L * 10000;
//			case 23:
//				return 1000000000000000000L * 100000;
//			case 24:
//				return 1000000000000000000L * 1000000;
//			case 25:
//				return 1000000000000000000L * 10000000;
//			case 26:
//				return 1000000000000000000L * 100000000;
//			case 27:
//				return 1000000000000000000L * 1000000000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//	private final /* inner */ class Case27Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(27);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_27;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case27Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case27GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case27GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			case 19:
//				return 1000000000000000000L * 10;
//			case 20:
//				return 1000000000000000000L * 100;
//			case 21:
//				return 1000000000000000000L * 1000;
//			case 22:
//				return 1000000000000000000L * 10000;
//			case 23:
//				return 1000000000000000000L * 100000;
//			case 24:
//				return 1000000000000000000L * 1000000;
//			case 25:
//				return 1000000000000000000L * 10000000;
//			case 26:
//				return 1000000000000000000L * 100000000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case26Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(26);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_26;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case26Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case26GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case26GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			case 19:
//				return 1000000000000000000L * 10;
//			case 20:
//				return 1000000000000000000L * 100;
//			case 21:
//				return 1000000000000000000L * 1000;
//			case 22:
//				return 1000000000000000000L * 10000;
//			case 23:
//				return 1000000000000000000L * 100000;
//			case 24:
//				return 1000000000000000000L * 1000000;
//			case 25:
//				return 1000000000000000000L * 10000000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case25Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(25);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_25;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case25Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case25GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case25GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			case 19:
//				return 1000000000000000000L * 10;
//			case 20:
//				return 1000000000000000000L * 100;
//			case 21:
//				return 1000000000000000000L * 1000;
//			case 22:
//				return 1000000000000000000L * 10000;
//			case 23:
//				return 1000000000000000000L * 100000;
//			case 24:
//				return 1000000000000000000L * 1000000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case24Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(24);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_24;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case24Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case24GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case24GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			case 19:
//				return 1000000000000000000L * 10;
//			case 20:
//				return 1000000000000000000L * 100;
//			case 21:
//				return 1000000000000000000L * 1000;
//			case 22:
//				return 1000000000000000000L * 10000;
//			case 23:
//				return 1000000000000000000L * 100000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case23Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(23);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_23;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case23Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case23GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case23GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			case 19:
//				return 1000000000000000000L * 10;
//			case 20:
//				return 1000000000000000000L * 100;
//			case 21:
//				return 1000000000000000000L * 1000;
//			case 22:
//				return 1000000000000000000L * 10000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case22Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(22);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_22;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case22Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case22GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case22GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			case 19:
//				return 1000000000000000000L * 10;
//			case 20:
//				return 1000000000000000000L * 100;
//			case 21:
//				return 1000000000000000000L * 1000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case21Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(21);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_21;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case21Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case21GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case21GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			case 19:
//				return 1000000000000000000L * 10;
//			case 20:
//				return 1000000000000000000L * 100;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case20Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(20);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_20;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case20Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case20GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case20GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			case 19:
//				return 1000000000000000000L * 10;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case19Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(19);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_19;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case19Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case19GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case19GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			case 18:
//				return 1000000000000000000L;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case18Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(18);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_18;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case18Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case18GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case18GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			case 17:
//				return 100000000000000000L;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case17Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(17);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_17;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case17Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case17GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case17GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			case 16:
//				return 10000000000000000L;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case16Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(16);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_16;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case16Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case16GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case16GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			case 15:
//				return 1000000000000000L;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case15Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(15);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_15;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case15Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case15GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case15GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			case 14:
//				return 100000000000000L;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case14Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(14);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_14;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case14Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case14GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case14GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			case 13:
//				return 10000000000000L;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case13Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(13);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_13;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case13Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case13GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case13GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			case 12:
//				return 1000000000000L;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case12Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(12);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_12;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case12Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case12GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case12GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			case 11:
//				return 100000000000L;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case11Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(11);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_11;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case11Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case11GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case11GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			case 10:
//				return 10000000000L;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case10Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(10);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_10;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case10Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case10GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case10GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			case 9:
//				return 1000000000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case9Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(9);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_9;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case9Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case9GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case9GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			case 8:
//				return 100000000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case8Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(8);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_8;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case8Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case8GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case8GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			case 7:
//				return 10000000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case7Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(7);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_7;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case7Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case7GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case7GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			case 6:
//				return 1000000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case6Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(6);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_6;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case6Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case6GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case6GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			case 5:
//				return 100000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case5Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(5);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_5;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case5Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case5GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case5GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			case 4:
//				return 10000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case4Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(4);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_4;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case4Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case4GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case4GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			case 3:
//				return 1000;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case3Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(3);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_3;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case3Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case3GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case3GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			case 2:
//				return 100;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case2Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(2);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_2;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case2Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case2GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case2GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			case 1:
//				return 10;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case1Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(1);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_1;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case1Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case1GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case1GetPowerOfTen(int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			case 0:
//				return 1;
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//
//
//	private final /* inner */ class Case0Switcher implements Switcher {
//		private final SwitcherType switcherType = SWITCHER_TYPES.get(0);
//		private final BigIntegerEnum bigIntEnum = BigIntegerEnum.ENUM_0;
//		private final EnumDefaultHandler defaultHandler;
//
//		private Case0Switcher(final EnumDefaultHandler defaultHandler) {
//			this.defaultHandler = defaultHandler;
//		}
//
//		public final SwitcherType switcherType() {
//			return switcherType;
//		}
//
//		public long switchForCase(final int intCase) throws ParseException {
//			return case0GetPowerOfTen(intCase, defaultHandler);
//		}
//	}
//
//	private static long case0GetPowerOfTen(@SuppressWarnings("UnusedParameters") int power, EnumDefaultHandler defaultHandler) throws ParseException {
//		switch (power)
//		{
//			default:
//				return defaultHandler.handleDefault(power);
//		}
//	}
//}
