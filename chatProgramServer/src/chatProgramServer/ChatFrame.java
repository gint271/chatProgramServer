package chatProgramServer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class ChatFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	HistoryPanel panel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ChatFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new HistoryPanel();
		panel.setBounds(5, 0, 403, 226);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setBounds(5, 237, 276, 20);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				System.out.println(arg0.getKeyChar() + " key was hit.");
				if(arg0.getKeyChar() == '\n')
				{
					System.out.println(textField.getText() + " was entered.");
					panel.addLine(textField.getText());
					textField.setText("");
					
				}
			}
		});
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		
		
	}
}
