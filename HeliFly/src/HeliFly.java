import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class HeliFly extends JFrame {

	private int defaultHeight = 10;
	private int defaultLength = 100;
	private JPanel contentPane;
	protected JPanel upperPane;
	protected JPanel lowerPane;
	protected JLabel upperText;
	protected JButton[][] field;
	protected Model model;
	protected Controller controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeliFly frame = new HeliFly();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HeliFly() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setTitle("HeliFly by Justin Guese");
		setContentPane(contentPane);
		upperPane  = new JPanel();
		lowerPane = new JPanel();
		upperPane.setLayout(new BorderLayout());
		lowerPane.setLayout(new GridLayout(10,20));
		contentPane.add(upperPane, BorderLayout.NORTH);
		contentPane.add(lowerPane, BorderLayout.CENTER);
		upperText = new JLabel("TEXT");
		upperPane.add(upperText, BorderLayout.WEST);
		field = new JButton[defaultHeight][defaultLength];
		model =new Model(lowerPane,field);
		controller = new Controller(model);
		
		JButton up = new JButton("Up");
		up.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.upPushed();
			}
		});
		JButton down = new JButton("Down");
		down.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.downPushed();
			}
		});
		upperPane.add(up,BorderLayout.NORTH);
		upperPane.add(down, BorderLayout.SOUTH);
		// Build button listeners
		contentPane.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {
				System.out.println("FUCK ME");
			}
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("FUCK ME");
				controller.actionOccured(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("FUCK ME");
				// DO nothing
			}
		});
	}
	protected void makeUpdate(){
		model.update(lowerPane, field);
	}

}
