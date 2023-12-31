
public class NPC {

	private String name;
	private String desc;
	public static Boolean talking = false;
	public static NPC NPCname;
	
	public NPC(String name) {
		this.name = name;
	}
	
	public NPC(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static void give(Item i) {
		Game.inventory.add(i);
	}
	
	public void look() {
		Game.print(desc);
	}
	
	public void talk() {
		Game.print("You can't talk to "+name+".");
	}
	
	public void response(int option) {
		
	}
	
	public void say(String dialog) {
		Game.print(name+": "+dialog);
	}
	
	/**
	 * Displays options to player. 
	 * Prompts player to select an option
	 * read player's choice
	 * call the response method with the player's choice
	 * @param options
	 */
	public void getResponse(String[] options) {
		for(int i=0;i<options.length; i++) {
			Game.print("Option "+(i+1)+": "+options[i]);
		} 
		Game.print("Enter an option(1-"+options.length+"):");
		NPCname = this;
		talking = true;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
