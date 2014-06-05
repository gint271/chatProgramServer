/*
 * Author: Ryan Milem
 * 
 * Programming Assignment 5
 * 
 * 5/28/2014
 * 
 * This class will set up the socket and wait for a connection from ChatProgramClient.  It will then 
 * start two threads, one for input and one for output.
 */

package chatProgramServer;

import java.net.ServerSocket;
import java.net.Socket;


public class ChatProgramServer 
{

	
	public static void main(String[] args) 
	{
		ServerSocket connection = null;
		Socket newSocket = null;
		ChatFrame frame = null;
		
		try
		{
			connection = new ServerSocket(1234);
		}
		catch (Exception e)
		{
			System.out.println("Failed to make server socket.");
			System.exit(2);
		}
		
		while(true)
		{	
			try
			{
				newSocket = connection.accept();
			}
			catch (Exception e)
			{
				System.out.println("Failed to accept new connection.");
				System.exit(2);
			}
			
			try 
			{
				frame = new ChatFrame(newSocket);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			//Begins the input and output threads.
			//new Thread(new writeThread(newSocket, frame)).start();
			//new Thread(new readThread(newSocket, frame)).start();
		}
	}
}
