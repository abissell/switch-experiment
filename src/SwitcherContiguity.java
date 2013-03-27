enum SwitcherContiguity {
	CONTIGUOUS_ASCENDING(true),
	CONTIGUOUS_DESCENDING(true),
	NON_CONTIGUOUS(false);

	private final boolean isContiguous;

	private SwitcherContiguity(boolean isContiguous) {
		this.isContiguous = isContiguous;
	}

	public final boolean isContiguous() {
		return isContiguous;
	}
}
