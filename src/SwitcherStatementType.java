enum SwitcherStatementType {
	INT_SWITCH(true),
	ARRAY(false),
	ENUM_SWITCH(true),
	STRING_SWITCH(true),
	IF_ELSE(false);

	private final boolean usesSwitchStatement;

	private SwitcherStatementType(boolean usesSwitchStatement) {
		this.usesSwitchStatement = usesSwitchStatement;
	}

	final boolean usesSwitchStatement() {
		return usesSwitchStatement;
	}
}
