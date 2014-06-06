package chatProgramServer;

import java.io.BufferedReader;
<<<<<<< HEAD
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
=======
import java.io.InputStreamReader;
>>>>>>> branch 'master' of https://github.com/gint271/chatProgramServer.git
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
<<<<<<< HEAD
		BufferedReader reader = null;
=======
		String readLine;
>>>>>>> branch 'master' of https://github.com/gint271/chatProgramServer.git
		
		try
		{
<<<<<<< HEAD
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
		}
		catch (Exception e)
		{
			System.out.println("Failed to make reader.");
			System.exit(2);
		}
		
		while(true)
		{
			try
			{
				System.out.println(reader.readLine());
			}
			catch (Exception e)
			{
				System.out.println("Failed to get text from socket.");
				System.exit(2);
			}
=======
			while(null != (readLine = chatReader.readLine()))
			{
				frame.write(readLine);
			}
		}
		catch (Exception e)
		{
			System.out.println("Failed to read line from socket.");
			System.exit(2);
>>>>>>> branch 'master' of https://github.com/gint271/chatProgramServer.git
		}
	}
}
