import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class LeerzEntf extends JFrame {

	private JPanel contentPane;
	private JTextField text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeerzEntf frame = new LeerzEntf();
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
	public LeerzEntf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		this.setTitle("Hab dich lieb:*");
		JLabel tutorial = new JLabel();
		tutorial.setText("In die Box hier unten den Text einfügen & Button klicken");
		contentPane.add(tutorial,BorderLayout.NORTH);
		text = new JTextField();
		contentPane.add(text,BorderLayout.CENTER);
		JButton button = new JButton("Entferne Leerzeichen");
		contentPane.add(button,BorderLayout.SOUTH);
		setContentPane(contentPane);
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				removeSpaces();
			}
			
		});
	}
	private void removeSpaces(){
		String all = text.getText();
		String alt1 = all.replaceAll("\n", "\\s");
		String neu = all.replaceAll("[\\s]+", "\\s");
		text.setText(neu);
	}

}
