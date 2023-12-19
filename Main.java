import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame("Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame gamepanel = new Frame();
		
		window.add(gamepanel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
        window.setResizable(true);
		gamepanel.startgamethread();
	}

}