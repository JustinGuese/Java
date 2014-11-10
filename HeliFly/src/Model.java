import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Model {
	private int pos;
	private GameRunner gr;
	private PlayerPos playerPos;
	final private int SIZE = 20;
	private JPanel lowerPane;
	private JButton[][] field;
	public Model(JPanel lowerPane, JButton[][] field) {
		this.lowerPane = lowerPane;
		this.field =field;
		pos = 20;
		playerPos = new PlayerPos(field.length/2,1);
		buildBlankField();
		refreshPane();
		gr = new GameRunner(this);
		gr.start();
		field[5][10].setBackground(Color.black);
	}
	

	protected void update(JPanel lowerPane, JButton[][] field){
		this.lowerPane = lowerPane;
		this.field =field;
	}
	protected void buildBlankField(){
		for(int i = 0; i < field.length;i++)
			for(int j = 0; j < field[0].length; j++){
				JButton button = new JButton();
				button.setBackground(Color.WHITE);
				field[i][j] = button;
			}
	// now build player object
	field[field.length/2][1].setBackground(Color.GREEN);
	}
	protected void refreshPane(){
		System.out.println("mODEL: refreshing Pane"+pos);
		if(pos == field[0].length) win();
		else{
			for(int z = 0; z < (SIZE*10);z++) // gives nr to fill the panel
				for(int i = 0; i < 10; i++) // gives rows of ButtonArray
					for(int j = pos-SIZE; j < pos; j++){
						lowerPane.add(field[i][j]);
					}
		}
		field[playerPos.row][playerPos.column].setBackground(Color.GREEN);
	}
	protected void win(){
		Thread myThread = new Thread(){
			public void run(){
		JFrame frame = new JFrame();
		frame.setSize(360, 200);
		JPanel panel = new JPanel();
		JLabel label = new JLabel("YOU WON!!!");
		frame.add(panel);
		panel.setLayout(new BorderLayout());
		panel.add(label,BorderLayout.CENTER);
		frame.setVisible(true);
		try {
			wait(3000);
		} catch (InterruptedException e) {
			System.err.println("Got interrupted in Win() in Model");
			e.printStackTrace();
		}
			}
		};
	}
	protected void movePlayerUp(){
		field[playerPos.row][playerPos.column].setBackground(Color.white);
		if(playerPos.row > 0) playerPos.row--;
		field[playerPos.row][playerPos.column].setBackground(Color.GREEN);
	}
	protected void movePlayerDown(){
		field[playerPos.row][playerPos.column].setBackground(Color.white);
		if(playerPos.row < field.length) playerPos.row++;
		field[playerPos.row][playerPos.column].setBackground(Color.GREEN);
	}
	protected void posUp(){
		pos++;
	}
	protected void posDown(){
		pos--;
	}
}
