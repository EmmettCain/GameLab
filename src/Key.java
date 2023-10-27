
public class Key extends Item{

	public Key() {
		super("key");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("pirateship")) {
			if(isUsed())
				System.out.println("The chest is already open");
			else {
				System.out.println("The key fits! You open the chest and find a diamond inside");
				Item diamond = new Item("diamond");
				diamond.setDesc("Sparkly!");
				Game.getCurrentRoom().addItem(diamond);
				setUsed(true);
			}
		} else 
			System.out.println("The key doesn't fit in any of the locks in this room");
	}
	
}
