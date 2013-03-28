import java.text.ParseException;

interface BigEnumSwitcher extends EnumSwitcher {
	SwitcherType switcherType();
	long switchForCase(BigIntegerEnum intEnum) throws ParseException;
}
