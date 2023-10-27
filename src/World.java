
public class World {
	// Builds the game world.
	// Returns the room the player starts in.
	public static Room buildWorld() {
		Room TreeRoom = new Room("treeroom", "You are in the Tree Room, a large room inside an even larger tree. " + "There is a pirate ship floating in the sky above. " + "There is a large yard through the portal to the north");
		Room PirateShip = new Room("pirateship", "You are in a pirate shit in the sky. " + "Below you is a large room inside the tree.");
		Room OutsideTree = new Room("outside", "You are outside the tree. " + "To the north the is a portal that leads to a throne room of a castle. " + "To the east is a Classroom. " + "To the west is a Barn. ");
		Room ThroneRoom = new Room("throneroom", "You are in a castle's throne room. " + "To the South is the large yard");
		Room Barn= new Room("barn", "You are in a barn. " + "There is a portal to the east that leads to the large yard. ");
		Room Classroom= new Room("classroom", "You are in classroom. " + "There is a portal to the west that leads to the large yard. ");
	
		TreeRoom.addExit(PirateShip, 'u');
		TreeRoom.addExit(OutsideTree, 'n');
		OutsideTree.addExit(TreeRoom,  's');
		PirateShip.addExit(TreeRoom, 'd');
		OutsideTree.addExit(ThroneRoom, 'n');
		ThroneRoom.addExit(OutsideTree, 's');
		OutsideTree.addExit(Barn, 'w');
		Barn.addExit(OutsideTree, 'e');
		OutsideTree.addExit(Classroom, 'e');
		Classroom.addExit(OutsideTree, 'w');
		ThroneRoom.setLocked(true);
		
		
		Item egg = new Item("egg");
		Barn.addItem(egg);
		Item skull = new Item("skull");
		PirateShip.addItem(skull);
		Item sword = new Item("sword");
		ThroneRoom.addItem(sword);
		sword.setDesc("A long broadsword, sitting against the Throne");
		Item wand = new Wand();
		Classroom.addItem(wand);
		wand.setDesc("the wand glows with an eerie light");
		Item chain = new Chain();
		Barn.addItem(chain);
		chain.setDesc("Large steel chain hanging from the ceiling of the barn");
		Item shower = new Shower();
		TreeRoom.addItem(shower);
		shower.setDesc("Traditional shower, can help you stay clean");
		
		
		Item chest = new Item("chest");
		chest.setDesc("Large, heavy treasure chest");
		PirateShip.addItem(chest);
		Item key = new Wand();
		key.setDesc("It's an ornate key.");
		ThroneRoom.addItem(key);
		
		
		return TreeRoom;
	}
}
