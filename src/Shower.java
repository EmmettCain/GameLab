
public class Shower extends Item{

	public Shower() {
		super("shower");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("treeroom")) {
			if(Game.inInventory("goo")) {
				Game.print("You use the shower, the goo is washed away");
				Game.removeInventory("goo");
			} else 
				Game.print("You are not dirty enough to take a shower");
		}
	}
}
