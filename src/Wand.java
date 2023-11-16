
public class Wand extends Item{
	
	public Wand() {
		super("wand");
	}
	
	@Override
	public void take() {
		super.take(); // calls item's take method
		Game.getCurrentRoom().setRoomID("classroom_A");
	}

	public void use() {
		if(Game.getCurrentRoom().getName().equals("outsidetree")) {
			System.out.println("You wave the wand and the Throne Room portal opens!");
			Room ThroneRoom = Game.getCurrentRoom().getExit('n');
			ThroneRoom.setLocked(false);
		} else {
			System.out.println("You wave the wand around");
		}
	}
}
