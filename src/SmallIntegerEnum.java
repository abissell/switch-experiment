enum SmallIntegerEnum implements IntegerEnum {
	ENUM_0,
	ENUM_1,
	ENUM_2,
	ENUM_3,
	ENUM_4,
	ENUM_5,
	ENUM_6,
	ENUM_7,
	ENUM_8,
	ENUM_9,
	ENUM_10;

	static final SmallIntegerEnum[] LOOKUP_ARRAY = new SmallIntegerEnum[SmallIntegerEnum.values().length];
	static {
		for (int i = 0; i < SmallIntegerEnum.values().length; ++i) {
			LOOKUP_ARRAY[i] = SmallIntegerEnum.values()[i];
		}
	}

	private SmallIntegerEnum() {

	}

	public static SmallIntegerEnum fromCode(final int code) {
		return LOOKUP_ARRAY[code];
	}
}
