
public class Sigil extends Item{

	public Sigil() {
		super("sigil");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("outsidetree")) {
			if(isUsed()) {
				Game.print("The sigil has no magic left. The portal to your world is already open");
			} else {
				Game.print("The magic in the sigil pours into the engraving on the tree. A large staircase appears with a portal at the top. You get sucked into the into the portal.");
				
				Game.setCurrentRoom(World.rooms.get("home"));
				World.rooms.get("home").setLocked(false);
			}
		}
	}

}
