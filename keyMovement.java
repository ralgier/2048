import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public abstract class keyMovement implements KeyListener {


	@Override
	public void keyTyped(KeyEvent e) {
		
		JTextField textField = new JTextField(1);
		textField.addKeyListener(this);
		
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_0) {
			
			System.out.println("dick");
			
		} else if (key == KeyEvent.VK_1) {
			
			System.out.println("double");
			
		}
		
	}
	public static void main (String[] args) { 
		keyMovement movement;
	
		System.out.println("hi");
	}
	

}
