package chatProgramServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class writeThread implements Runnable
{
	private Socket connection;
	
	writeThread(Socket passConnection, ChatFrame frame)
	{
		connection = passConnection;
	}
	
	public void run()
	{
		BufferedWriter writer = null;
		BufferedReader keyboard = null;
		
		try
		{
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
		}
		catch (Exception e)
		{
			System.out.println("Failed to make writer.");
			System.exit(2);
		}
		
		try
		{
			writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			
		}
		catch (Exception e)
		{
			System.out.println("Failed to make writer.");
			System.exit(2);
		}
		
		while(true)
		{
			
			
			try
			{
				writer.write("test");
				writer.flush();
			}
			catch (Exception e)
			{
				System.out.println("Failed to write to socket.");
				System.exit(2);
			}
		}
	}
}
