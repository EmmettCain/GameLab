
public class Puppy extends NPC{

	public Puppy() {
		super("puppy", "A puppy wags his tail at you");
	}
	
	public void talk() {
		say("Hi! I'm and adorable puppy");
		String[] options = {
				"yes, you are",
				"No, you are not"
		};
		getResponse(options);
	}
	
	public void response(int choice) {
		switch(choice) {
		case 1:
			say("I am! I'm adorable");
			break;
		case 2:
			say("Why are you so mean");
			break;
		}
	}
	
}
