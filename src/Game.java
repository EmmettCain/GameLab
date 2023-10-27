import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private static Room currentRoom;
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	
	
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			String playerCommand = " ";
			String[] input;
			currentRoom = World.buildWorld();
			System.out.println(currentRoom);
			while(!playerCommand.equals("x")) {
				System.out.println("What do you want to do");
				playerCommand = scan.nextLine();
				input = playerCommand.split(" ");
				if(playerCommand.equals("e")) {
					move(playerCommand);
				} else if(playerCommand.equals("w")) {
					move(playerCommand);
				} else if(playerCommand.equals("n")) {
					move(playerCommand);
				} else if(playerCommand.equals("s")) {
					move(playerCommand);
				} else if(playerCommand.equals("d")) {
					move(playerCommand);
				} else if(playerCommand.equals("u")) {
					move(playerCommand);
				} else if (playerCommand.equals("i")) {
					if(inventory.isEmpty()) {
						System.out.println("You are carrying nothing");
					} else {
						for(Item i : inventory) {
							System.out.println(i);
						}
					}
				} else if (playerCommand.equals("x")) {
					System.out.println("okay. Bye!");
				} else if (input[0].equals("look"))  {
					if(currentRoom.hasItem(input[1])) {
						System.out.println("You look at the " + input[1]);
					} else {
						System.out.println("This item is not in the current room");
					}
					for(Item i : inventory) {
						if(i.getName().equals(input[1])) {
							System.out.println("You look at the " + input[1]);
						} else {
							System.out.println("The item is not in your inventory");
						}
					}
				} else if (input[0].equals("take")) {
				
						if(currentRoom.hasItem(input[1])) {
							Item item = currentRoom.getItem(input[1]);
							if(item.isHeavy()){
								System.out.println("That's too heavy to carry around");
							} else {
								inventory.add(currentRoom.removeItem(input[1]));
								System.out.println("You take the "+input[1]);
							}
						} else {
							System.out.println("There is no "+input[1]+"!");
						}
				} else if (input[0].equals("use")) {
					for(Item i : inventory) {
						if(i.getName().equals(input[1])) {
							System.out.println("You use the " + input[1]);
						} else {
							System.out.println("You can not use the " + input[1]);
						}
					}
				} else {
					System.out.println("Invalid command.");
				}

//		currentRoom = currentRoom.getExit('e');
//		System.out.println(currentRoom);
//		System.out.println("\nNow we'll move west!");
//		currentRoom = currentRoom.getExit('w');
//		System.out.println(currentRoom);
		
			}
			scan.close();
		}
		
		
		public static Room getCurrentRoom() {
			return currentRoom;
		}
		
		public static void move(String direction) {
			Room nextRoom = currentRoom.getExit(direction.charAt(0));
			if(nextRoom != null) {
				if(nextRoom.isLocked()) {
					System.out.println("The room is locked");
				} else {
					currentRoom = nextRoom;
					System.out.println(currentRoom);
				}
			} else {
				System.out.println("You can't go that way");
			}
		}
		
		public static Item getItem(String name) {
			for(Item i : inventory) {
				if(i.getName().equals(name)) {
					return i;
				}
			}
			return null;
		}
		
		public static void print(String message) {
			System.out.println(message+"\n");
			}
		
		public static void addInventory(Item i) {
			inventory.add(i);
		}
		
		public static void removeInventory(String n) {
			
			
		}
		
		public static boolean inInventory(String n) {
			for(Item i : inventory) {
				if(i.getName().equals(n)) 
					return true;
				
			}
			return false;
		}
		
		
		
}
