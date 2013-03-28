interface EnumSwitcherFactory {
	BigEnumSwitcher getNewBigEnumSwitcher(int numCases);
	MiddleEnumSwitcher getNewMiddleEnumSwitcher(int numCases);
	SmallEnumSwitcher getNewSmallEnumSwitcher(int numCases);
}
