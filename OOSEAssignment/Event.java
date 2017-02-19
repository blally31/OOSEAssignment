import java.util.HashMap;

public abstract class Event {
	//Class Fields
	public int year;
	public char type;

	public int getYear() {
		return year;
	}

	public char getType() {
		return type;
	}

	final void runEvent(HashMap<String, Property> map) {
		//Run decrease event
		if (type == '-') {
			decrease(map);
		}
		//Run increase event
		else if (type == '+') {
			increase(map);
		}
	}
	
	abstract void increase(HashMap<String, Property> map);
	abstract void decrease(HashMap<String, Property> map);
}