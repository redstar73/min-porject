import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Main {
	
	private static Menu menu;
	private static GameScreen screen;
	private static JPanel ps;
	private static ActionListener a=new ActionListener() { 
		public void actionPerformed(ActionEvent e) { 
			  	menu.setVisible(false);
			  	
			  	ps.setVisible(true);
			  	
			  	screen.Reset();
			  	screen.start();
			  
			  } 
			} ;
	
	
	public Main() { 
	
        JFrame frame = new JFrame();
        menu=new Menu();
        JDialog dia=new JDialog(frame, "GAME OVER");
        screen=new GameScreen(dia);
        
        
        ps=new JPanel(new BorderLayout());
        ps.add(screen.getScore(),BorderLayout.NORTH);
        ps.add(screen,BorderLayout.SOUTH);
        menu.setVisible(true);
        
        dia.setLocationRelativeTo(null);
        dia.setLayout(new GridLayout(2,1));
        JPanel game=new JPanel(new FlowLayout(FlowLayout.CENTER));
        game.add(new Label("GAME OVER"));
        dia.add(game);
        JButton Retry=new JButton("Retry");
        JButton Back=new JButton("Menu");
        
        Retry.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			  	dia.setVisible(false);
			  	screen.Reset();
			  	screen.start();
			
			  } 
			} );
        
        Back.addActionListener(new ActionListener() { 
  		  public void actionPerformed(ActionEvent e1) { 
  			screen.Reset();
  			dia.setVisible(false);
  			menu.setVisible(true);
		  	
  			
  			  } 
  			} );
        
        JPanel choise=new JPanel(new FlowLayout(FlowLayout.CENTER));
        choise.add(Retry);
        choise.add(Back);
        dia.add(choise);
        dia.setUndecorated(true);
        
        dia.pack();
        dia.setResizable(false);
        
        
        
        frame.setLayout(new FlowLayout());
        frame.add(menu);
        frame.add(ps);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake");
        frame.setResizable(false);
        frame.setSize(530,575);
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
			JPanel main=new JPanel(new BorderLayout());
			JSlider speed=new JSlider();
			JPanel opt=new JPanel(new GridLayout(2,1));
			opt.add(speed);
			setPreferredSize(new Dimension(500, 570));
			
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
			
			
			
			main.add(picLabel,BorderLayout.NORTH);
			main.add(opt);
			opt.setVisible(false);
			main.add(p1,BorderLayout.SOUTH);
			
			this.add(main);
			Option.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
				  	p1.setVisible(false);
				  	opt.setVisible(true);
				  
				  } 
				} );
			
			begin.addActionListener(a);
		}

	}

	public static void main(String[] args) {
		new Main();

	}

}
