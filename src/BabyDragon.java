
public class BabyDragon extends NPC{

	public BabyDragon() {
		super("dragon", "A baby dragon looks at you with curious, heartfelt eyes.");
	}
	
	int i = 0;
	public void talk() {
		i+=1;
		for(Item i : Game.inventory) {
			if(i.getName().equals("sword")) {
				
			}
	}
}
