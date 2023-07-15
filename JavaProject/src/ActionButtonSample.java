
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ActionButtonSample extends JPanel {
	
	static String name = JOptionPane.showInputDialog(null, "Please enter a name", "Input", JOptionPane.QUESTION_MESSAGE);
	protected static final int DISPOSE_ON_CLOSE = 0;
	private JButton button1,button2,button3,button4,button5,button6;

  public static void main(String args[]) throws IOException {
	  
	JPanel panel = new JPanelWithBackground("projefoto.jpg");
    JFrame frame = new JFrame("Menu");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        System.out.println("Selected: " + command);
        if(command.equals("Options")) {
        	JOptionPane.showMessageDialog(null, "Options", "Options", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(command.equals("Help")) {
        	JOptionPane.showMessageDialog(null, "i. Right key to move right\nii. Left key to move left\niii. If you want to exit during game\nprocess press ESC button", "Help", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(command.equals("Exit")) {
        	if (JOptionPane.showConfirmDialog(null,"Are you sure you want to exit? ","Exit",
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                    System.exit(0);
        }
        else if(command.equals("Scores")) {
        	JOptionPane.showMessageDialog(null, name+ ": 90", "Scores", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(command.equals("About")) {
        	JOptionPane.showMessageDialog(null, "Arkanoida is a 1986 block breaker arcade\ngame developed and published by Taito.", "About", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(command.equals("New Game")) {
        	move move1 = new move();
        	try {
				move1.createGUI();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	new Thread(move1).start();
        }
      }
    };
    
    JButton button1 = new JButton("New Game");
    button1.setActionCommand("New Game");
    button1.addActionListener(actionListener);
    button1.setBounds(155,100, 240, 80);
    panel.add(button1);

    JButton button2 = new JButton("Options");
    button2.setActionCommand("Options");
    button2.addActionListener(actionListener);
    button2.setBounds(155, 200, 240, 80);
    panel.add(button2);
    
    JButton button3 = new JButton("Scores");
    button3.setActionCommand("Scores");
    button3.addActionListener(actionListener);
    button3.setBounds(155, 300, 240, 80);
    panel.add(button3);
    
    JButton button4 = new JButton("Help");
    button4.setActionCommand("Help");
    button4.addActionListener(actionListener);
    button4.setBounds(155, 400, 240, 80);
    panel.add(button4);
    
    JButton button5 = new JButton("About");
    button5.setActionCommand("About");
    button5.addActionListener(actionListener);
    button5.setBounds(155, 500, 240, 80);
    panel.add(button5);
    
    JButton button6 = new JButton("Exit");
    button6.setActionCommand("Exit");
    button6.addActionListener(actionListener);
    button6.setBounds(155, 600, 240, 80);
    panel.add(button6);

    panel.setLayout(null);
    frame.add(panel);
    frame.setSize(575,820);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    
  }







}









