package chatProgramServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class readThread implements Runnable
{
	
	private BufferedReader chatReader;
	private ChatFrame frame;
	
	readThread(Socket passConnection, ChatFrame passFrame)
	{
		frame = passFrame;
		
		try
		{
			chatReader = new BufferedReader(new InputStreamReader(passConnection.getInputStream()));
		}
		catch (Exception e)
		{
			System.out.println("Failed to make chat writer.");
			System.exit(2);
		}
	}
	
	public void run()
	{
		BufferedReader reader = null;
		String readLine;
		Boolean readingFine = true;
		
		try
		{
			while(null != (readLine = chatReader.readLine()) && readingFine)
			{
				frame.write(readLine);
			}
		}
		catch (Exception e)
		{
			System.out.println("Failed to read line from socket.  Chat most likely closed.");
			readingFine = false;
			frame.setVisible(false);
		}
	}
}
