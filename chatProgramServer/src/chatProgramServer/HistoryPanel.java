package chatProgramServer;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class HistoryPanel extends JPanel {
	
	JTextArea textArea;
	
	public HistoryPanel() {
		setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 11, 414, 278);
		add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(423, 11, 27, 278);
		add(scrollPane);

	}
	
	void addLine(String newText)
	{
		//textArea.setText(textArea.getText() + "\n" + newText);
		textArea.insert(newText + "\n", 0);
	}
}
