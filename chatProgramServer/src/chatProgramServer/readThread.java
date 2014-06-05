package chatProgramServer;

import java.net.Socket;

public class readThread implements Runnable
{
	private Socket connection;
	
	readThread(Socket passConnection, ChatFrame frame)
	{
		connection = passConnection;
	}
	
	public void run()
	{
		
	}
}
