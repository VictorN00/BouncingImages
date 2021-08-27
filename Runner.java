import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

class Runner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Runner()
	{
		super("Victor Nguyen | numpad '*' - add ball | numpad '/' - remove ball | esc - close");

		setSize(WIDTH,HEIGHT);

		//uncomment each file when you need to run it
		//comment off any files you are not suing
		

		//once you have your Ball class completed
		//uncomment the following line to test the Ball class
		//getContentPane().add( new Ball(100, 100, 100, 100, 10, 10));	

		//once you have your BouncingBalls class completed
		//uncomment the following line to test your BouncingBalls class
		//comment off the Ball class testing line above
		BouncingBalls test = new BouncingBalls();
		getContentPane().add(test);
		
		validate();
		setVisible(true);
		KeyAdapter listener = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
            	//closes when Esc pressed
            	if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                	dispose();
            	}
            	//adds new ball when numpad "*" is pressed
            	if (e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
            		int wh = (int) (Math.random() * 201 + 50);
            		Ball ball = new Ball((int) (Math.random() * 686), (int) (Math.random() * 461), wh, wh, (int) (Math.random() * 50 + 1), (int) (Math.random() * 50 + 1));
            		ball.setImage((int) (Math.random() * 165), test.dict);
            		test.addBall(ball);
            	}
            	//removes ball when numpad "/" is pressed (if possible)
            	if (e.getKeyCode() == KeyEvent.VK_DIVIDE) {
            		test.removeBall(0);
            	}
            }
        };

        addKeyListener(listener);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		Runner run = new Runner();
	}
}