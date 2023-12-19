
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Frame extends JPanel implements Runnable{

	
	Thread gamethread;
    double g = 0.7;
	public double velx = 2;
    public double velg;
	public double vely = 2;
	public double x = 20;
	public double y = 20;
    public double WIDTH = 20;
	public double HEIGHT= 20;
    public double block_x = 150;
	public double block_y = 100;
    public double block_WIDTH = 60;
	public double block_HEIGHT= 60;
    public Rectangle2D.Double r2;
   
	Keybind keybinder = new Keybind();
	Frame(){
		this.setPreferredSize(new Dimension(300,200));
		this.setDoubleBuffered(true);
		this.setBackground(Color.white);
		this.addKeyListener(keybinder);
		this.setFocusable(true);   
	}
	
	public void startgamethread() {
		gamethread = new Thread(this);
		gamethread.start();
	}

	public double getx() {
		return x;
	}

	public double gety() {
		return y;
	}

    public void checkcollision(Rectangle2D r1, Rectangle2D r2){

        if (r1.intersects(block_x,block_y,block_WIDTH,1)) {
            y = block_y;
        }

    }

	public void move() {
		if(keybinder.wkey == true) {
			
            if (keybinder.akey && keybinder.dkey) {
                y -= vely * 0.7;    
            } else {
                y -= vely;
            }
		}
		if(keybinder.akey == true) {
		    if (keybinder.skey && keybinder.wkey) {
                x -= velx * 0.7;
            } else {
                x -= velx;
            }
		}
		if(keybinder.skey == true) {
			if (keybinder.akey && keybinder.dkey) {
                y += vely * 0.7;    
            } else {
                y += vely;
            }
		}
		if(keybinder.dkey == true) {
			if (keybinder.skey && keybinder.wkey) {
                x += velx * 0.7;
            } else {
                x += velx;
            }
		}
        
		System.out.println(getx() + " och " +  gety());
        
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
        r2 = new Rectangle2D.Double(x,y,WIDTH,HEIGHT);
        g2d.draw(r2);
	}

	@Override
	public void run() {
		while(gamethread != null) {
			move();
			repaint();
            
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            
		}
	}
}

