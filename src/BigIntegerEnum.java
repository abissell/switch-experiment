enum BigIntegerEnum implements IntegerEnum {
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
	ENUM_19,
	ENUM_20,
	ENUM_21,
	ENUM_22,
	ENUM_23,
	ENUM_24,
	ENUM_25,
	ENUM_26,
	ENUM_27,
	ENUM_28,
	ENUM_29,
	ENUM_30,
	ENUM_31;

	static final BigIntegerEnum[] LOOKUP_ARRAY = new BigIntegerEnum[BigIntegerEnum.values().length];
	static {
		for (int i = 0; i < BigIntegerEnum.values().length; ++i) {
			LOOKUP_ARRAY[i] = BigIntegerEnum.values()[i];
		}
	}

	private BigIntegerEnum() {

	}

	public static BigIntegerEnum fromCode(final int code) {
		return LOOKUP_ARRAY[code];
	}
}
