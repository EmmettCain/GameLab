
public class Wand extends Item{
	
	public Wand() {
		super("wand");
	}

	public void use() {
		if(Game.getCurrentRoom().getName().equals("outside")) {
			System.out.println("You wave the wand and the Throne Room portal opens!");
			Room ThroneRoom = Game.getCurrentRoom().getExit('e');
			ThroneRoom.setLocked(false);
		} else {
			System.out.println("You wave the wand around");
		}
	}
}
