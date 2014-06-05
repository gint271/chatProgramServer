package chatProgramServer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class ChatFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JScrollPane scrollPane;
	JTextArea textArea;
	BufferedWriter chatWrite;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ChatFrame(Socket chatSocket) {
		
		try
		{
			chatWrite = new BufferedWriter(new OutputStreamWriter(chatSocket.getOutputStream()));
		}
		catch (Exception e)
		{
			System.out.println("Failed to make socket writer.");
			System.exit(2);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 11, 419, 219);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(5, 237, 276, 20);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				System.out.println(arg0.getKeyChar() + " key was hit.");
				if(arg0.getKeyChar() == '\n')
				{
					System.out.println(textField.getText() + " was entered.");
					textArea.setText(textArea.getText() + textField.getText() + "\n");
					try
					{
						chatWrite.write(textField.getText());
						chatWrite.newLine();
						chatWrite.flush();
					}
					catch (Exception e)
					{
						System.out.println("Failed to write to socket.");
					}
					
					textField.setText("");
					
				}
			}
		});
		contentPane.add(textField);
		textField.setColumns(10);	
	}
	
	void write(String message)
	{
		textArea.setText(textArea.getText() + message + "\n");
	}
}
