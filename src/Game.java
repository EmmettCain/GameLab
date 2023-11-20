import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
	
	private static Room currentRoom;
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static HashMap<String, String> RoomDescription = new HashMap<String, String>();
	public static Scanner scan = new Scanner(System.in);
	
	
		public static void main(String[] args) {
			RoomDesc();
			System.out.println("You wake up in a room you have never seen before, you must find you way back to your world");
			String playerCommand = " ";
			String[] input;
			Item v;
			Item x;
			NPC npc;
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
					x = getItem(input[1]);
					if(x == null) 
						x = currentRoom.getItem(input[1]);
					if(x == null)
						System.out.println("There is no"+input[1]+".");
					else 
						x.look();
					npc = Room.getNPC(input[1]);
					if( npc == null )
						System.out.println("The"+input[1]+"is not in this room");
					else
						npc.look();
				} else if (input[0].equals("take")) {
				
						if(currentRoom.hasItem(input[1])) {
							Item item = currentRoom.getItem(input[1]);
							item.take();
						} else {
							System.out.println("There is no "+input[1]+"!");
						}
				} else if (input[0].equals("use")) {
						x = getItem(input[1]);
						if(x == null) 
							x = currentRoom.getItem(input[1]);
						if(x == null)
							System.out.println("You can not use the " + input[1] + ".");
						else
							x.use();
				} else if(input[0].equals("give")) {
					v= getItem(input[1]);
					
				
				}else if(input[0].equals("save")) {
					saveGame();
				}else if(input[0].equals("talk")){
					npc = currentRoom.getNPC(input[1]);
					npc.talk();
				}else {
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
		
		public static void RoomDesc() {
			try {
				Scanner scan = new Scanner(new File("RoomDescriptions"));
				while(scan.hasNextLine()) {
					String name = scan.nextLine();
					String desc = scan.nextLine();
					scan.nextLine();
					RoomDescription.put(name, desc);
				}
			} catch(IOException ex) {
				Game.print("Error: Cannot load room descriptions");
			}
		}
		
		public static void saveGame() {
			File saveFile = new File("save");
			try {
				saveFile.createNewFile();
				ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(saveFile));
				stream.writeObject(currentRoom);
				stream.writeObject(inventory);
				stream.writeObject(World.rooms);
				stream.close();
				Game.print("game saved.");
			} catch(IOException e) {
				Game.print("ERROR: Cannot save file.");
				e.printStackTrace();
			}
		}
		
		public static void loadGame() {
			try {
				ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File("save")));
				currentRoom = (Room) stream.readObject();
				inventory = (ArrayList<Item>) stream.readObject();
				World.rooms = (HashMap<String, Room>) stream.readObject();
				stream.close();
			} catch (IOException ex) {
				Game.print("Error loading file");
				ex.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
}
