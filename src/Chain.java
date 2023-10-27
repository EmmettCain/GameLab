
public class Chain extends Item{
	
	public Chain() {
		super("chain");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("barn")) {
			if(isUsed())
				Game.print("The chain has already been used");
			else {
				Game.print("You use the chain, goo is poured all over you");
				Item goo = new Item("goo");
				Game.addInventory(goo);
			}
		}else 
			Game.print("There is no chain in the room");
		
			
	}

}
