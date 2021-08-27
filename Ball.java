import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

/* You will create a the ball class
 *
 * It will need instance variables: x, y, w, h
 * 		You will also need an instance variable: xspeed, yspeed
 * Create a constructor that takes and sets values for x,y,w,h
 *
 *		In this constructor you will also set xspeed and yspeed to 10.
 *
 * You will need the paint method:public void paint( Graphics window)
 *	 This will draw the ball.
 *	 For the java Graphics methods go to: https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html  
 *
 * You will create a method called bounce:
 *		this method will make the ball move around the screen bounce off the sides
 *
 * (Hint: you will base this class off the box class in the graphics intro project)
 */


//go to graphics intro
//look at Box.java

public class Ball extends Canvas
{
	//instance variables
	private int x, y, w, h, xspeed, yspeed;
	boolean check;
	Color color;
	Image img;

	//constructor
	public Ball() {
		x = 400;
		y = 300;
		w = 100;
		h = 100;
		xspeed = 20;
		yspeed = 20;
		color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
	}
	public Ball(int x, int y, int w, int h, int xspeed, int yspeed) {
		this.x = x; this.y = y; this.w = w; this.h = h; this.xspeed = xspeed; this.yspeed = yspeed;
		color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
	}

	//add paint
	public void paint(Graphics window) {
		
		//image
		window.drawImage(img, x, y, w, h, null);
	    
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setImage(int i, ArrayList<String> dict) {
		img = new ImageIcon(dict.get(i)).getImage();
	}
	
	//method bounce
	public void bounce() {
		//changing size
		if (w >= 250 && h >= 250) {
			check = true;
		}
		if (w <= 50 && h <= 50) {
			check = false;
		}
		int d = (int) (Math.random() * 101);
		if (check) {
			w -= d;
			h -= d;
		}
		else {
			w += d;
			h += d;
		}
		//actual bouncing
		if (x > 685 || x < -50) {
			xspeed *= -1;
		}
		x += xspeed;
		if (y > 500 || y < -50) {
			yspeed *= -1;
		}
		y += yspeed;
	}
}