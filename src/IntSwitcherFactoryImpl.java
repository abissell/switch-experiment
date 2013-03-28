import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("NumericOverflow")
final class IntSwitcherFactoryImpl implements IntSwitcherFactory {
	private static final Map<Integer, SwitcherType> SWITCHER_TYPES = new HashMap<>();
	private static final SwitcherStatementType SWITCHER_STATEMENT_TYPE = SwitcherStatementType.INT_SWITCH;
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

	private final IntDefaultHandler defaultHandler;

	IntSwitcherFactoryImpl(final boolean throwExceptionFromDefault) {
		if (throwExceptionFromDefault) {
			defaultHandler = new IntDefaultHandler() {
				@Override
				public final long handleDefault(final int caseInt) throws ParseException {
					throw new ParseException("Couldn't parse case " + caseInt, 0);
				}
			};
		} else {
			defaultHandler = new IntDefaultHandler() {
				@Override
				public final long handleDefault(final int caseInt) {
					return caseInt;
				}
			};
		}
	}

	private interface IntDefaultHandler {
		long handleDefault(int caseInt) throws ParseException;
	}

	public final IntSwitcher getNewSwitcher(final int numCases) {
		switch (numCases) {
			case 0:
				return new Case0Switcher(defaultHandler);
			case 1:
				return new Case1Switcher(defaultHandler);
			case 2:
				return new Case2Switcher(defaultHandler);
			case 3:
				return new Case3Switcher(defaultHandler);
			case 4:
				return new Case4Switcher(defaultHandler);
			case 5:
				return new Case5Switcher(defaultHandler);
			case 6:
				return new Case6Switcher(defaultHandler);
			case 7:
				return new Case7Switcher(defaultHandler);
			case 8:
				return new Case8Switcher(defaultHandler);
			case 9:
				return new Case9Switcher(defaultHandler);
			case 10:
				return new Case10Switcher(defaultHandler);
			case 11:
				return new Case11Switcher(defaultHandler);
			case 12:
				return new Case12Switcher(defaultHandler);
			case 13:
				return new Case13Switcher(defaultHandler);
			case 14:
				return new Case14Switcher(defaultHandler);
			case 15:
				return new Case15Switcher(defaultHandler);
			case 16:
				return new Case16Switcher(defaultHandler);
			case 17:
				return new Case17Switcher(defaultHandler);
			case 18:
				return new Case18Switcher(defaultHandler);
			case 19:
				return new Case19Switcher(defaultHandler);
			case 20:
				return new Case20Switcher(defaultHandler);
			case 21:
				return new Case21Switcher(defaultHandler);
			case 22:
				return new Case22Switcher(defaultHandler);
			case 23:
				return new Case23Switcher(defaultHandler);
			case 24:
				return new Case24Switcher(defaultHandler);
			case 25:
				return new Case25Switcher(defaultHandler);
			case 26:
				return new Case26Switcher(defaultHandler);
			case 27:
				return new Case27Switcher(defaultHandler);
			case 28:
				return new Case28Switcher(defaultHandler);
			case 29:
				return new Case29Switcher(defaultHandler);
			case 30:
				return new Case30Switcher(defaultHandler);
			case 31:
				return new Case31Switcher(defaultHandler);
			case 32:
				return new Case32Switcher(defaultHandler);
			default:
				throw new IllegalArgumentException("Couldn't build IntSwitcher for numCases=" + numCases);
		}
	}

	private static final class Case32Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(32);
		private final IntDefaultHandler defaultHandler;

