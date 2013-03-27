import java.text.ParseException;

interface Switcher {
	SwitcherType switcherType();
	long switchForCase(int intCase) throws ParseException;
}
