import java.util.HashMap;

public class World {
	// Builds the game world.
	// Returns the room the player starts in.
	
	public static HashMap<String, Room> rooms = new HashMap<String, Room>();
	
	public static Room buildWorld() {
		Room TreeRoom = new Room("treeroom");
		Room PirateShip = new Room("pirateship");
		Room OutsideTree = new Room("outsidetree");
		Room ThroneRoom = new Room("throneroom");
		Room Barn= new Room("barn");
		Room Classroom= new Room("classroom");
		Room Basement = new Room("basement");
		Room ShipDeck = new Room("shipdeck");
		Room Hallway = new Room("hallway");
		Room Office = new Room("office");
		Room Home = new Room("home");
	
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
		ThroneRoom.addExit(Basement, 'd');
		Basement.addExit(ThroneRoom, 'u');
		PirateShip.addExit(ShipDeck, 'n');
		Classroom.addExit(Hallway, 'e');
		ShipDeck.addExit(PirateShip, 's');
		Hallway.addExit(Classroom, 's');
		Hallway.addExit(Office, 'n');
		Office.addExit(Hallway, 's');
		OutsideTree.addExit(Home,  'u');
		ThroneRoom.setLocked(true);
		Basement.setLocked(true);
		Hallway.setLocked(true);
		Office.setLocked(true);
		Home.setLocked(true);
		
		
		NPC puppy = new Puppy();
		TreeRoom.addNPC(puppy);
		
		
		Item egg = new Item("egg");
		Barn.addItem(egg);
		egg.setDesc("An large egg covered in feathers");
		egg.setHeavy(true);
		Item skull = new Skull();
		PirateShip.addItem(skull);
		skull.setDesc("A human looking skull, covered in gold");
		Item sword = new Item("sword");
		ThroneRoom.addItem(sword);
		sword.setDesc("A long broadsword, sitting against the Throne");
		Item wand = new Wand();
		Classroom.addItem(wand);
		wand.setDesc("the wand glows with an eerie light");
		Item engraving = new Chain();
		OutsideTree.addItem(engraving);
		engraving.setDesc("Large circular engraving above the portal to the tree room");
		Item book = new Item("book");
		book.setDesc("A large book, as you flip through it you realise it is a Grimoire filled with magic");
		Office.addItem(book);
		
		
		
		Item chest = new Item("chest");
		chest.setDesc("Large, heavy treasure chest");
		PirateShip.addItem(chest);
		chest.setHeavy(true);
		Item key = new Key();
		key.setDesc("It's an ornate key.");
		ThroneRoom.addItem(key);
		Item CraftingBench = new CraftingBench();
		Basement.addItem(CraftingBench);
		CraftingBench.setDesc("Crafting table can combine certain items to make something else");
		CraftingBench.setHeavy(true);
		Item cannon = new Cannon();
		ShipDeck.addItem(cannon);
		cannon.setDesc("A large, loaded cannon pointing off the side of the ship");
		
		
		
		return TreeRoom;
	}
}
