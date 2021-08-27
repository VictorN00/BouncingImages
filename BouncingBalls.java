import java.awt.*;
import javax.swing.*;
import java.util.*;

/* You will create the BouncingBalls class
 *
 * It will have 1 instance variable: ArrayList<Ball> balls
 * It will have a default constructor that only initializes the list.
 * 
 * You will write the paint method:
 *		first 2 lines should be to set the background color and 
 *			fill a rectangle with dimensions of 0,0,800,600
 *
 */

class BouncingBalls extends JPanel implements Runnable
{
	private ArrayList<Ball> balls;
	ArrayList<String> dict;
	
	public BouncingBalls()
	{
		setBackground(Color.WHITE);
		
		dict = new ArrayList<String>(Arrays.asList("aguirre.jpg", "akinyemi.jpg", "albrecht.jpg", "anderson.jpg", "andrade.jpg", "anuwe.png", "armstrong.jpg", "arrington.jpg", "atkins.jpg", "austin.png", "bachmann.jpg", "baerenwald.jpg", "baltazar.jpg", "bassett.jpg", "billimek.jpg", "blakeslee.jpg", "bond.jpg", "bontke.jpg", "boyd.jpg", "brandman.jpg", "brannonreese.jpg", "britt.jpg", "brown.jpg", "browning.jpg", "bush.jpg", "caballero.jpg", "calvert.jpg", "campbell.png", "carter.jpg", "casillas.jpg", "chacon.jpg", "chang.jpg", "clifton.png", "cross.jpg", "crosson.jpg", "dale.jpg", "dangelo.jpg", "dickerson.jpg", "dodd.jpg", "drake.jpg", "draudt.jpg", "ealand.jpg", "ellis.jpg", "english.jpg", "escobar.jpg", "ewing.jpg", "ferrer.jpg", "flores.jpg", "fort.jpg", "fox.jpg", "franer.jpg", "funderburg.jpg", "gentry.jpg", "gillihan.jpg", "gonzalez.jpg", "gorman.jpg", "gregory.jpg", "hall.jpg", "harbrueger.jpg", "harville.jpg", "heath.jpg", "henry.jpg", "hill.jpg", "hootonbyargeon.jpg", "hoover.jpg", "hubbard.jpg", "hudson.jpg", "hunt.jpg", "hunt2.jpg", "jarvis.jpg", "johns.jpg", "johnson.jpg", "johnson2.jpg", "jones.jpg", "kenny.jpg", "kent.jpg", "kinninger.jpg", "kinnison.jpg", "koshak.jpg", "kotter.jpg", "kraemer.jpg", "krus.jpg", "kutac.png", "lands.jpg", "lane.jpg", "lausell.jpg", "lauver.jpg", "leonard.jpg", "lindsey.jpg", "lubojasky.jpg", "lyons.jpg", "maddox.jpg", "marsh.jpg", "marucci.png", "mati", "mayer.jpg", "mcclellan.jpg", "meischen.jpg", "monceaux.png", "mosquera.jpg", "napier.jpg", "navarrete.jpg", "nelson.png", "oliver.jpg", "omick.jpg", "payne.jpg", "perez.jpg", "peret.jpg", "peterman.jpg", "prado.jpg", "prewitt.jpg", "pridgeon.png", "pridgeon2.jpg", "prieto.jpg", "puckett.png", "pumphrey.jpg", "ratliff.jpg", "rice.jpg", "richardson.jpg", "rivard.jpg", "roberson.jpg", "rogers.jpg", "rosenbaum.jpg", "ross.jpg", "ruiz.jpg", "salinas.jpg", "salinas2.jpg", "sanchez.jpg", "santaigoguzman.jpg", "schroller.jpg", "self.jpg", "shadoan.jpg", "sigler.jpg", "singletary.jpg", "slaughter.jpg", "solis.jpg", "sprague.jpg", "stephanow.jpg", "stephens.jpg", "stolz.jpg", "stuart.jpg", "tillman.jpg", "toliver.jpg", "tolkov.jpg", "towle.jpg", "turnbow.jpg", "turnbow2.jpg", "tyler.jpg", "villareal.jpg", "villareal2.jpg", "walker.jpg", "waneck.jpg", "weinsteni.jpg", "white.jpg", "whitmore.jpg", "whitson.jpg", "williamson.png", "wilson.jpg", "wilson2.jpg", "winter.jpg", "witcher.jpg", "womack.jpg", "wong.jpg", "yates.jpg", "zarate.jpg"));
		
		//initialize and fill the ArrayList of balls
		// with 8 balls that are randomly places on the screen
		// screen size is 800 x 600
		// make the width and height both 100
		
		balls = new ArrayList<Ball>();
		for (int asdf = 0; asdf < 165; asdf++) {
			int wh = (int) (Math.random() * 201 + 50);
			Ball ball = new Ball((int) (Math.random() * 686), (int) (Math.random() * 461), wh, wh, (int) (Math.random() * 50 + 1), (int) (Math.random() * 50 + 1));
			ball.setImage(asdf, dict);
			balls.add(ball);
			
		}
		new Thread(this).start();
	}
	
	//for hotkeys
	public void addBall(Ball ball) {
		balls.add(ball);
	}
	
	public void removeBall(int index) {
		if (index < balls.size()) {
			balls.remove(index);
		}
	}

	public void paint( Graphics window )
	{
		//seizure warning
		window.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
		
		//halloween background
		/*window.setColor(new Color(40, 6, 70));*/
		window.fillRect( 0,0, 800, 600);
		
		//paint the list of balls and make them bounce
		//for loop through the list of Balls
		//call paint on each Ball
		for (Ball ball : balls) {
			ball.paint(window);
			ball.bounce();
		}
		
	}
	
	public void run()
	{

		try
		{
			while( true )
			{	
				Thread.sleep(50);
				repaint();
			}
		}
		catch( Exception e )
		{
			
		}

	}
}