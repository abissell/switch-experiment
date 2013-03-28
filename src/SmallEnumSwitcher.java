import java.text.ParseException;

interface SmallEnumSwitcher extends EnumSwitcher {
	SwitcherType switcherType();
	long switchForCase(SmallIntegerEnum intEnum) throws ParseException;
}
