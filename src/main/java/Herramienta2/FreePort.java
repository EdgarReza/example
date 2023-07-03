package Herramienta2;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;

public class FreePort implements Closeable {

	private ServerSocket socket;
	
	public FreePort() {
		
	}

	public FreePort(ServerSocket socket) {
		this.socket = socket;
	}

	public ServerSocket getSocket() {
		return socket;
	}

	@Override
	public void close() throws IOException {
		socket.close();
	}


  public  int findFreePort() throws IOException {
	// cf. https://gist.github.com/3429822
	try (FreePort holder = new FreePort(new ServerSocket(0))) {
		holder.getSocket().setReuseAddress(true);
		int port = holder.getSocket().getLocalPort();
		return port;
	}
}
}