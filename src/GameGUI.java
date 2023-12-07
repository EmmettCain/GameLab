import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameGUI extends JFrame implements KeyListener {

	private JTextArea textArea;
	private JTextField textField;
	
	public void print(String s) {
		textArea.append(s+"\n\n");
	}
	
	public GameGUI() {
		setTitle("Text Game");
		setSize(500, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		textArea = new JTextArea();
		textArea.setFont(new Font(null, Font.PLAIN, 20));
		textArea.setRows(15);
		textArea.setColumns(30);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane scroll = new JScrollPane(textArea);
		add(scroll, BorderLayout.CENTER);
		
		
		textField = new JTextField();
		textField.setColumns(21);
		textField.setFont(new Font(null, Font.PLAIN, 26));
		textField.addKeyListener(this);
		add(textField, BorderLayout.SOUTH);
		
		setVisible(true);
		
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == '\n') {
			if(NPC.talking == true) {
				int option = Integer.parseInt(textField.getText());
				NPC.NPCname.response(option);
				NPC.talking = false;
			}else {
				Game.processCommand(textField.getText());
			}
			textField.setText("");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
