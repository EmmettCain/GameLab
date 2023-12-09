
public class DragonScale extends Item{

	public DragonScale() {
		super("scale");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("hallway")){
			if(isUsed()) {
				Game.print("The door is already open");
			} else {
				Game.print("The scale flies out of your hand and fuses with the door. The door opens!");
				World.rooms.get("office").setLocked(false);
				Game.getCurrentRoom().setRoomID("hallway_A");
				setUsed(true);
			}
		} else 
			Game.print("The scale can not be used here");
		
	}
}
