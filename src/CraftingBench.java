
public class CraftingBench extends Item{

	public CraftingBench() {
		super("craftingbench");
	}
	
	int i = 0;
	public void use() {
		i += 1 ;
		Item c = Game.getItem("crown");
		Item w = Game.getItem("wand");
		Item b = Game.getItem("book");
		if(Game.getCurrentRoom().getName().equals("basement")) {
			if(i == 1 && (c == null || w == null || b == null)) {
				Game.print("You can't use the crafting bench at the moment. You do not have the correct items on you.");
			} else if(i == 1 && (c != null && w != null && b != null)){
				Game.print("You can use the crafting bench. Using this will use the crown, wand and book in your inventory to craft a magic sigil?. If you still want to do it please use the crafting bench again. ");
			} else if( i == 2 && (c == null || w == null || b == null )) {
				Game.print("You still can't use the crafting bench");
			} else if( i == 2 && (c != null && w != null && b != null )) {
				Game.removeInventory("crown");
				Game.removeInventory("wand");
				Game.removeInventory("book");
				Item sigil = new Sigil();
				Game.addInventory(sigil);
			} else if( i == 3 ) {
				Game.print("You can not use the crafting bench for anything else");
			}
		}
	}
	
}
