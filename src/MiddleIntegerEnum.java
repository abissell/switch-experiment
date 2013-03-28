enum MiddleIntegerEnum implements IntegerEnum {
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
	ENUM_10,
	ENUM_11,
	ENUM_12,
	ENUM_13,
	ENUM_14,
	ENUM_15,
	ENUM_16,
	ENUM_17,
	ENUM_18,
	ENUM_19;

	static final MiddleIntegerEnum[] LOOKUP_ARRAY = new MiddleIntegerEnum[MiddleIntegerEnum.values().length];
	static {
		for (int i = 0; i < MiddleIntegerEnum.values().length; ++i) {
			LOOKUP_ARRAY[i] = MiddleIntegerEnum.values()[i];
		}
	}

	private MiddleIntegerEnum() {

	}

	public static MiddleIntegerEnum fromCode(final int code) {
		return LOOKUP_ARRAY[code];
	}
}
