import java.util.HashMap;

public class Room {
	
	private String description;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private boolean locked; //is the room locked?
	private String name;
	
	private HashMap<String, Item> roomItems;
	
	
	public Room(String n, String desc) {
		name = n;
		description = desc;
		roomItems = new HashMap<String, Item>();
		locked = false;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean b) {
		locked = b;
	}
	
	public String getName() {
		return name;
	}
	
	public Item getItem(String name) {
		return roomItems.get(name);
	}
	
	public String getDesc() {
		return description;
	}
	
	public void addItem(Item i) {
		roomItems.put(i.getName(), i);
	}
	
	public boolean hasItem(String name) {
		return roomItems.containsKey(name);
	}
	
	public Item removeItem(String name) {
		Item it = roomItems.get(name);
		roomItems.remove(name);
		return it;
	}
	
	public Room getExit(char playerCommand) {
		if(playerCommand == 'e') {
			return east; 
		} else if(playerCommand == 'w') {
			return west;
		} else if(playerCommand == 'n') {
			return north;
		} else if(playerCommand == 's') {
			return south;
		} else if(playerCommand == 'u') {
			return up;
		} else if(playerCommand == 'd') {
			return down;
		} else
			return null;
	}
	
	public void addExit(Room R, char playerCommand) {
		if(playerCommand == 'e') {
			east = R;
		} else if( playerCommand == 'w') {
			west = R;
		} else if(playerCommand == 'n') {
			north = R;
		} else if(playerCommand == 's') {
			south = R;
		} else if(playerCommand == 'u') {
			up = R;
		} else if(playerCommand == 'd') {
			down = R;
		}
	}
	
	public String toString() {
		return description;
	}
}
