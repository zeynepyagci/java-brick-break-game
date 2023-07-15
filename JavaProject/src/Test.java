import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class Test extends JFrame {

	

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        
		move move = new move();
		move.createGUI();
		new Thread(move).start();

		//move2 move2 = new move2();
		//move2.createGUI();
		//new Thread(move2).start();
		
		//move3 move3 = new move3();
		//move3.createGUI();
		//new Thread(move3).start();
		
		
	}

}
