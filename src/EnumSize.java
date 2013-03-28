enum EnumSize {
	BIG(31),
	MIDDLE(19),
	SMALL(10);

	private final int maxPower;
	private final int maxNumCases;

	private EnumSize(int maxPower) {
		this.maxPower = maxPower;
		this.maxNumCases = maxPower + 1;
	}

	public int maxPower() {
		return maxPower;
	}

	public int maxNumCases() {
		return maxNumCases;
	}
}
