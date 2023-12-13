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
	private static GameGUI gui;
	
		public static void main(String[] args) {
			RoomDesc();
			currentRoom = World.buildWorld();
			gui = new GameGUI();
			Game.print("You wake up in a room you have never seen before, you must find you way back to your world");
			Game.print(currentRoom);
			Game.print("What do you want to do");
			
		}
		
		public static void processCommand(String playerCommand) {
			String[] input;
			Item v;
			Item x;
			NPC npc;
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
						Game.print("You are carrying nothing");
					} else {
						for(Item i : inventory) {
							Game.print(i);
						}
					}
				} else if (playerCommand.equals("x")) {
					Game.print("Okay. Bye!");
				} else if (input[0].equals("look"))  {
					x = getItem(input[1]);
					if(x == null) 
						x = currentRoom.getItem(input[1]);
					if(x == null)
						Game.print("There is no"+input[1]+".");
					else 
						x.look();
					npc = Room.getNPC(input[1]);
					if( npc == null )
						Game.print("The"+input[1]+"is not in this room");
					else
						npc.look();
				} else if (input[0].equals("take")) {
				
						if(currentRoom.hasItem(input[1])) {
							Item item = currentRoom.getItem(input[1]);
							item.take();
						} else {
							Game.print("There is no "+input[1]+"!");
						}
				} else if (input[0].equals("use")) {
						x = getItem(input[1]);
						if(x == null) 
							x = currentRoom.getItem(input[1]);
						if(x == null)
							Game.print("You can not use the " + input[1] + ".");
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
					Game.print("Invalid command.");
				}
				if(getCurrentRoom().getName().equals("home")) {
					Game.print("You wake and you are in your bed at home.");
					Game.print("Congragulations!. You have succesfully made it home and beaten the game!");
				} else {
					Game.print("What do you want to do");
				}
			}
		
		
		
		public static Room getCurrentRoom() {
			return currentRoom;
		}
		
		public static Room setCurrentRoom(Room r) {
			return currentRoom = r;
		}
		
		public static void move(String direction) {
			Room nextRoom = currentRoom.getExit(direction.charAt(0));
			if(nextRoom != null) {
				if(nextRoom.isLocked()) {
					Game.print("The room is locked");
				} else {
					currentRoom = nextRoom;
					Game.print(currentRoom);
				}
			} else {
				Game.print("You can't go that way");
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
		
		
		public static void addInventory(Item i) {
			inventory.add(i);
		}
		
		public static void removeInventory(String n) {
			Item v = getItem(n);
			inventory.remove(v);
			
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
		
		public static void print(Object s) {
			gui.print(s.toString());
		}
		
		
}
