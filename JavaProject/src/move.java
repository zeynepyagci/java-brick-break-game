import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class move extends JPanel implements KeyListener, Runnable, ActionListener {

	private JFrame frame;
	private Icon bar;
	private Icon ball;
	private JLabel brick, top;
	private int barX = 190;
	private int barY = 680;
	
	
	
	//boxes
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	

	//ball
	private int ballRadius = 12;
	private int topX = 200;
	private int topY = 630;
	
	private int brickNumber = 9;
	
	private int lives = 3;
	
	private int score = 0;
	
	private JPanel panel;

	private JLabel scoreBar;
	private JLabel liveBar;
	private JLabel levelBar;
	
	
	
	public void createGUI() throws IOException{
		
		scoreBar = new JLabel();
		scoreBar.setText("Score: " + score);
		scoreBar.setBounds(490, 0, 60, 40);
		scoreBar.setForeground(Color.WHITE);
		
		liveBar = new JLabel();
		liveBar.setText("Lives: " + lives);
		liveBar.setBounds(20, 0, 60, 40);
		liveBar.setForeground(Color.WHITE);
		
		levelBar = new JLabel();
		levelBar.setText("Level 1");
		levelBar.setBounds(260, 0, 60, 40);
		levelBar.setForeground(Color.WHITE);
		
		panel = new JPanelWithBackground("projefoto.jpg");
		frame = new JFrame("Oyun");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
		bar = new ImageIcon(getClass().getResource("projebar.jpg"));
		ball = new ImageIcon(getClass().getResource("top.png"));
		brick = new JLabel(bar);
		brick.setBounds(barX, barY, 150, 30);
		top = new JLabel(ball);
		top.setBounds(topX, topY, 25, 25);
		panel.add(brick);
		panel.add(top);
		panel.add(liveBar);
		panel.add(scoreBar);
		panel.add(levelBar);
		frame.add(panel);
		frame.setSize(575,820);
		frame.addKeyListener(this); 
		frame.setVisible(true);
		
		//boxes
		Icon box_red=new ImageIcon(getClass().getResource("red.jpg"));
		Icon box_orange=new ImageIcon(getClass().getResource("orange.jpg"));
		label1 = new JLabel(box_red);
		label2 = new JLabel(box_red);
		label3 = new JLabel(box_red);
		label4 = new JLabel(box_red);
		label5 = new JLabel(box_red);
		label6 = new JLabel(box_red);
		label7 = new JLabel(box_red);
		label8 = new JLabel(box_red);
		label9 = new JLabel(box_red);
		label1.setBounds(100, 120, 85, 45);
		label2.setBounds(240, 120, 85, 45);
		label3.setBounds(380, 120, 85, 45);
		label4.setBounds(100, 200, 85, 45);
		label5.setBounds(240, 200, 85, 45);
		label6.setBounds(380, 200, 85, 45);
		label7.setBounds(100, 280, 85, 45);
		label8.setBounds(240, 280, 85, 45);
		label9.setBounds(380, 280, 85, 45);
		panel.add(label1);  
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		panel.add(label9);
		frame.add(panel);
		frame.setLocationRelativeTo(null);

		panel.repaint();
		
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.green);
		g.fillOval(topX, topY, 25, 25);
	}

	
	

	
	
	public void moveBox(int newX, int newY) {
		brick.setBounds(newX, newY, 150, 30);
	}
	public void moveBox2(int newX, int newY) {
		top.setBounds(newX, newY, 25, 25);
	
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		String whichKey = KeyEvent.getKeyText(e.getKeyCode());
		
		if (whichKey.compareTo("Left")==0) {
			
				moveLeft();
	        
			
		}
		else if (whichKey.compareTo("Right") == 0) {
			
				moveRight();
	        

		}
		else if (whichKey.compareTo("Escape") == 0) {
			System.exit(0);
		}
        
	}

	public void moveLeft() {
		
		barX -= 10;
		
		if(barX <= 0) {
			barX = -barX;
		}
		
		
		moveBox(barX, barY);
		repaint();
	}
	
	public void moveRight() {
		
		barX += 10;
		
		if(barX >= 415)     
        {
			barX = 415;
        }
	
		moveBox(barX, barY);
		repaint();
	}
	
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int i = 0;
		int j = 0;
		while (true) {
			try {
				
				if(top.getX() == 0 || top.getX() == 540) {
					i++;
				}
				if(top.getY() == 0 || top.getY() == 760) {
					j++;
				}
				
				
				if(i % 2 == 0) {
					topX--;
					moveBox2(topX, topY);
					if(j % 2 == 0) {
						topY--;
						moveBox2(topX, topY);
					}
					else if(j % 2 == 1) {
						topY++;
						moveBox2(topX, topY);
					}
				} else if(i % 2 == 1) {
					topX++;
					moveBox2(topX, topY);
					if(j % 2 == 0) {
						topY--;
						moveBox2(topX, topY);
					}
					else if(j % 2 == 1) {
						topY++;
						moveBox2(topX, topY);
					}
				}
					
				if(top.getY() == 760) {
					lives--;
					liveBar.setText("Lives: " + (lives));
				} 
				if(lives == 0) {
					JOptionPane.showMessageDialog(null, "Game Over!", "Game Over", JOptionPane.NO_OPTION);
					System.exit(0);
				}
				if(brickNumber == 0) {
					if (JOptionPane.showConfirmDialog(null,"Congratulations! You passed level 1 !!\nLevel 2 incoming...\nScore: 90","Well Done",
		                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
						move2 move2 = new move2();
			        	try {
							move2.createGUI();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        	new Thread(move2).start();
			        	return;
					} else {
						System.exit(0);
					}
					
		        }
				
					
				if(top.getBounds().intersects(label1.getBounds())) {
					
					j++;
					brickNumber--;
					score = score + 10;
					
					scoreBar.setText("Score: " + score);
					
					if(i % 2 == 0) {
						topX--;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					} else if(i % 2 == 1) {
						topX++;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					}
					
					

					label1.setBounds(-50, -50, 0, 0);

					
				}
				
				
				
				if(top.getBounds().intersects(label2.getBounds())) {
					
					j++;
					brickNumber--;
					score = score + 10;
					
					scoreBar.setText("Score: " + score);
					
					if(i % 2 == 0) {
						topX--;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					} else if(i % 2 == 1) {
						topX++;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					}
					
					

					label2.setBounds(-50, -50, 0, 0);
					
					
					
				}
				
				
				
				if(top.getBounds().intersects(label3.getBounds())) {
					
					j++;
					brickNumber--;
					score = score + 10;
					
					scoreBar.setText("Score: " + score);
					
					if(i % 2 == 0) {
						topX--;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					} else if(i % 2 == 1) {
						topX++;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					}
					

					label3.setBounds(-50, -50, 0, 0);
					
				}
				
				
				
				if(top.getBounds().intersects(label4.getBounds())) {
					
					j++;
					brickNumber--;
					score = score + 10;
					
					scoreBar.setText("Score: " + score);
					
					if(i % 2 == 0) {
						topX--;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					} else if(i % 2 == 1) {
						topX++;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					}
					

					label4.setBounds(-50, -50, 0, 0);
					
				}
				
				
				
				if(top.getBounds().intersects(label5.getBounds())) {
					
					j++;
					brickNumber--;
					score = score + 10;
					
					scoreBar.setText("Score: " + score);
					
					if(i % 2 == 0) {
						topX--;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					} else if(i % 2 == 1) {
						topX++;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					}
					

					label5.setBounds(-50, -50, 0, 0);
					
				}
				
				
				
				if(top.getBounds().intersects(label6.getBounds())) {
					
					j++;
					brickNumber--;
					score = score + 10;
					
					scoreBar.setText("Score: " + score);
					
					if(i % 2 == 0) {
						topX--;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					} else if(i % 2 == 1) {
						topX++;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					}


					label6.setBounds(-50, -50, 0, 0);
					
					
				}
					
				if(top.getBounds().intersects(label7.getBounds())) {
					
					j++;
					brickNumber--;
					score = score + 10;
					
					scoreBar.setText("Score: " + score);
					
					if(i % 2 == 0) {
						topX--;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					} else if(i % 2 == 1) {
						topX++;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					}
					
					

					label7.setBounds(-50, -50, 0, 0);

					
				}

				if(top.getBounds().intersects(label8.getBounds())) {
					
					j++;
					brickNumber--;
					score = score + 10;
					
					scoreBar.setText("Score: " + score);
					
					if(i % 2 == 0) {
						topX--;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					} else if(i % 2 == 1) {
						topX++;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					}
					
					

					label8.setBounds(-50, -50, 0, 0);

					
				}
				
				if(top.getBounds().intersects(label9.getBounds())) {
					
					j++;
					brickNumber--;
					score = score + 10;
					
					scoreBar.setText("Score: " + score);
					
					if(i % 2 == 0) {
						topX--;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					} else if(i % 2 == 1) {
						topX++;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					}
					
					

					label9.setBounds(-50, -50, 0, 0);

					
				}
				
				
				
				
				if(top.getBounds().intersects(brick.getBounds())) {
					
					if(top.getX() == barX || top.getX() == barX+150) {
						i++;
					}
					if(top.getY() == barY || top.getY() == barY+5) {
						j++;
					}
					
					
					if(i % 2 == 0) {
						topX--;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					} else if(i % 2 == 1) {
						topX++;
						moveBox2(topX, topY);
						if(j % 2 == 0) {
							topY--;
							moveBox2(topX, topY);
						}
						else if(j % 2 == 1) {
							topY++;
							moveBox2(topX, topY);
						}
					}
					
				}
				
				
				
				
				
				
				Thread.sleep(3);
				
			} catch (Exception e) {
				
			}
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}
