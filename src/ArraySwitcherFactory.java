import java.util.HashMap;
import java.util.Map;

final class ArraySwitcherFactory implements SwitcherFactory {
	private static final Map<Integer, SwitcherType> SWITCHER_TYPES = new HashMap<>();
	private static final SwitcherStatementType SWITCHER_STATEMENT_TYPE = SwitcherStatementType.INT_SWITCH;
	private static final SwitcherContiguity SWITCHER_CONTIGUITY = SwitcherContiguity.CONTIGUOUS_ASCENDING;
	static {
		for (int i = 0; i < 32; i++) {
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

	ArraySwitcherFactory() {

	}

	public Switcher getNewSwitcher(final int numCases) {
		return new ArraySwitcher(numCases);
	}

	private static final class ArraySwitcher implements Switcher {
		private final SwitcherType switcherType;
		private final long[] lookupArray;

		private ArraySwitcher(final int numCases) {
			this.switcherType = SWITCHER_TYPES.get(numCases);
			this.lookupArray = new long[numCases];
			for (int i = 0; i < numCases; i++) {
				long arrayValue = 1L;
				if (i > 0) {
					for (int j = 1; j <= i; j++) {
						arrayValue *= 10L;
					}
				}

				lookupArray[i] = arrayValue;
			}
		}

		public final SwitcherType switcherType() {
			return switcherType;
		}

		public final long switchForCase(final int caseInt) {
			return lookupArray[caseInt];
		}
	}
}
