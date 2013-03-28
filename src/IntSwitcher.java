import java.text.ParseException;

interface IntSwitcher {
	SwitcherType switcherType();
	long switchForCase(int intCase) throws ParseException;
}
