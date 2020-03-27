import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	public static Menu menu;
	public static GameScreen screen;
	public static ActionListener a=new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			  	
			  	menu.setVisible(false);
			  	screen.start();
			  
			  } 
			} ;;
	
	
	public Main() { 
	
        JFrame frame = new JFrame();
        menu=new Menu();
        screen=new GameScreen();
        screen.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.add(menu);
        frame.add(screen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake");
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);    
        
       
        
       
    }
	public class Menu extends JPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public Menu() {
			JButton begin=new JButton("Start");	
			JButton Option=new JButton("Options");
			JButton LeaderBoard=new JButton("LeaderBoard");
			JButton Exit=new JButton("Exit");
			JPanel p1=new JPanel(new GridLayout(8,1));
			JPanel main=new JPanel(new GridLayout(2,1));
			
			
			
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			String path = classLoader.getResource("unnamed.png").getPath();
			BufferedImage myPicture = null;
			try {
				myPicture = ImageIO.read(new File(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			
			
			
			
			this.setLayout(new FlowLayout());
			p1.add(begin);
			
			p1.add(Option);
			
			p1.add(LeaderBoard);
			
			p1.add(Exit);
			main.add(picLabel);
			main.add(p1);
			this.add(main);
			
			begin.addActionListener(a);
		}

	}

	public static void main(String[] args) {
		new Main();

	}

}
