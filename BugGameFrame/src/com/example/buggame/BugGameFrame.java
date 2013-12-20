package com.example.buggame;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;


import javax.swing.*;


public class BugGameFrame extends JFrame {
	private Timer t;
	private BugTimeListener bugTimeLis;
	private ImagePanel theImagePanel;
	public BugGameFrame()
	{
		t = null;
		JMenuBar theMenu = new JMenuBar();
		JMenu fileMenu = new JMenu("Arkiv");
		fileMenu.setMnemonic('A');
		JMenu helpMenu = new JMenu("Hjälp");
		helpMenu.setMnemonic('H');
		JMenuItem helpItem = new JMenuItem();
		helpItem.setAction(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {			
			}	
		});
		JMenuItem closeItem = new JMenuItem();
		closeItem.setAction(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}	
				
			});
		closeItem.setText("Avsluta");
		closeItem.setMnemonic('v');
		JMenuItem newItem = new JMenuItem();
		newItem.setAction(new AbstractAction(){//to handle the timelistener
			
			private static final long serialVersionUID = 1L;
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if( t == null){//The game is played for the first time
					final Image theImage = Toolkit.getDefaultToolkit().getImage("C:/Users/miki/Desktop/mobiletest/GUIprojekt/src/bug.jpg");
					
					
					theImagePanel = new ImagePanel(theImage,0.25);
					theImagePanel.addMouseListener(new MyMouseListener(theImage));
					bugTimeLis = new BugTimeListener(theImagePanel);
					t = new Timer(0,bugTimeLis );// new timelistener
					t.setRepeats(true);
					t.setDelay(900); // time in milliseconds
					t.start();
				}
				else{//to start a game a second, third... time
					t.restart();
					bugTimeLis.setTimesToZero();
//					theImagePanel.setCounterToZero();
				}

				//add(imgPane);
				//setVisible(true);
			}

		


			});
		newItem.setText("Nytt Spel");
		newItem.setMnemonic('N');
		this.setJMenuBar(theMenu);
		theMenu.add(fileMenu);
		theMenu.add(helpMenu);
		fileMenu.add(newItem);
		fileMenu.add(closeItem);
		
		setSize(800,800);
		this.setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("The Bug Hunt");
		setVisible(true);
	}
	public class ImagePanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = -3499993469909119436L;
		private Image  image;
		private Double scale;
		private int xCoor;
		private int yCoor;
		private int width;
		private int height;
		private Random rand;
		private int clickCounter;
		private double imgWidth;
		private double imgHeight;
		
		public ImagePanel(Image im,Double sc){
			image = im;
			scale = sc;
			rand = new Random();
			xCoor = rand.nextInt(500);
			yCoor = rand.nextInt(500);
			this.setBackground(Color.LIGHT_GRAY);
			clickCounter = 0;
		}
		public void repaintBug(){
			xCoor = rand.nextInt(500);
			yCoor = rand.nextInt(500);
		}
		public void setCounterToZero(){
			clickCounter = 0;
		}
		public int increasCounter(){
			return clickCounter++;
		}
		public int getCounter(){
			return clickCounter;
		}
		public Image getTheImage(){
			return image;
		}
		public double getScale(){
			return scale;
		}
		public int getTheWidth(){
			return width;
		}
		public int getTheHeight(){
			return height;
		}
		public int getXCoor(){
			return xCoor;
		}
		public int getYCoor(){
			return yCoor;
		}
		protected void paintComponent(Graphics g){
	        super.paintComponent(g);
	        imgWidth = image.getWidth(this);//to find out if the image is clicked later on
	        imgHeight = image.getHeight(this) ;
	        width = (int)imgWidth;//(image.getWidth(this)*scale);
	        height = (int)imgHeight;//(image.getHeight(this)*scale);
	        repaintBug();
	        g.drawImage(image, xCoor, yCoor,width,height, this);          
	    }
		public double getImgWidth() {
			//to access the Image size
			return imgWidth;
		}
		public double getImgHeight() {
			//to access the Image size
			return imgHeight;
		}
	}
	public class BugTimeListener implements ActionListener{
		
		private JDesktopPane jPane;
		private ImagePanel theBugPanel;
		private int times;
		
		public BugTimeListener( ImagePanel imgPanel){
			
			times = 1;
			jPane = new JDesktopPane();
			jPane.setBackground(Color.LIGHT_GRAY);
			theBugPanel = imgPanel;
			add(jPane);
			setVisible(true);
			repaint();
			
		}
		public void setTimesToZero(){
			times = 0;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
						
			if(times %2 != 0){
				add(jPane);
				System.out.println("Jpane"+ times);
				setVisible(true);			
				repaint();
				
			}
			else{
				add(theBugPanel);
				System.out.println("ImagePane" + times);
				setVisible(true);			
				repaint();
			}
			times++;
			
			if(times == 11){
				((Timer)arg0.getSource()).stop();
				Container thePane = getContentPane();
				//DataBaseConnection dBase = new DataBaseConnection();
				//dBase.setSQLQuestion("SELECT * FROM resultbuggame;");
				//dBase.connectAndAsk();
				if(JOptionPane.showConfirmDialog(thePane, "Du har klickat på bugen "+ theBugPanel.getCounter() + " ggr! \n Vill du fortsätta spela ?" )== 0){
					System.out.println("Du vill fortsätta");
					
				}
//				else
//					System.exit(0);
					
				
			}
							
		}
		

	}
	public class MyMouseListener implements MouseListener{
		private Image theImage;
		
		public MyMouseListener(Image img){
			theImage = img;
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			ImagePanel thePanel = (ImagePanel)e.getSource();
			if (theImage != null) {
              	double width = thePanel.getImgWidth();
				double height = thePanel.getImgHeight();
				double x = thePanel.getXCoor();
				double y = thePanel.getYCoor();
                System.out.println("Image punkt" + x +" y: " + y+" width "+ width + " height: "+ height);
                System.out.println("Klickad punkt: "+ e.getX()+ " y: "+ e.getY());
                Rectangle2D.Double bounds = new Rectangle2D.Double(x, y, width, height);
                if (bounds.contains(e.getPoint())) {
                	thePanel.increasCounter();
                	int i = thePanel.getCounter();
                  System.out.println("Bugen klickad " + i + " gånger");
                }
            }

           		
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

public static void main(String [] arg){
	BugGameFrame v = new BugGameFrame();
}
}
