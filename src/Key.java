
public class Key extends Item{

	public Key() {
		super("key");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("pirateship")) {
			if(isUsed())
				Game.print("The chest is already open");
			else {
				Game.print("The key fits! You open the chest and find a a spell inside.");
				Item spell = new Spell();
				spell.setDesc("The spell creates an area of flames on the ground.");
				Game.getCurrentRoom().addItem(spell);
				setUsed(true);
			}
		} else 
			Game.print("The key doesn't fit in any of the locks in this room");
	}
	
}
