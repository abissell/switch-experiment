import java.text.ParseException;

interface IntSwitcher extends Switcher {
	SwitcherType switcherType();
	long switchForCase(int intCase) throws ParseException;
}
