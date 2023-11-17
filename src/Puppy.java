
public class Puppy extends NPC{

	public Puppy() {
		super("puppy", "A puppy wags his tail at you");
	}
	
	int i=0;
	
	public void talk() {
		i+=1;
		if(i == 1 ) {
			say("Hi! I'm and adorable puppy");
			String[] options = {
					"Yes, you are. Who's a good boy?",
					"Ew, no. You're actually kinda hideous."
			};
			getResponse(options);
			
		} else if(i == 2 ) {		
			say("Hey. Wanna play fetch? Say yes! Say yes!");
			String[] options = {
					"Yes. I love fetch!",
					"No. I am a horrible person and don't like playing with puppies."
			};
			getResponse(options);
			
		} else if( i >= 3 ) {
			say("Yip! (The puppy wags his tail)");
			
		}
	}
	
	@Override
	public void response(int choice) {
		if( i == 1 ) {
			switch(choice) {
			case 1:
				say("I am! I'm a good boy");
				break;
			case 2:
				say("I am adorable. Why are you so mean (The puppy bites the you)");
				break;
			}
		} else if ( i == 2 ) {
			switch(choice) {
			case 1:
				say("Yay! Fetch! (The puppy runs off and returns with a ball. The player receives the ball.)");
				break;
			case 2:
				say("You're a bad person! I don't like you! (The puppy runs away and doesn't come back.)");
			}
	
		}
		
	}
}
