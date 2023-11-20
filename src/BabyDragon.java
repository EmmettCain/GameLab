
public class BabyDragon extends NPC{

	public BabyDragon() {
		super("dragon", "A baby dragon looks at you with curious, heartfelt eyes.");
	}
	
	int i = 0;
	Item x;
	public void talk() {
		i+=1;
		x= Game.getItem("sword");
		if(x == null) {
			if(i == 1) {
				say("Hello! My name is Kaisel. It is nice to meet you");
			} else if(i >= 2) {
				say("I briefly recall an item from a dream. I can not remember exactly what it is. Could you try to help me, I would remember it if I saw it.");
			}
		} else {
			if(i == 1) {
				say("Hello! My name is Kaisel. Is is nice to meet you");
				String option[] = {
						"Hi Kaisel. It is nice to meet you to.",
						"i have something else to do."
				};
				getResponse(option);
			}else if(i == 2) {
				say("That sword your holding was the sword that the man who used protected my mother once held. May I have it?");
				String option[] = {
						"Yes, I will gladly give it to you",
						"I'm sorry, I can't give it to you."
				};
				getResponse(option);
			} else if(i == 2 && x == null) {
				
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
		}else if(i == 2) {
			switch(choice) {
			case 1:
				say ("Thank you for giving me this sword. Here is something that I belive would be valuable to you.");
				break;
			case 2:
				say("That is okay. If you ever feel as if you do not need it, I would gladly take it off your hands.");
				break;
			}
		}
	}
}
