import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
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
			JSlider speed=new JSlider(500000,1000000,750000);
			JPanel opt=new JPanel(new GridLayout(7,1));
			CheckboxGroup g=new CheckboxGroup();
			Checkbox c1=new Checkbox("Green",g,true);
			Checkbox c2=new Checkbox("Yallow",g,false);
			Checkbox c3=new Checkbox("Orange",g,false);
			JPanel colors=new JPanel(new FlowLayout(FlowLayout.CENTER));
			CheckboxGroup bg=new CheckboxGroup();
			Checkbox bc1=new Checkbox("Black",bg,true);
			Checkbox bc2=new Checkbox("White",bg,false);
			JPanel bcolors=new JPanel(new FlowLayout(FlowLayout.CENTER));
			JButton save=new JButton("Save");	
			JButton cancel=new JButton("Cancel");
			JPanel buttons=new JPanel(new FlowLayout(FlowLayout.CENTER));
			
			buttons.add(save);
			buttons.add(cancel);
			cancel.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
				  	p1.setVisible(true);
				  	opt.setVisible(false);
				  
				  } 
				} );
			Exit.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					System.exit(0);
				  
				  } 
				} );
			
			bcolors.add(bc1);
			bcolors.add(bc2);
			
			colors.add(c1);
			colors.add(c2);
			colors.add(c3);
			
			opt.add(new JLabel("Snake speed :"));
			opt.add(speed);
			
			opt.add(new JLabel("Snake Color :"));
			opt.add(colors);
			opt.add(new JLabel("Background Color :"));
			opt.add(bcolors);
			opt.add(buttons);
			
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
			p1.add(new JPanel());
			p1.add(begin);
			p1.add(new JPanel());
			p1.add(Option);
			p1.add(new JPanel());
			p1.add(LeaderBoard);
			p1.add(new JPanel());
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
