
public class Skull extends Item{

	public Skull() {
		super("skull");
	}
	
	@Override
	public void take() {
		super.take();
		Game.getCurrentRoom().setRoomID("pirateship_A");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("throneroom")) {
			if(isUsed()) {
				Game.print("The basement is already open");
			} else {
				Game.print("The skull and the crown start to react to eachother. A staircase that leads down opens up behind the throne. The crown seems to no longer be heavy");
				Room Basement = Game.getCurrentRoom().getExit('d');
				Basement.setLocked(false);
				Item crown = new Crown();
				Game.getCurrentRoom().addItem(crown);
				crown.setDesc("A gold crown, sitting atop of the throne");
			}
		}
	}
	
	
}
