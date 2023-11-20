
public class Cannon extends Item{

	public Cannon() {
		super("cannon");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("shipdeck")) {
			if(isUsed()) {
				Game.print("The cannon has already been used. There are no cannon balls left");
			} else {
				Game.print("You light the fuse to the cannon and run away out of shock. It fires and after a couple seconds you hear an explosion");
				Room Hallway = new Room("hallway");
				Hallway.setLocked(false);
				World.rooms.get("classroom").addExit(Hallway,'e');
				Game.getCurrentRoom().setRoomID("classroom_B");
			}
		} 
	}
}
