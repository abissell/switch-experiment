import java.text.ParseException;

interface MiddleEnumSwitcher extends EnumSwitcher {
	SwitcherType switcherType();
	long switchForCase(MiddleIntegerEnum intEnum) throws ParseException;
}
