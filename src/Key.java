
public class Key extends Item{

	public Key() {
		super("key");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("pirateship")) {
			if(isUsed())
				System.out.println("The chest is already open");
			else {
				System.out.println("The key fits! You open the chest and find a a spell inside.");
				Item spell = new Item("spell");
				spell.setDesc("The spell creates an area of flames on the ground.");
				Game.getCurrentRoom().addItem(spell);
				setUsed(true);
			}
		} else 
			System.out.println("The key doesn't fit in any of the locks in this room");
	}
	
}
