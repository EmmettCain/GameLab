import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.awt.*;

public class GameGUI extends JFrame {

	private JTextArea textArea;
	
	public void print(String s) {
		textArea.append(s+"\n\n");
	}
	
	public GameGUI() {
		setTitle("Text Game");
		setSize(755, 500);
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
		add(scroll);
		
		setVisible(true);
		
	}
}
