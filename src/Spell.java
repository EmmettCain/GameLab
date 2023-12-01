
public class Spell extends Item{

	
	public Spell() {
		super ("spell");
	}
	
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("barn")) {
			Game.print("You use the spell. An area of flames is created on the floor. The Egg reacts and hatches. A baby dragon named Kaisel looks at you.");
			NPC kaisel = new BabyDragon();
			World.rooms.get("barn").addNPC(kaisel);
		} else {
			Game.print("An area of flames is created on the ground. The fire fades away after a while.");
		}
	}
	
}
