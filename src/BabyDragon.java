
public class BabyDragon extends NPC{

	public BabyDragon() {
		super("kaisel", "A baby dragon looks at you with curious, heartfelt eyes.");
	}
	
	private boolean isGiven = false;
	
	int i = 0;
	Item x;
	public void talk() {
		i+=1;
		x= Game.getItem("sword");
		if(x == null && isGiven == false) {
			if(i == 1) {
				say("Hello! My name is Kaisel. It is nice to meet you");
			} else if(i >= 2 ) {
				say("I briefly recall an item from a dream. I can not remember exactly what it is. Could you try to help me, I would remember it if I saw it.");
			}
		} else {
			if(i == 1) {
				say("Hello! My name is Kaisel. Is is nice to meet you");
				String option[] = {
						"Hi Kaisel. It is nice to meet you to.",
						"I have something else to do."
				};
				getResponse(option);
			}else if(i == 2) {
				say("That sword your holding was the sword that the man who used protected my mother once held. May I have it?");
				String option[] = {
						"Yes, I will gladly give it to you",
						"I'm sorry, I can't give it to you."
				};
				getResponse(option);
			} else if(i >= 3 && x == null) {
				say("Thanks for giving me that sword ealier. I hope what I gave you helped");
			}else if(i >= 3 && x != null) {
				say("That sword your holding was the sword that the man who used protected my mother once held. May I have it?");
				String option[] = {
						"Yes, I will gladly give it to you",
						"I'm sorry, I can't give it to you."
				};
				getResponse(option);
			}
		}
		
	}
	
	@Override
	public void response(int choice) {
		if(i == 1) {
			switch(choice) {
			case 1:
				say("Thank you. You are the first person I've met");
				break;
			case 2:
				say("Okay. See you later!");
				break;
			}
		}else if(i >= 2) {
			switch(choice) {
			case 1:
				say ("Thank you for giving me this sword. Here is something that I belive would be valuable to you.");
				Game.removeInventory("sword");
				Item scale = new DragonScale();
				scale.setDesc("A large scale that gives you a strong sense of life");
				NPC.give(scale);
				isGiven = true;
				break;
			case 2:
				say("That is okay. If you ever feel as if you do not need it, I would gladly take it off your hands.");
				break;
			}
		} 
		
	}
}
