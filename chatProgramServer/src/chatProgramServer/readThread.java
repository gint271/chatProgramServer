package chatProgramServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class readThread implements Runnable
{
	private Socket connection;
	
	readThread(Socket passConnection)
	{
		connection = passConnection;
	}
	
	public void run()
	{
		BufferedReader reader = null;
		
		try
		{
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
		}
	}
}