		private Case32Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case32GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case32GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			case 19:
				return  1000000000000000000L * 10;
			case 20:
				return  1000000000000000000L * 100;
			case 21:
				return  1000000000000000000L * 1000;
			case 22:
				return  1000000000000000000L * 10000;
			case 23:
				return  1000000000000000000L * 100000;
			case 24:
				return  1000000000000000000L * 1000000;
			case 25:
				return  1000000000000000000L * 10000000;
			case 26:
				return  1000000000000000000L * 100000000;
			case 27:
				return  1000000000000000000L * 1000000000;
			case 28:
				return  1000000000000000000L * 10000000000L;
			case 29:
				return  1000000000000000000L * 100000000000L;
			case 30:
				return  1000000000000000000L * 1000000000000L;
			case 31:
				return  1000000000000000000L * 10000000000000L;
			default:
				return defaultHandler.handleDefault(power);
		}
	}

	private static final class Case31Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(31);
		private final IntDefaultHandler defaultHandler;

		private Case31Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case31GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case31GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			case 19:
				return 1000000000000000000L * 10;
			case 20:
				return 1000000000000000000L * 100;
			case 21:
				return 1000000000000000000L * 1000;
			case 22:
				return 1000000000000000000L * 10000;
			case 23:
				return 1000000000000000000L * 100000;
			case 24:
				return 1000000000000000000L * 1000000;
			case 25:
				return 1000000000000000000L * 10000000;
			case 26:
				return 1000000000000000000L * 100000000;
			case 27:
				return 1000000000000000000L * 1000000000;
			case 28:
				return 1000000000000000000L * 10000000000L;
			case 29:
				return 1000000000000000000L * 100000000000L;
			case 30:
				return 1000000000000000000L * 1000000000000L;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case30Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(30);
		private final IntDefaultHandler defaultHandler;

		private Case30Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case30GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case30GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			case 19:
				return 1000000000000000000L * 10;
			case 20:
				return 1000000000000000000L * 100;
			case 21:
				return 1000000000000000000L * 1000;
			case 22:
				return 1000000000000000000L * 10000;
			case 23:
				return 1000000000000000000L * 100000;
			case 24:
				return 1000000000000000000L * 1000000;
			case 25:
				return 1000000000000000000L * 10000000;
			case 26:
				return 1000000000000000000L * 100000000;
			case 27:
				return 1000000000000000000L * 1000000000;
			case 28:
				return 1000000000000000000L * 10000000000L;
			case 29:
				return 1000000000000000000L * 100000000000L;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case29Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(29);
		private final IntDefaultHandler defaultHandler;

		private Case29Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case29GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case29GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			case 19:
				return 1000000000000000000L * 10;
			case 20:
				return 1000000000000000000L * 100;
			case 21:
				return 1000000000000000000L * 1000;
			case 22:
				return 1000000000000000000L * 10000;
			case 23:
				return 1000000000000000000L * 100000;
			case 24:
				return 1000000000000000000L * 1000000;
			case 25:
				return 1000000000000000000L * 10000000;
			case 26:
				return 1000000000000000000L * 100000000;
			case 27:
				return 1000000000000000000L * 1000000000;
			case 28:
				return 1000000000000000000L * 10000000000L;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case28Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(28);
		private final IntDefaultHandler defaultHandler;

		private Case28Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case28GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case28GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			case 19:
				return 1000000000000000000L * 10;
			case 20:
				return 1000000000000000000L * 100;
			case 21:
				return 1000000000000000000L * 1000;
			case 22:
				return 1000000000000000000L * 10000;
			case 23:
				return 1000000000000000000L * 100000;
			case 24:
				return 1000000000000000000L * 1000000;
			case 25:
				return 1000000000000000000L * 10000000;
			case 26:
				return 1000000000000000000L * 100000000;
			case 27:
				return 1000000000000000000L * 1000000000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}

	private static final class Case27Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(27);
		private final IntDefaultHandler defaultHandler;

		private Case27Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case27GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case27GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			case 19:
				return 1000000000000000000L * 10;
			case 20:
				return 1000000000000000000L * 100;
			case 21:
				return 1000000000000000000L * 1000;
			case 22:
				return 1000000000000000000L * 10000;
			case 23:
				return 1000000000000000000L * 100000;
			case 24:
				return 1000000000000000000L * 1000000;
			case 25:
				return 1000000000000000000L * 10000000;
			case 26:
				return 1000000000000000000L * 100000000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case26Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(26);
		private final IntDefaultHandler defaultHandler;

		private Case26Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case26GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case26GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			case 19:
				return 1000000000000000000L * 10;
			case 20:
				return 1000000000000000000L * 100;
			case 21:
				return 1000000000000000000L * 1000;
			case 22:
				return 1000000000000000000L * 10000;
			case 23:
				return 1000000000000000000L * 100000;
			case 24:
				return 1000000000000000000L * 1000000;
			case 25:
				return 1000000000000000000L * 10000000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case25Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(25);
		private final IntDefaultHandler defaultHandler;

		private Case25Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case25GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case25GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			case 19:
				return 1000000000000000000L * 10;
			case 20:
				return 1000000000000000000L * 100;
			case 21:
				return 1000000000000000000L * 1000;
			case 22:
				return 1000000000000000000L * 10000;
			case 23:
				return 1000000000000000000L * 100000;
			case 24:
				return 1000000000000000000L * 1000000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case24Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(24);
		private final IntDefaultHandler defaultHandler;

		private Case24Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case24GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case24GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			case 19:
				return 1000000000000000000L * 10;
			case 20:
				return 1000000000000000000L * 100;
			case 21:
				return 1000000000000000000L * 1000;
			case 22:
				return 1000000000000000000L * 10000;
			case 23:
				return 1000000000000000000L * 100000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case23Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(23);
		private final IntDefaultHandler defaultHandler;

		private Case23Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case23GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case23GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			case 19:
				return 1000000000000000000L * 10;
			case 20:
				return 1000000000000000000L * 100;
			case 21:
				return 1000000000000000000L * 1000;
			case 22:
				return 1000000000000000000L * 10000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case22Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(22);
		private final IntDefaultHandler defaultHandler;

		private Case22Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case22GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case22GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			case 19:
				return 1000000000000000000L * 10;
			case 20:
				return 1000000000000000000L * 100;
			case 21:
				return 1000000000000000000L * 1000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case21Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(21);
		private final IntDefaultHandler defaultHandler;

		private Case21Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case21GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case21GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			case 19:
				return 1000000000000000000L * 10;
			case 20:
				return 1000000000000000000L * 100;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case20Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(20);
		private final IntDefaultHandler defaultHandler;

		private Case20Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case20GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case20GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			case 19:
				return 1000000000000000000L * 10;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case19Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(19);
		private final IntDefaultHandler defaultHandler;

		private Case19Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case19GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case19GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			case 18:
				return 1000000000000000000L;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case18Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(18);
		private final IntDefaultHandler defaultHandler;

		private Case18Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case18GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case18GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			case 17:
				return 100000000000000000L;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case17Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(17);
		private final IntDefaultHandler defaultHandler;

		private Case17Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case17GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case17GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			case 16:
				return 10000000000000000L;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case16Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(16);
		private final IntDefaultHandler defaultHandler;

		private Case16Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case16GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case16GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			case 15:
				return 1000000000000000L;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case15Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(15);
		private final IntDefaultHandler defaultHandler;

		private Case15Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case15GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case15GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			case 14:
				return 100000000000000L;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case14Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(14);
		private final IntDefaultHandler defaultHandler;

		private Case14Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case14GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case14GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			case 13:
				return 10000000000000L;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case13Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(13);
		private final IntDefaultHandler defaultHandler;

		private Case13Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case13GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case13GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			case 12:
				return 1000000000000L;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case12Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(12);
		private final IntDefaultHandler defaultHandler;

		private Case12Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case12GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case12GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			case 11:
				return 100000000000L;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case11Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(11);
		private final IntDefaultHandler defaultHandler;

		private Case11Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case11GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case11GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			case 10:
				return 10000000000L;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case10Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(10);
		private final IntDefaultHandler defaultHandler;

		private Case10Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case10GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case10GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			case 9:
				return 1000000000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case9Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(9);
		private final IntDefaultHandler defaultHandler;

		private Case9Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case9GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case9GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			case 8:
				return 100000000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case8Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(8);
		private final IntDefaultHandler defaultHandler;

		private Case8Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case8GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case8GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			case 7:
				return 10000000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case7Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(7);
		private final IntDefaultHandler defaultHandler;

		private Case7Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case7GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case7GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			case 6:
				return 1000000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case6Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(6);
		private final IntDefaultHandler defaultHandler;

		private Case6Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case6GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case6GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			case 5:
				return 100000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case5Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(5);
		private final IntDefaultHandler defaultHandler;

		private Case5Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case5GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case5GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			case 4:
				return 10000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case4Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(4);
		private final IntDefaultHandler defaultHandler;

		private Case4Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case4GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case4GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			case 3:
				return 1000;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case3Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(3);
		private final IntDefaultHandler defaultHandler;

		private Case3Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case3GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case3GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			case 2:
				return 100;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case2Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(2);
		private final IntDefaultHandler defaultHandler;

		private Case2Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case2GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case2GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			case 1:
				return 10;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case1Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(1);
		private final IntDefaultHandler defaultHandler;

		private Case1Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case1GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case1GetPowerOfTen(int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			case 0:
				return 1;
			default:
				return defaultHandler.handleDefault(power);
		}
	}


	private static final class Case0Switcher implements IntSwitcher {
		private static final SwitcherType SWITCHER_TYPE = SWITCHER_TYPES.get(0);
		private final IntDefaultHandler defaultHandler;

		private Case0Switcher(final IntDefaultHandler defaultHandler) {
			this.defaultHandler = defaultHandler;
		}

		public final SwitcherType switcherType() {
			return SWITCHER_TYPE;
		}

		public long switchForCase(final int intCase) throws ParseException {
			return case0GetPowerOfTen(intCase, defaultHandler);
		}
	}

	private static long case0GetPowerOfTen(@SuppressWarnings("UnusedParameters") int power, IntDefaultHandler defaultHandler) throws ParseException {
		switch (power)
		{
			default:
				return defaultHandler.handleDefault(power);
		}
	}
}
